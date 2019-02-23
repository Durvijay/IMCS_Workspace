package com.simplee.interview.boImpl;

import java.util.List;

import com.simplee.interview.bo.TeamBo;
import com.simplee.interview.dao.TeamDao;
import com.simplee.interview.daoImpl.TeamDaoImpl;
import com.simplee.interview.entity.Team;

public class TeamBoImpl implements TeamBo {
	public TeamBoImpl() {
		// TODO Auto-generated constructor stub
	}

	public Team addTeam(String teamName) {
		TeamDao teamDao = new TeamDaoImpl();
		Team team = new Team(teamName);
		return teamDao.addTeam(team);
	}

	public Team getTeam(int id) /* throws TeamNotFoundException */ {
		TeamDao teamDao = new TeamDaoImpl();
		Team team = teamDao.getTeam(id);
		/*
		 * if(team == null) throw new TeamNotFoundException(id);
		 */
		return team;
	}

	public Team getTeamByName(String teamName)/* throws TeamNotFoundException */ {
		TeamDao teamDao = new TeamDaoImpl();
		Team team = new Team(teamName);
		team = teamDao.getTeamByName(team);
		/*
		 * if(team==null) throw new TeamNotFoundException(teamName);
		 */
		return team;
	}

	public Team deleteTeam(int id) {
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.deleteTeam(id);
	}

	public List<Team> getAllTeams() {
		TeamDao teamDao = new TeamDaoImpl();
		return teamDao.getAllTeams();
	}

	public static void main(String[] args) {
		List<Team> teams = new TeamBoImpl().getAllTeams();
		for (Team t : teams) {
			System.out.println(t.getName());
		}
	}
}
