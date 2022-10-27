package com.makemyteam.playerdata.controller

import com.makemyteam.playerdata.MatchInfo
import com.makemyteam.playerdata.service.MatchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/match")
class MatchController(
    @Autowired val matchService: MatchService
) {
    @PostMapping()
    fun addMatch(@RequestBody match: MatchInfo): ResponseEntity<String> {
        matchService.addMatch(match)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PatchMapping()
    fun updateMatchInfo(@RequestBody match: MatchInfo): ResponseEntity<String> {
        matchService.updateMatch(match)
        return ResponseEntity.ok().build()
    }

    @GetMapping()
    fun getAllMatches(): ResponseEntity<List<MatchInfo>> =
        ResponseEntity.ok(matchService.getAllMatches())

    @GetMapping("/{name}")
    fun getMatchByName(@PathVariable name: String): ResponseEntity<MatchInfo> =
        ResponseEntity.ok(matchService.getMatchByName(name))

    @DeleteMapping("/{teamId}")
    fun deleteTeam(@PathVariable matchId: Int): ResponseEntity<String> {
        matchService.deleteMatchById(matchId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}