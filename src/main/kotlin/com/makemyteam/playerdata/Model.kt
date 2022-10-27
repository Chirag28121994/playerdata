package com.makemyteam.playerdata

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document(collection = "players")
data class UserInfo(
    @Id
    val userId: Int,
    @Field(name = "profilePicture")
    var profilePicture: String?,
    @Field(name = "userName")
    var userName: String,
    @Field(name = "userFirstName")
    val userFirstname: String,
    @Field(name = "userLastName")
    val userLastName: String,
    @Field(name = "userDesignation")
    var userDesignation: String,
    @Field(name = "userContactNumber")
    var userContactNumber: String
)
@Document (collection = "teams")
data class TeamInfo(
    @Id
    val teamId: Int,
    var teamProfilePicture: String?,
    @Field(name = "teamName")
    var teamName: String,
    @Field(name = "teamCaption")
    var teamCaption: String?,
    @Field(name = "teamMembers")
    var teamMembers: List<UserInfo>?
)
@Document (collection = "matches")
data class MatchInfo(
    @Id
    val matchId: Int,
    @Field(name = "matchName")
    var matchName: String,
    @Field(name = "matchDate")
    var matchDate: LocalDateTime?,
    @Field(name = "userTeam")
    var userTeam: TeamInfo?,
    @Field(name = "oppositionTeam")
    var oppositionTeam: TeamInfo?
)