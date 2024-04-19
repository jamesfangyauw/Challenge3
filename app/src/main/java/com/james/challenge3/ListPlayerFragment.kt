package com.james.challenge3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.james.challenge3.databinding.FragmentListPlayerBinding

class ListPlayerFragment : Fragment(), ListAdapterListener {

    private var _binding: FragmentListPlayerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListPlayerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ListNameAdapter(this)

        val listPlayer = getName().player
        val listPlayerItem = listPlayer?.map { Item(name = it.name, null) }
        adapter.submitList(listPlayerItem)

        binding.recyclerView.adapter = adapter

        binding.recyclerView.layoutManager = GridLayoutManager(
            context,
            2
        )
    }

    private fun getName(): Item {
        return getArgs().name!!
    }

    private fun getArgs(): ListPlayerFragmentArgs {
        return ListPlayerFragmentArgs.fromBundle(arguments as Bundle)
    }


    override fun onClickItem(data: Item) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://www.google.com/search?q=${data.name}"))
        startActivity(intent)
    }

}