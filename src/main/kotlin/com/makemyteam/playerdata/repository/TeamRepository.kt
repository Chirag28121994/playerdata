package com.makemyteam.playerdata.repository

import com.makemyteam.playerdata.TeamInfo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TeamRepository : MongoRepository<TeamInfo, Int> {
    @Query("{'teamName':?0}")
    fun findByName(teamName: String): Optional<TeamInfo>
}