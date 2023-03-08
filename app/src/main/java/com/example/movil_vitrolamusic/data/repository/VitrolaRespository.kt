package com.example.movil_vitrolamusic.data.repository

import com.example.movil_vitrolamusic.data.remodo.VitrolaApi
import com.example.movil_vitrolamusic.data.remodo.dto.Music
import com.example.movil_vitrolamusic.data.remodo.dto.MusicResponse
import com.example.movil_vitrolamusic.util.Resource
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

/*
class VitrolaRespository @Inject constructor(
    private val api: VitrolaApi,
) {
    fun getVitrola(): Flow<Resource<List<Music>>> = flow {
        try {
            emit(Resource.Loading())
            val vitrola = api.getVitrola()
            emit(Resource.Success(vitrola))
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error Occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "Verificar conexión a internet"))
        }
    }
}
*/

