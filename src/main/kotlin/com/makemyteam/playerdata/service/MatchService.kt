package com.makemyteam.playerdata.service

import com.makemyteam.playerdata.MatchInfo
import com.makemyteam.playerdata.repository.MatchRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MatchService (@Autowired val matchRepository: MatchRepository){
    fun updateMatch(matchInfo: MatchInfo) {
    var savedMatch: MatchInfo = matchRepository
        .findById(matchInfo.matchId)
        .orElseThrow { throw RuntimeException("Cannot find Expense by ID ") }
    savedMatch.matchDate = matchInfo.matchDate
    savedMatch.oppositionTeam = matchInfo.oppositionTeam
    savedMatch.userTeam = matchInfo.userTeam
    matchRepository.save(savedMatch)
}

    fun addMatch(matchInfo: MatchInfo): MatchInfo = matchRepository.insert(matchInfo)

    fun getAllMatches(): List<MatchInfo> = matchRepository.findAll()

    fun getMatchById(matchId: Int): MatchInfo = matchRepository.findById(matchId)
        .orElseThrow { throw RuntimeException("Cannot find Expense by Id ") }

    fun deleteMatchById(id: Int) = matchRepository.deleteById(id)

    fun getMatchByName(teamName: String): MatchInfo = matchRepository.findByName(teamName)
        .orElseThrow { throw RuntimeException("Cannot find Expense by Id ") }
}