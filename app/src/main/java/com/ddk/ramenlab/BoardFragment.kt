package com.ddk.ramenlab

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ddk.ramenlab.adapter.AnnounceBoardListAdapter
import com.ddk.ramenlab.adapter.ChatBoardListAdpapter
import com.ddk.ramenlab.adapter.RecipeBoardListAdapter
import com.ddk.ramenlab.databinding.FragmentBoardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardFragment : Fragment() {

    private lateinit var binding: FragmentBoardBinding

    @SuppressLint("ResourceAsColor")
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
        binding.boardRecyclerView.adapter = RecipeBoardListAdapter()

        recipeBtn.setOnClickListener {
            recipeBtn.isSelected = true
            chatBtn.isSelected = false
            announceBtn.isSelected = false

            binding.boardRecyclerView.adapter = RecipeBoardListAdapter()
        }

        chatBtn.setOnClickListener {
            chatBtn.isSelected = true
            recipeBtn.isSelected = false
            announceBtn.isSelected = false

            binding.boardRecyclerView.adapter = ChatBoardListAdpapter()
        }

        announceBtn.setOnClickListener {
            announceBtn.isSelected = true
            recipeBtn.isSelected = false
            chatBtn.isSelected = false

            binding.boardRecyclerView.adapter = AnnounceBoardListAdapter()
        }

        return binding.root
    }
}
