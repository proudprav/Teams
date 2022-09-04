package com.praveen.android.teams.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(private val viewmodels: MutableMap<Class<out ViewModel>,
@JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewmodels[modelClass]?.get() as T
    }
}
