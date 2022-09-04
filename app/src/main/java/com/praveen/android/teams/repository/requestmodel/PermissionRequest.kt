package com.praveen.android.teams.repository.requestmodel

import com.google.gson.annotations.SerializedName

data class PermissionRequest(
    @SerializedName("role")var role : String? = null
)
