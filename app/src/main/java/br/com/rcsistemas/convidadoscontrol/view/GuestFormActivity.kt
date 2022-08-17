package br.com.rcsistemas.convidadoscontrol.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import br.com.rcsistemas.convidadoscontrol.R
import br.com.rcsistemas.convidadoscontrol.databinding.ActivityGuestFormBinding
import br.com.rcsistemas.convidadoscontrol.model.GuestModel
import br.com.rcsistemas.convidadoscontrol.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        binding.buttonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true
    }

    override fun onClick(view: View) {

        if (view.id == R.id.button_save) {

            val name = binding.editName.text.toString()
            val presence = binding.radioPresent.isChecked
            val guest = GuestModel(0, name, presence)

            viewModel.insert(guest)

        }

    }
}