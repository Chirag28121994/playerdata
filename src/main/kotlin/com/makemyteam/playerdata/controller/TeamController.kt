package com.makemyteam.playerdata.controller

import com.makemyteam.playerdata.TeamInfo
import com.makemyteam.playerdata.service.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/team")
class TeamController(
    @Autowired val teamService: TeamService
) {

    @PostMapping()
    fun addTeam(@RequestBody team: TeamInfo): ResponseEntity<String> {
        teamService.addTeam(team)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PatchMapping()
    fun updateTeamInfo(@RequestBody team: TeamInfo): ResponseEntity<String> {
        teamService.updateTeam(team)
        return ResponseEntity.ok().build()
    }

    @GetMapping()
    fun getAllTeams(): ResponseEntity<List<TeamInfo>> =
        ResponseEntity.ok(teamService.getAllTeams())

    @GetMapping("/{name}")
    fun getTeamByName(@PathVariable name: String): ResponseEntity<TeamInfo> =
        ResponseEntity.ok(teamService.getTeamByName(name))

    @DeleteMapping("/{teamId}")
    fun deleteTeam(@PathVariable teamId: Int): ResponseEntity<String> {
        teamService.deleteTeamById(teamId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}