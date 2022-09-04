package com.praveen.android.teams.ui.composable

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.praveen.android.teams.viewmodel.InviteMembersViewModel
import com.praveen.android.teams.viewmodel.QRScanViewmodel
import javax.inject.Inject
import javax.inject.Named

class HomeScreenComposable @Inject constructor(@Named("View_Model_Factory") var viewModelFactory: ViewModelProvider.Factory): AbstractComposable() {

    @Composable
    override fun ContentView() {
        val qrScanViewModel: QRScanViewmodel = viewModel(factory = viewModelFactory)
        val inviteMembersViewModel: InviteMembersViewModel = viewModel(factory = viewModelFactory)
        val navController = rememberNavController()
        NavHost(navController, startDestination = "home") {
            composable(route = "home") {
                HomeScreen(navController)
            }
            composable(route = "invitemembers") {
                InviteMembersScreen(navController, inviteMembersViewModel)
            }
            composable(route = "qrcodescreen") {
                QrCodeSreen(navController, qrScanViewModel)
            }
        }
    }
}
