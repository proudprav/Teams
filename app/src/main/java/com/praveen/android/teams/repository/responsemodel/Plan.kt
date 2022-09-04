package com.praveen.android.teams.repository.responsemodel

import com.google.gson.annotations.SerializedName


data class Plan (

  @SerializedName("memberLimit"    ) var memberLimit    : Int? = null,
  @SerializedName("supporterLimit" ) var supporterLimit : Int? = null

)
