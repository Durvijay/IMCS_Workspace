package com.simplee.interview.dao;

import java.util.List;

import com.simplee.interview.entity.Team;

public interface TeamDao {

	Team addTeam(Team team);

	Team getTeam(int id);

	Team deleteTeam(int id);

	Team getTeamByName(Team team);

	List<Team> getAllTeams();

}
