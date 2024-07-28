package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
   private val liveDataWrapper: LiveDataWrapper,
   private val repository: Repository
) {
    val liveData = liveDataWrapper.liveData()

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        scope.launch {
            repository.load()
            liveDataWrapper.update(UiState.ShowData)
        }
    }
}