package com.praveen.android.teams.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.praveen.android.teams.R
import com.praveen.android.teams.ui.theme.Black700
import com.praveen.android.teams.ui.theme.Gray
import com.praveen.android.teams.ui.theme.White
import com.praveen.android.teams.ui.theme.elevation_2
import com.praveen.android.teams.viewmodel.QRScanViewmodel

@Composable
fun QrCodeSreen(navController: NavController, qrScanViewmodel: QRScanViewmodel) {
    val bitmap = qrScanViewmodel.getQRCode("https://example.com/ti/eyJpbnZpdGVJZ")
    Column {
        TopAppBar(
            title = {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(R.string.teamsBack), modifier = Modifier
                        .clickable {
                            navController.popBackStack("invitemembers", inclusive = false)
                        }, color = White, textAlign = TextAlign.Start, fontSize = 14.sp)
                    Text(modifier = Modifier.fillMaxWidth(.8F), text = stringResource(R.string.teamsMy_QR_Code), textAlign = TextAlign.Center, color = White)

                }            },

            backgroundColor = Black700,
            contentColor = Gray,
            elevation = elevation_2
        )
        Image(modifier = Modifier.align(Alignment.CenterHorizontally), bitmap = bitmap!!.asImageBitmap(), contentDescription = "")
    }
}
