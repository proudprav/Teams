package com.praveen.android.teams.model

import android.content.Context
import androidx.compose.runtime.State
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.praveen.android.teams.R
import com.praveen.android.teams.repository.RetrofitRepository
import com.praveen.android.teams.repository.responsemodel.PermissionResponse
import com.praveen.android.teams.repository.responsemodel.Teams
import com.praveen.android.teams.utility.Utils
import javax.inject.Inject

class InviteMemberModelImpl @Inject constructor(val retrofitRepository: RetrofitRepository): InviteMemberModel {
    override fun postInvitationPermission(
        teamId: String,
    ): LiveData<PermissionResponse> {
        return retrofitRepository.postInvitationPermission(teamId)
    }

    override fun getTeamsInformation(teamId: String): LiveData<Teams> {
       return retrofitRepository.getTeamInformation(teamId)
    }

    override fun copytoClipBoard(qrcodeText: String, context: Context) {
        Utils().copytoClipBoard(qrcodeText, context)
    }

    override fun getListOfInvitees(context: Context,inviteMemberState: State<Teams?>): LiveData<List<String>?> {

        val mutableListOfInvitees =  MutableLiveData<List<String>?>()
        var listOfInvites : ArrayList<String>? =null
        val teamMembers = inviteMemberState.value?.members
        val limitOfMembers = inviteMemberState.value?.plan
        if(((teamMembers?.total?.minus(teamMembers.supporters ?: 0))
                ?: 0) < (limitOfMembers?.memberLimit ?: 0)
        ) { if(listOfInvites == null){
            listOfInvites = ArrayList()
        }
            listOfInvites.add(context.getString(R.string.teamsCoach))
            listOfInvites.add(context.getString(R.string.teamsPlayer_Coach))
            listOfInvites.add(context.getString(R.string.teamsPlayer))
        }
        if((teamMembers?.supporters ?: 0) < (limitOfMembers?.supporterLimit ?: 0)){
            if(listOfInvites == null){
                listOfInvites = ArrayList()
            }
            listOfInvites.add(context.getString(R.string.teamsSupporter))
        }
        mutableListOfInvitees.value = listOfInvites
        return mutableListOfInvitees
    }


}
