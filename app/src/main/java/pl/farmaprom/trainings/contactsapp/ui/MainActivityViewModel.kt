package pl.farmaprom.trainings.contactsapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    companion object {
        private val TAG = MainActivityViewModel::class.java.simpleName
    }
    init {
        Log.d(TAG, "initializing viewModel")
    }

    var name: String = "Jakub"
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared viewModel")
    }
}