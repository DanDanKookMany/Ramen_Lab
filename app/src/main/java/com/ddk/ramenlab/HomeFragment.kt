package com.ddk.ramenlab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ddk.ramenlab.adapter.NewRamenCardAdapter
import com.ddk.ramenlab.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)

        binding.ramenRankingBtn.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_home_to_ramenRankingFragment)
        }
        binding.newRamenRecyclerView.adapter = NewRamenCardAdapter()

        return binding.root
    }
}