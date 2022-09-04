package com.praveen.android.teams.application

import android.app.Application
import android.content.Context
import com.praveen.android.teams.di.APIComponent
import com.praveen.android.teams.di.ApiModule
import com.praveen.android.teams.di.DaggerAPIComponent
import com.praveen.android.teams.repository.ApiURL


class TeamsApplication : Application() {

    companion object {
        var ctx: Context? = null
        lateinit var apiComponent: APIComponent

    }

    override fun onCreate() {
        super.onCreate();
        ctx = applicationContext
        apiComponent = initDaggerComponent()
    }

    private fun initDaggerComponent(): APIComponent {
        apiComponent = DaggerAPIComponent
            .builder()
            .apiModule(ApiModule(ApiURL.BASE_URL))
            .appModule(AppModule(this))
            .build()
        return apiComponent
    }

}
