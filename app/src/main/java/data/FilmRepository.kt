package data

import model.Film
import model.Films

class FilmRepository(val localDataSource: LocalDataSource,
                     val remoteDataSource: RemoteDataSource) {

    var filmSelected : Int? = null

    suspend fun getAllFilms() : Films{
        return remoteDataSource.getAllFilms()
    }

    suspend fun getFilmDetail(id:Int): Film{
        return remoteDataSource.getFilmDetail(id)
    }

}