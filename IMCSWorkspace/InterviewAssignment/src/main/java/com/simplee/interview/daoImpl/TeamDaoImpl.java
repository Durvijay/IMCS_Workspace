package com.simplee.interview.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simplee.interview.dao.TeamDao;
import com.simplee.interview.entity.Team;
import com.simplee.interview.util.DatabaseConnection;

public class TeamDaoImpl implements TeamDao{
public TeamDaoImpl() {
	// TODO Auto-generated constructor stub
}
	public Team addTeam(Team team) {
		Connection con = DatabaseConnection.getConnection();
		String sqlQuery = "INSERT INTO `"+DatabaseConnection.getDB_NAME()+"`.`TEAM` (`NAME`,`IS_ACTIVE`) VALUES (?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sqlQuery);
			pstmt.setString(1, team.getName());
			pstmt.setString(2, Boolean.toString(true));
			int teamAdd = pstmt.executeUpdate();
			System.out.println("team added successfull " + teamAdd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getTeamByName(team);
	}

	public Team getTeam(int id) {
		Team team=null;
		Connection connection = DatabaseConnection.getConnection();

		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("SELECT * FROM `"+DatabaseConnection.getDB_NAME()+"`.`TEAM` where `ID` = ? and IS_ACTIVE='true'");
			pstmt.setInt(1, id);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				team = new Team();
				team.setId(resultSet.getInt("ID"));
				team.setName(resultSet.getString("NAME"));
				team.setActive(Boolean.parseBoolean(resultSet.getString("IS_ACTIVE")));
				return team;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return team;
	}

	public Team deleteTeam(int id) {
		int teamUpdate = 0;
		Team team = getTeam(id);
		if(team==null)
			return null;
		try {
			System.out.println("in deleteTeam daoImpl");
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection
					.prepareStatement("UPDATE `"+DatabaseConnection.getDB_NAME()+"`.`TEAM` SET `IS_ACTIVE`='false' WHERE `ID`="
							+ id);
			teamUpdate = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Failed to update status" + e);
			e.printStackTrace();
		}
		return team;
	}

	public Team getTeamByName(Team team) {
		Connection connection = DatabaseConnection.getConnection();
		Team resultTeam=null;
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("SELECT * FROM `"+DatabaseConnection.getDB_NAME()+"`.`TEAM` where `NAME` = ? and IS_ACTIVE='true'");

			pstmt.setString(1, team.getName());
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				resultTeam = new Team();
				resultTeam.setId(resultSet.getInt("ID"));
				resultTeam.setName(resultSet.getString("NAME"));
				resultTeam.setActive(Boolean.parseBoolean(resultSet.getString("IS_ACTIVE")));
				return resultTeam;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultTeam;
	}

	public List<Team> getAllTeams() {
		List<Team> teams=new ArrayList<Team>();
		Connection connection = DatabaseConnection.getConnection();

		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("SELECT * FROM `"+DatabaseConnection.getDB_NAME()+"`.`TEAM` where IS_ACTIVE='true'");
			//pstmt.setInt(1, id);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Team team = new Team();
				team.setId(resultSet.getInt("ID"));
				team.setName(resultSet.getString("NAME"));
				team.setActive(Boolean.parseBoolean(resultSet.getString("IS_ACTIVE")));
				teams.add(team);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teams;
	}

}