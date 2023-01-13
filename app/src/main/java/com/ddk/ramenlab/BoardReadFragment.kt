package com.ddk.ramenlab

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.ddk.ramenlab.databinding.FragmentBoardReadBinding

class BoardReadFragment : Fragment() {

    private lateinit var binding: FragmentBoardReadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardReadBinding.inflate(inflater)
        // Inflate the layout for this fragment

        setFragmentResultListener("result") {
            key, bundle -> var title = bundle.getString("title")
            var content = bundle.getString("content")

            Log.d("ttttt", title.toString())

            binding.readTitle.text = title
            binding.readContent.text = content
        }

        return binding.root
    }
}