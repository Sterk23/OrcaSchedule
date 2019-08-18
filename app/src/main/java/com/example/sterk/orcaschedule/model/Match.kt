package com.example.sterk.orcaschedule.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sterk on 8/17/2019.
 */
data class Match(
        @SerializedName("Team 1")
        val team1: String,
        @SerializedName("Team 2")
        val team2: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("time")
        val time:String,
        @SerializedName("Tour")
        val tour:String
)