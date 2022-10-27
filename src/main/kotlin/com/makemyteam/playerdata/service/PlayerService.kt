package com.makemyteam.playerdata.service

import com.makemyteam.playerdata.UserInfo
import com.makemyteam.playerdata.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerService(@Autowired val playerRepository: PlayerRepository) {
        fun addPlayer(playerInfo: UserInfo): UserInfo = playerRepository.insert(playerInfo)

        fun updatePlayer(userInfo: UserInfo) {
            var savedTeam: UserInfo = playerRepository
                .findById(userInfo.userId)
                .orElseThrow { throw RuntimeException("Cannot find Expense by ID ") }
            savedTeam.profilePicture = userInfo.profilePicture
            savedTeam.userName = userInfo.userName
            savedTeam.userDesignation = userInfo.userDesignation
            savedTeam.userContactNumber = userInfo.userContactNumber
            playerRepository.save(savedTeam)
        }

        fun getAllPlayers(): List<UserInfo> = playerRepository.findAll()

        fun getPlayerByUserName(playerName: String): UserInfo = playerRepository.findByName(playerName = playerName)
            .orElseThrow { throw RuntimeException("Cannot find Expense by Name ") }

        fun deletePlayerById(playerId: Int) = playerRepository.deleteById(playerId)

    }