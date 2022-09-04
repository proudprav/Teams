package com.praveen.android.teams.repository.responsemodel

import com.google.gson.annotations.SerializedName

data class Members (
  @SerializedName("total"          ) var total          : Int? = null,
  @SerializedName("administrators" ) var administrators : Int? = null,
  @SerializedName("managers"       ) var managers       : Int? = null,
  @SerializedName("editors"        ) var editors        : Int? = null,
  @SerializedName("members"        ) var members        : Int? = null,
  @SerializedName("supporters"     ) var supporters     : Int? = null

)
