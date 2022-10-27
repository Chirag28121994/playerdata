package com.makemyteam.playerdata.repository

import com.makemyteam.playerdata.UserInfo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PlayerRepository : MongoRepository<UserInfo, Int> {
    @Query("{'playerName':?0}")
    fun findByName(playerName: String): Optional<UserInfo>
}