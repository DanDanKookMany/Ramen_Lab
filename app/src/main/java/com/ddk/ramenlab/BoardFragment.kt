package com.ddk.ramenlab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ddk.ramenlab.adapter.BoardListAdapter
import com.ddk.ramenlab.databinding.FragmentBoardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardFragment : Fragment() {

    private lateinit var binding: FragmentBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoardBinding.inflate(inflater)

        val recipeBtn = binding.recipeBtn
        val chatBtn = binding.chatBtn
        val announceBtn = binding.announceBtn

        // 화면을 처음 키면 레시피가 선택되어있도록 지정
        recipeBtn.isSelected = true

        recipeBtn.setOnClickListener {
            recipeBtn.isSelected = true
            chatBtn.isSelected = false
            announceBtn.isSelected = false
        }

        chatBtn.setOnClickListener {
            chatBtn.isSelected = true
            recipeBtn.isSelected = false
            announceBtn.isSelected = false
        }

        announceBtn.setOnClickListener {
            announceBtn.isSelected = true
            recipeBtn.isSelected = false
            chatBtn.isSelected = false
        }

        binding.boardRecyclerView.adapter = BoardListAdapter()

        return binding.root
    }
}