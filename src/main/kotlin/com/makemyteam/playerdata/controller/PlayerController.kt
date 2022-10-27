package com.makemyteam.playerdata.controller

import com.makemyteam.playerdata.UserInfo
import com.makemyteam.playerdata.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/player")
class PlayerController(
    @Autowired val playerService: PlayerService
) {
    @PostMapping()
    fun addPlayer(@RequestBody player: UserInfo): ResponseEntity<String> {
        playerService.addPlayer(player)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PatchMapping()
    fun updatePlayerInfo(@RequestBody player: UserInfo): ResponseEntity<String> {
        playerService.updatePlayer(player)
        return ResponseEntity.ok().build()
    }

    @GetMapping()
    fun getAllPlayers(): ResponseEntity<List<UserInfo>> =
        ResponseEntity.ok(playerService.getAllPlayers())

    @GetMapping("/{name}")
    fun getPlayerByName(@PathVariable name: String): ResponseEntity<UserInfo> =
        ResponseEntity.ok(playerService.getPlayerByUserName(name))

    @DeleteMapping("/{playerId}")
    fun deletePlayer(@PathVariable playerId: Int): ResponseEntity<String> {
        playerService.deletePlayerById(playerId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}