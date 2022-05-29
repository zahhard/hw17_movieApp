package ui.up_comming

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.FilmRepository
import kotlinx.coroutines.launch
import model.Films

class UpCommingViewModel(val filmRepository: FilmRepository) : ViewModel() {

    var filmListLiveData = MutableLiveData<Films>()
//    var filmSelected = filmRepository.filmSelected


    fun getAllFilms(){
        viewModelScope.launch {
            filmListLiveData.value = filmRepository.getAllFilms()
        }
    }
}