package com.james.challenge3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.james.challenge3.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), ListAdapterListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ListNameAdapter(this)
        adapter.submitList(retrieveListData())
        binding.recyclerView.adapter = adapter


        binding.recyclerView.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )

    }

    fun retrieveListData () : List<Item>{
        return listOf(
            Item(
                name = "Barcelona",
                player = listOf("Lionel Messi", "Luis Suarez", "Neymar Jr").map { Player(it) }
            ),
            Item(
                name = "Real Madrid",
                player = listOf("Cristiano Ronaldo", "Karim Benzema", "Gareth Bale" ).map { Player(it) }
            ),
            Item(
                name = "Atletico Madrid",
                player = listOf("Alvaro Morata", "Rodrigo", "Koke" ).map { Player(it) }
            ),
            Item(
                name = "Valencia",
                player = listOf("Hugo Duro", "Peter Gonzales", "Diego Lopez" ).map { Player(it) }
            ),
            Item(
                name = "Girona",
                player = listOf("Yan Couto", "Yangel Herera", "Pablo Tore" ).map { Player(it) }
            ),
            Item(
                name = "Sevilla",
                player = listOf("Sergio Ramos","Acuna", "Lucas" ).map { Player(it) }
            ),
            Item(
                name = "Manchaster United",
                player = listOf("Bruno Fernandes", "Antony", "Casemiro" ).map { Player(it) }
            ),
            Item(
                name = "Manchaster City",
                player = listOf("Erling Haaland", "De Bruyne", "Julian Alavarez" ).map { Player(it) }
            ),
            Item(
                name = "Arsenal",
                player = listOf("Van Persie", "Gabriel Jesus", "Jorginho" ).map { Player(it) }
            ),
            Item(
                name = "Liverpool",
                player = listOf("Salah", "Nunez", "Van Dijk" ).map { Player(it) }
            ),
        )
    }

    override fun onClickItem(data: Item) {
        val actionToListPlayerFragment = HomeFragmentDirections.actionHomeFragmentToListPlayerFragment()
        actionToListPlayerFragment.name = data
        findNavController().navigate(actionToListPlayerFragment)
    }


}