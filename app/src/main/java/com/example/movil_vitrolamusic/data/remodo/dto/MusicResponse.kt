package com.example.movil_vitrolamusic.data.remodo.dto

import com.squareup.moshi.Json

data class MusicResponse(
    val message: String,
    val music: List<Music>
)