package com.praveen.android.teams.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.praveen.android.teams.application.TeamsApplication
import com.praveen.android.teams.di.APIComponent
import com.praveen.android.teams.repository.responsemodel.PermissionResponse
import com.praveen.android.teams.repository.responsemodel.Teams
import com.praveen.android.teams.utility.Utils
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject


class RetrofitRepository {
    private var apiComponent: APIComponent = TeamsApplication.apiComponent

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var gson: Gson

    init {
        apiComponent.inject(this)
    }

    fun postInvitationPermission(teamId: String): LiveData<PermissionResponse> {
        val apiService: APIService = retrofit.create(APIService::class.java)
        val requestBody: RequestBody =
            RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                Utils().loadJSONFile("role.json")
            )

        val listOfNews = apiService.postInvitationPermission(teamId, requestBody)
        val res: MutableLiveData<PermissionResponse> = MutableLiveData()
        listOfNews.enqueue(object : Callback<PermissionResponse> {
            override fun onResponse(
                call: Call<PermissionResponse>, response: Response<PermissionResponse>
            ) {
                if (response.isSuccessful) {
                    res.value = response.body()
                }
            }

            override fun onFailure(call: Call<PermissionResponse>, t: Throwable) {
                Log.d("RetroRepository", "Failed:::" + t.message)
            }
        })

        return res
    }

    fun getTeamInformation(teamId: String): LiveData<Teams> {
        val apiService: APIService = retrofit.create(APIService::class.java)
        val listOfNews = apiService.getTeamInformation(teamId)
        var res: MutableLiveData<Teams> = MutableLiveData()
        listOfNews.enqueue(object : Callback<Teams> {
            override fun onResponse(
                call: Call<Teams>, response: Response<Teams>
            ) {
                if (response.isSuccessful) {
                    res.value = response.body()!!
                }
            }

            override fun onFailure(call: Call<Teams>, t: Throwable) {
                Log.d("RetroRepository", "Failed:::" + t.message)
            }
        })

        return res
    }


}



