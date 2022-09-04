package com.praveen.android.teams.model

import android.content.Context
import androidx.compose.runtime.State
import androidx.lifecycle.LiveData
import com.praveen.android.teams.repository.responsemodel.PermissionResponse
import com.praveen.android.teams.repository.responsemodel.Teams

interface InviteMemberModel {
    fun postInvitationPermission(teamId: String): LiveData<PermissionResponse>
    fun getTeamsInformation(teamId: String): LiveData<Teams>
    fun copytoClipBoard(qrcodeText: String, context: Context)
    fun getListOfInvitees(context: Context,inviteMemberState: State<Teams?>): LiveData<List<String>?>
}