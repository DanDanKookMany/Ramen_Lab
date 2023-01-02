package com.ddk.ramenlab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ddk.ramenlab.databinding.FragmentRamenRankingBinding
import com.ddk.ramenlab.databinding.RamenRankingItemBinding

class RamenRankingFragment : Fragment() {

    private lateinit var binding: FragmentRamenRankingBinding
    private val ramenRankingList = mutableListOf<RamenRankingInform>()

    class RamenRankingInform(
        val name: String,
        val image: Int,
        val share: String
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRamenRankingBinding.inflate(inflater)

        for (i in 0 until 11) {
            ramenRankingList.add(
                RamenRankingInform(
                    "신라면",
                    R.drawable.ramen1,
                    "19.6%"
                )
            )
        }

        binding.goldImage.setImageResource(ramenRankingList[0].image)
        binding.goldName.text = ramenRankingList[0].name
        binding.goldShare.text = ramenRankingList[0].share

        binding.silverImage.setImageResource(ramenRankingList[1].image)
        binding.silverName.text = ramenRankingList[1].name
        binding.silverShare.text = ramenRankingList[1].share

        binding.bronzeImage.setImageResource(ramenRankingList[2].image)
        binding.bronzeName.text = ramenRankingList[2].name
        binding.bronzeShare.text = ramenRankingList[2].share

        val boardMainAdapter = RamenRankingRecyclerAdapter(this.ramenRankingList)
        binding.ramenRankingRecycler.adapter = boardMainAdapter
        binding.ramenRankingRecycler.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    class RamenRankingRecyclerAdapter(private val dataSet: MutableList<RamenRankingInform>) :
        RecyclerView.Adapter<RamenRankingRecyclerAdapter.ViewHolder>() {

        // RecyclerView에 들어갈 item(항목)이 가지는 View 들을 갖고 옴
        class ViewHolder(val binding : RamenRankingItemBinding) : RecyclerView.ViewHolder(binding.root) {
            val ranking: TextView
            val name: TextView
            val image: ImageView
            val share: TextView
            init {
                ranking = binding.ramenRankingItemRanking
                name = binding.ramentRankingItemName
                image = binding.ramenRankingItemImage
                share = binding.ramentRankingItemShare
            }
        }

        // item의 View를 가지는 ViewHolder를 호출
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = RamenRankingItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            val item = dataSet[position + 3]

            viewHolder.ranking.text = "#${position + 4}"
            viewHolder.name.text = item.name
            viewHolder.image.setImageResource(item.image)
            viewHolder.share.text = item.share
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size - 3

    }
}

