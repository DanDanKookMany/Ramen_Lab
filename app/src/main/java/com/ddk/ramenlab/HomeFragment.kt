package com.ddk.ramenlab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ddk.ramenlab.adapter.NewRamenAdapter
import com.ddk.ramenlab.data.RamenData
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

        binding.newRamenRecyclerView.adapter = NewRamenAdapter()

        // get best 3 ramen and sort
        val bestRamen = RamenData.topRamen.filter { it.ranking!! <= 3 }.sortedBy { it.ranking }

        // set best ramen image
        binding.goldMedalRamenImage.setImageResource(bestRamen[0].imageResourceId)
        binding.silverMedalRamenImage.setImageResource(bestRamen[1].imageResourceId)
        binding.bronzeMedalRamenImage.setImageResource(bestRamen[2].imageResourceId)

        // set best ramen name
        binding.goldRamenName.text = bestRamen[0].name
        binding.silverRamenName.text = bestRamen[1].name
        binding.bronzeRamenName.text = bestRamen[2].name

        return binding.root
    }
}