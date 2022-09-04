package com.praveen.android.teams.viewmodel

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.praveen.android.teams.model.InviteMemberModel
import com.praveen.android.teams.repository.responsemodel.PermissionResponse
import com.praveen.android.teams.repository.responsemodel.Teams
import javax.inject.Inject

class InviteMembersViewModel @Inject constructor(val inviteMemberModel: InviteMemberModel): ViewModel(){

    fun postInvitationPermission(teamId: String): LiveData<PermissionResponse> {
       return inviteMemberModel.postInvitationPermission(teamId)
    }

    fun getTeamsInformation(teamId: String): LiveData<Teams> {
        return inviteMemberModel.getTeamsInformation(teamId)
    }

    fun copytoClipBoard(qrcodeText: String, context: Context){
        inviteMemberModel.copytoClipBoard(qrcodeText,context)
    }

    fun getListOfInvitees(context: Context, teams: State<Teams?>): LiveData<List<String>?>{
       return inviteMemberModel.getListOfInvitees(context, teams)
    }
}

