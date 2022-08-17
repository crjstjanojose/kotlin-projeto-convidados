package br.com.rcsistemas.convidadoscontrol.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import br.com.rcsistemas.convidadoscontrol.databinding.RowGuestBinding
import br.com.rcsistemas.convidadoscontrol.model.GuestModel

class GuestViewHolder(private val bind: RowGuestBinding) : RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name
    }
}