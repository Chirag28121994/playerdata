package com.makemyteam.playerdata.repository

import com.makemyteam.playerdata.MatchInfo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MatchRepository : MongoRepository<MatchInfo, Int> {
    @Query("{'matchName':?0}")
    fun findByName(matchName: String): Optional<MatchInfo>
}