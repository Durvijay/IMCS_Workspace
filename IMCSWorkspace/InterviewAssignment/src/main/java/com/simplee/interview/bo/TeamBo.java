package com.simplee.interview.bo;

import java.util.List;

import com.simplee.interview.entity.Team;



public interface TeamBo {
	Team addTeam(String teamName);
	Team getTeamByName(String teamName)/* throws TeamNotFoundException */;
	Team getTeam(int id)/* throws TeamNotFoundException*/;
	Team deleteTeam(int id);
	List<Team> getAllTeams();
	
}
