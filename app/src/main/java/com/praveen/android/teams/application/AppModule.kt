package com.praveen.android.teams.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.praveen.android.teams.model.InviteMemberModel
import com.praveen.android.teams.model.InviteMemberModelImpl
import com.praveen.android.teams.model.QRScanCodeModel
import com.praveen.android.teams.model.QRScanCodeModelImpl
import com.praveen.android.teams.viewmodel.InviteMembersViewModel
import com.praveen.android.teams.viewmodel.QRScanViewmodel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Named

@Module
class AppModule constructor(private var myApplication: TeamsApplication) {

    @Provides
    fun provideMyRetroApplication(): TeamsApplication {
        return myApplication
    }

    @Provides
    @Named("View_Model_Factory")
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory{
        return viewModelFactory
    }

    @Provides
    @IntoMap
    @ViewModelKey(QRScanViewmodel::class)
    fun bindQRScanCodeViewModel(qrScanViewmodel: QRScanViewmodel): ViewModel {
        return qrScanViewmodel
    }

    @Provides
    @IntoMap
    @ViewModelKey(InviteMembersViewModel::class)
    fun bindInviteMembersViewModel(inviteMembersViewModel: InviteMembersViewModel): ViewModel {
        return inviteMembersViewModel
    }

    @Provides
    fun provideInviteMemberModel(inviteMemberModelImpl: InviteMemberModelImpl): InviteMemberModel {
        return inviteMemberModelImpl
    }

    @Provides
    fun provideQRScanCodeModel(qrScanCodeModelImpl: QRScanCodeModelImpl): QRScanCodeModel {
        return qrScanCodeModelImpl
    }
}