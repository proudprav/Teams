package com.praveen.android.teams.di


import com.praveen.android.teams.TeamsActivity
import com.praveen.android.teams.application.AppModule
import com.praveen.android.teams.repository.RetrofitRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface APIComponent {

    fun inject(retrofitRepository: RetrofitRepository)

    fun inject(mainActivity: TeamsActivity)

}