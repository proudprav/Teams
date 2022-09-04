package com.praveen.android.teams.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.praveen.android.teams.R
import com.praveen.android.teams.ui.theme.*
import com.praveen.android.teams.viewmodel.InviteMembersViewModel
import kotlinx.coroutines.delay

@Composable
fun InviteMembersScreen(
    navController: NavController,
    inviteMembersViewModel: InviteMembersViewModel,

    ) {
    val context = LocalContext.current
    val inviteMemberState = inviteMembersViewModel.getTeamsInformation("anyId").observeAsState()
    val invitePermissionState = inviteMembersViewModel.postInvitationPermission("anyId").observeAsState()
    var mExpanded by remember { mutableStateOf(false) }
    val mInvities = inviteMembersViewModel.getListOfInvitees(context, inviteMemberState).observeAsState()
    var mSelectedText by remember { mutableStateOf(mInvities.value?.get(0) ?:"") }
    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    LaunchedEffect(inviteMemberState) {
        delay(500)
         mSelectedText = mInvities.value?.get(0) ?:""

    }
    Column {
        TopAppBar(
            title = {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    stringResource(R.string.teamsBack).let {
                        Text(text = it, modifier = Modifier
                            .clickable {
                                navController.popBackStack("home", inclusive = false)
                            }, color = White, textAlign = TextAlign.Start, fontSize = 14.sp)
                    }
                    Text(modifier = Modifier.fillMaxWidth(.8F), text = stringResource(R.string.teamsInvite_Members), textAlign = TextAlign.Center, color = White)
                }
            },
            backgroundColor = Black700,
            contentColor = Gray,
            elevation = 2.dp
        )
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding_12)
            ) {
                Text(modifier = Modifier.align(Alignment.CenterStart) ,text = "Current Members ${inviteMemberState.value?.members?.total?.minus(inviteMemberState.value?.members?.supporters?:0)}", color = DarkGray)
                Text(modifier = Modifier.align(Alignment.CenterEnd), text = "Limit ${inviteMemberState.value?.plan?.memberLimit}", color = DarkGray)
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(padding_12))  {
                Text(modifier = Modifier.align(Alignment.CenterStart), text = "Current Supporters ${inviteMemberState.value?.members?.supporters}", color = DarkGray)
                Text(modifier = Modifier.align(Alignment.CenterEnd), text = "Limit ${inviteMemberState.value?.plan?.supporterLimit}", color = DarkGray)
            }
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(padding_12, padding_0),text =stringResource(R.string.teamsInvite_Permissions), color = DarkGray)
        }


        
        Column(Modifier.padding(padding_12)) {
            OutlinedTextField(
                value = mSelectedText,
                onValueChange = { mSelectedText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        mTextFieldSize = coordinates.size.toSize()
                    },
                readOnly = true,
                trailingIcon = {
                    Icon(icon,stringResource(R.string.teamscontentDescription),
                        Modifier.clickable { mExpanded = !mExpanded })
                }
            )

            DropdownMenu(modifier = Modifier
                .fillMaxWidth(),
                expanded = mExpanded,
                onDismissRequest = { mExpanded = false },

                ) {
                mInvities.value?.forEach { label ->
                    DropdownMenuItem(onClick = {
                        mSelectedText = label
                        mExpanded = false
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
        Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = stringResource(R.string.teamsInvite_URLs_are_valid_for_7_days_Permissions_can_be_n_changed_from_the_member_management_view), textAlign = TextAlign.Center, color = Gray)
        Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = stringResource(R.string.teamsWhat_are_the_Permissions), textAlign = TextAlign.Center, color = DarkGray, fontSize = 15.sp)

        Button(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)
            .padding(padding_12, padding_4), onClick = { navController.navigate("qrcodescreen") }) {
            Text(stringResource(R.string.teamsShare_QR_Code))
        }
        Button(modifier = Modifier
            .padding(padding_12, padding_4)
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally), onClick = { inviteMembersViewModel.copytoClipBoard(invitePermissionState.value?.url?:"", context) }) {
            Text(stringResource(R.string.teamsCopy_Link))
        }
    }

}




