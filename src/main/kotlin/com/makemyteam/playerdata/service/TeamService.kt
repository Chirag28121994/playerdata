package com.makemyteam.playerdata.service

import com.makemyteam.playerdata.TeamInfo
import com.makemyteam.playerdata.repository.TeamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeamService (@Autowired val teamRepository: TeamRepository){
    fun addTeam(teamInfo: TeamInfo): TeamInfo = teamRepository.insert(teamInfo)

    fun updateTeam(teamInfo: TeamInfo) {
        var savedTeam: TeamInfo = teamRepository
            .findById(teamInfo.teamId)
            .orElseThrow { throw RuntimeException("Cannot find Expense by ID ") }
        savedTeam.teamMembers = teamInfo.teamMembers
        savedTeam.teamCaption = teamInfo.teamCaption
        savedTeam.teamName = teamInfo.teamName
        savedTeam.teamProfilePicture = teamInfo.teamProfilePicture
        teamRepository.save(savedTeam)
    }

    fun getAllTeams(): List<TeamInfo> = teamRepository.findAll()

    fun getTeamByName(teamName: String): TeamInfo = teamRepository.findByName(teamName = teamName)
        .orElseThrow { throw RuntimeException("Cannot find Expense by Id ") }

    fun deleteTeamById(teamId: Int) = teamRepository.deleteById(teamId)
}