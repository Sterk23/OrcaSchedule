package com.example.sterk.orcaschedule.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sterk on 8/17/2019.
 */
data class ListMatches(
        @SerializedName("items")
        val matches: ArrayList<Match>
)