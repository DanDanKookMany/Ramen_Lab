package com.ddk.ramenlab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ddk.ramenlab.adapter.RamenRankingAdapter
import com.ddk.ramenlab.data.RamenData
import com.ddk.ramenlab.databinding.FragmentRamenRankingBinding

class RamenRankingFragment : Fragment() {

    private lateinit var binding: FragmentRamenRankingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val act = activity as MainActivity
        act.supportActionBar?.hide()
        // Inflate the layout for this fragment
        binding = FragmentRamenRankingBinding.inflate(inflater)

        val ramenRankingList = RamenData.ranking

        // set gold ramen
        binding.goldImage.setImageResource(ramenRankingList[0].imageResourceId)
        binding.goldName.text = ramenRankingList[0].name
        // binding.goldShare.text = ramenRankingList[0].share

        // set silver ramen
        binding.silverImage.setImageResource(ramenRankingList[1].imageResourceId)
        binding.silverName.text = ramenRankingList[1].name
        // binding.silverShare.text = ramenRankingList[1].share

        // set bronze ramen
        binding.bronzeImage.setImageResource(ramenRankingList[2].imageResourceId)
        binding.bronzeName.text = ramenRankingList[2].name
        // binding.bronzeShare.text = ramenRankingList[2].share

        // set ramen ranking recycler view
        binding.ramenRankingRecycler.adapter = RamenRankingAdapter(requireContext())

        return binding.root
    }
}

