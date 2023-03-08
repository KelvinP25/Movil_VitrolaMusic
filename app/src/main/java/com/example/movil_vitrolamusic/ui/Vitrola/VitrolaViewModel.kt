package com.example.movil_vitrolamusic.ui.Vitrola

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movil_vitrolamusic.data.remodo.VitrolaApi
import com.example.movil_vitrolamusic.data.remodo.dto.Music
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VitrolaViewModel @Inject constructor(private val vitrolaApi: VitrolaApi): ViewModel() {

    private val _musicList = MutableStateFlow<List<Music>>(emptyList())

    val musicList: StateFlow<List<Music>>
        get() = _musicList

    init {
        viewModelScope.launch {
            try {
                val response = vitrolaApi.getMusic()
                if (response.message == "Success") {
                    _musicList.value = response.music
                }else{

                    Log.e("VitrolaViewModel", "Error al obtener la lista de música: ${response.message}")
                }
            } catch (e: Exception) {
                _musicList.value = emptyList()
                Log.e("VitrolaViewModel", "Error al obtener la lista de música: ${e.message}")
            }
        }
    }

    fun postMusic(music: Music) {
        viewModelScope.launch {
            try {

                val response = vitrolaApi.postMusic(music)

                if (response.message == "Success") {
                    // Agrega la música a la lista existente
                    val updatedList = _musicList.value.toMutableList()
                    updatedList.add(music)
                    _musicList.value = updatedList
                } else {
                    Log.e("VitrolaViewModel", "Error al agregar la música: ${response.message}")
                }
            } catch (e: Exception) {
                Log.e("VitrolaViewModel", "Error al agregar la música: ${e.message}")
            }
        }
    }
}




