package ui.showAll

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.FilmRepository
import kotlinx.coroutines.launch
import model.Film
import model.Films

class ShowAllListViewModel (val filmRepository: FilmRepository) : ViewModel(){


    var filmListLiveData = MutableLiveData<Films>()
//    var filmSelected = filmRepository.filmSelected


    fun getAllFilms(){
        viewModelScope.launch {
            filmListLiveData.value = filmRepository.getAllFilms()
        }
    }

    fun setFilmSelected(filmSelected: Int){
        filmRepository.filmSelected = filmSelected
    }
}