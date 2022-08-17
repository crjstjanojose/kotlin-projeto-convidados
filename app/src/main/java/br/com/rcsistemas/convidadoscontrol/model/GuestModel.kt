package br.com.rcsistemas.convidadoscontrol.model

data class GuestModel(
    var id: Int = 0,
    var name: String = "",
    var presence: Boolean = false
)
