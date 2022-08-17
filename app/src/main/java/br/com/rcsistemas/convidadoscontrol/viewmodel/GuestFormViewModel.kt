package br.com.rcsistemas.convidadoscontrol.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import br.com.rcsistemas.convidadoscontrol.model.GuestModel
import br.com.rcsistemas.convidadoscontrol.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)


    fun insert(guest: GuestModel) {

        repository.insert(guest)

    }

}