package com.praveen.android.teams.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.praveen.android.teams.R
import com.praveen.android.teams.ui.theme.Black700
import com.praveen.android.teams.ui.theme.Gray
import com.praveen.android.teams.ui.theme.White
import com.praveen.android.teams.ui.theme.elevation_2

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        TopAppBar(
            title =  {
                Text(modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,text = stringResource(R.string.teamsTeams), color = White)
            },
            backgroundColor = Black700,
            contentColor = Gray,
            elevation = elevation_2
        )

        Box(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.CenterHorizontally),
        contentAlignment = Alignment.Center){
            Button(onClick = { navController.navigate("invitemembers") }) {
                Text(stringResource(R.string.teamsInvite_Members))
            }

        }
    }
}
