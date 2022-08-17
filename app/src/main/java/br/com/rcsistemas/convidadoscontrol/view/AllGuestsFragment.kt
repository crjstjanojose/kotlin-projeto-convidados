package br.com.rcsistemas.convidadoscontrol.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.rcsistemas.convidadoscontrol.databinding.FragmentAllGuestsBinding
import br.com.rcsistemas.convidadoscontrol.view.adapter.GuestsAdapter
import br.com.rcsistemas.convidadoscontrol.viewmodel.AllGuestsViewModel


class AllGuestsFragment : Fragment() {

    private var _binding: FragmentAllGuestsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AllGuestsViewModel
    private val adapter = GuestsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)
        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)

        // Define como o Layout da Recycler vai funcionar, não é o layout dos itens que
        // vão ser apresentados
        binding.recyclerAllGuests.layoutManager = LinearLayoutManager(context)


        // Adapter necessita da criação de um adapter
        binding.recyclerAllGuests.adapter = adapter


        viewModel.getAll()

        observe()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {

        viewModel.guests.observe(viewLifecycleOwner) {
            adapter.updateGuests(it)
        }

    }
}