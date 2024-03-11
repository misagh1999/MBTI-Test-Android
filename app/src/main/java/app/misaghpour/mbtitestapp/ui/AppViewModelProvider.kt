package app.misaghpour.mbtitestapp.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import app.misaghpour.mbtitestapp.MBTIApplication
import app.misaghpour.mbtitestapp.ui.screens.result.ResultViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ResultViewModel
        initializer {
            ResultViewModel(
                this.createSavedStateHandle(),
                mbtiApplication().context
            )
        }
    }
}

fun CreationExtras.mbtiApplication(): MBTIApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MBTIApplication)