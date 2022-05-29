package data

import data.network.ApiService
import model.Film
import model.Films

class RemoteDataSource(val apiService : ApiService) {

    suspend fun getAllFilms(): Films{
        return apiService.getFilmList()
    }

    suspend fun getFilmDetail(id: Int):Film{
        return apiService.getFilmDetail(id)
    }
}