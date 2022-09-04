package com.praveen.android.teams.repository.responsemodel

import com.google.gson.annotations.SerializedName

data class Teams (
    @SerializedName("id"      ) var id      : String?  = null,
    @SerializedName("members" ) var members : Members? = Members(),
    @SerializedName("plan"    ) var plan    : Plan?    = Plan()
)
