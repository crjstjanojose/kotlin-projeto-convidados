package br.com.rcsistemas.convidadoscontrol.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.rcsistemas.convidadoscontrol.model.GuestModel
import br.com.rcsistemas.convidadoscontrol.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GuestRepository =
        GuestRepository.getInstance(application.applicationContext)

    private val _listAllGuests = MutableLiveData<List<GuestModel>>()

    val guests: LiveData<List<GuestModel>> = _listAllGuests

    fun getAll() {
        _listAllGuests.value = repository.getAll()
    }
}