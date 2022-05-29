package ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.FilmRepository
import kotlinx.coroutines.launch
import model.Film

class DetailViewModel (val filmRepository: FilmRepository) : ViewModel() {

    var filmLiveData = MutableLiveData<Film>()

    fun getFilmDetail(id: Int){
        viewModelScope.launch {
            filmLiveData.value = filmRepository.getFilmDetail(id)
        }

    }
}