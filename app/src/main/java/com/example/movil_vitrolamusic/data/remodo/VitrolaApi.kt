package com.example.movil_vitrolamusic.data.remodo

import com.example.movil_vitrolamusic.data.remodo.dto.Music
import com.example.movil_vitrolamusic.data.remodo.dto.MusicResponse
import com.example.movil_vitrolamusic.data.remodo.dto.WaitList
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface VitrolaApi {

    @GET("myapp/music/")
    suspend fun getMusic(): MusicResponse

    @POST("myapp/waitlist/")
    suspend fun postMusic(@Body music: Music): MusicResponse

}