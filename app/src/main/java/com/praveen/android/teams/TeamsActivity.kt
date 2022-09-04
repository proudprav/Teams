package com.praveen.android.teams

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.praveen.android.teams.application.TeamsApplication
import com.praveen.android.teams.di.APIComponent
import com.praveen.android.teams.ui.composable.HomeScreenComposable
import com.praveen.android.teams.ui.theme.TeamsTheme
import javax.inject.Inject

class TeamsActivity  : AppCompatActivity() {
    @Inject
    lateinit var homeScreenComposable: HomeScreenComposable
    private var apiComponent: APIComponent = TeamsApplication.apiComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            TeamsTheme {
                Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
                    homeScreenComposable.ContentView()
                }
            }
        }
        apiComponent.inject(this)
    }
}

