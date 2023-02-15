package com.ddk.ramenlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.ddk.ramenlab.adapter.ChatReplyAdapter
import com.ddk.ramenlab.adapter.ChatReplyListAdapter
import com.ddk.ramenlab.adapter.RecipeViewPagerAdapter
import com.ddk.ramenlab.databinding.ActivityBoardReadBinding
import com.google.android.material.tabs.TabLayoutMediator

class BoardReadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardReadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_read)

        binding = ActivityBoardReadBinding.inflate(layoutInflater)

        binding.boardToolbar.setNavigationIcon(R.drawable.ic_arrowleft_dark)
        binding.boardToolbar.setNavigationOnClickListener {
            finish()
        }

        // 레시피 사진 처리 - 뷰페이저
        val viewPager2 = binding.viewpagerRecipe
        val tabLayout = binding.viewpagerTap

        viewPager2.adapter = RecipeViewPagerAdapter()
        TabLayoutMediator(tabLayout, viewPager2) {
                _, _ ->
        }.attach()
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        binding.chatListView.adapter = ChatReplyAdapter(this)

        // 좋아요 스크랩 버튼
        binding.goodBtn.setOnClickListener {
            binding.goodBtn.isSelected = !binding.goodBtn.isSelected
        }

        binding.scrapBtn.setOnClickListener {
            binding.scrapBtn.isSelected = !binding.scrapBtn.isSelected
        }

        setContentView(binding.root)
    }
}