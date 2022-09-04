package com.praveen.android.teams.repository

import com.praveen.android.teams.repository.responsemodel.PermissionResponse
import com.praveen.android.teams.repository.responsemodel.Teams
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @GET("/teams/{teamId}")
    fun getTeamInformation(@Query("teamId") teamId: String): Call<Teams>

    @POST("/teams/{teamId}/invites")
    fun postInvitationPermission(@Query("teamId") teamId: String, @Body permissionRequest: RequestBody):Call<PermissionResponse>
}