package com.ddk.ramenlab

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ddk.ramenlab.adapter.RamenRankingAdapter
import com.ddk.ramenlab.data.RamenData
import com.ddk.ramenlab.databinding.FragmentRamenRankingBinding

/**
 * 버그 노트
 * 1. Ranking fragment 사용 후 toolbar 가 사라지는 버그 있음.
 * 2. 메달 부분의 share 표시는 공간 문제로 잠시 보류함
 */
class RamenRankingFragment : Fragment() {

    private lateinit var binding: FragmentRamenRankingBinding

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val act = activity as MainActivity
        act.supportActionBar?.hide()
        /*// Inflate the layout for this fragment
        binding = FragmentRamenRankingBinding.inflate(inflater)

        // get ramen ranking data
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
        binding.ramenRankingRecycler.adapter = RamenRankingAdapter()*/

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    Scaffold(
                        containerColor = Color.Black,
                        topBar = { RamenRankingTopAppBar(this@RamenRankingFragment) }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            RamenRanking()
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun DefaultPreview() {
    MaterialTheme {
        Scaffold(
            containerColor = Color.Black,
            //topBar = { RamenRankingTopAppBar() }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                RamenRanking()
            }
        }
    }
}

val fonts = FontFamily(
    Font(R.font.gmarketsansbold, weight = FontWeight.Bold),
    Font(R.font.gmarketsansmedium, weight = FontWeight.Medium)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RamenRankingTopAppBar(fragment: Fragment) {
    TopAppBar(
        title = { Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_app_title), contentDescription = null) },
        navigationIcon = {
            IconButton(
                onClick = {
                    fragment.findNavController().popBackStack()
                }
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Outlined.Share, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Black,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color(0xFFDD6E51),
            titleContentColor = Color(0xFFDD6E51)
        )
    )
}

@Composable
private fun RamenRanking(modifier: Modifier = Modifier) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        val lazyListScope: LazyListScope = this
        item {
            Text(
                text = "우리의 입맛을 사로잡은",
                fontFamily = fonts,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 24.sp,
                modifier = modifier
                    .padding(top = 40.dp, bottom = 5.dp)
            )
        }
        item {
            Text(
                text = "인기 라면",
                fontFamily = fonts,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFDD6E51),
                fontSize = 24.sp,
                modifier = modifier
                    .padding(bottom = 20.dp)
            )
        }
        item {
            Box(
                modifier = modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                Card(
                    modifier = modifier
                        .fillMaxWidth()
                        .matchParentSize()
                        .padding(top = 70.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9F8)),
                    shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                ) {}
                Column {
                    Top3()
                    //Spacer(modifier = modifier.height(20.dp))
                }
            }
        }
        items(10) {
            RamenRankingItem(Color(0xFFFFF9F8))
        }
    }
}

@Composable
private fun Top3(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Spacer(modifier = modifier.weight(0.2f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .weight(1f)
        ) {
            TopThreeInformation(color = Color(0xFFD1D1D1))
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .weight(1.3f)
        ) {
            TopThreeInformation(color = Color(0xFFFFDA1E))
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .weight(1f)
        ) {
            TopThreeInformation(color = Color(0xFFDBB782))
        }
        Spacer(modifier = modifier.weight(0.2f))
    }
}

@Composable
private fun TopThreeInformation(color: Color, modifier: Modifier = Modifier) {
    val image: Int
    val ramenSize: Dp

    when (color) {
        Color(0xFFD1D1D1) -> {
            image = R.drawable.ramen_ranking_silver_crown
            ramenSize = 70.dp
        }
        Color(0xFFFFDA1E) -> {
            image = R.drawable.ramen_ranking_gold_crown
            ramenSize = 100.dp
        }
        else -> {
            image = R.drawable.ramen_ranking_bronze_crown
            ramenSize = 70.dp
        }
    }

    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = image),
            contentDescription = null,
            modifier = modifier
        )
        Column {
            Spacer(modifier = modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ramen1),
                contentDescription = null,
                modifier = modifier
                    .size(ramenSize)
            )
        }
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "9.1%",
            fontSize = 10.sp,
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .background(color = color, shape = RoundedCornerShape(12.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp),
            color = Color.White
        )
        Spacer(modifier = modifier.width(3.dp))
        Text(text = "신라면", fontSize = 14.sp, fontFamily = fonts, fontWeight = FontWeight.Bold)
    }
    Button(
        onClick = {  },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        modifier = modifier
            .padding(5.dp)
            .height(35.dp)
            .width(90.dp),
        contentPadding = PaddingValues(
            0.dp
        )
    ) {
        Text(
            text = "더 알아보기",
            color = color,
            fontSize = 12.sp,
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
private fun RamenRankingItem(backgroundColor: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(color = backgroundColor)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = modifier
                .padding(vertical = 10.dp, horizontal = 20.dp)
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "#4",
                    color = Color(0xFFDD6E51),
                    modifier = modifier
                        .background(color = Color(0xFFFFF2EE), shape = RoundedCornerShape(12.dp))
                        .padding(vertical = 5.dp, horizontal = 7.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ramen1), contentDescription = null,
                    modifier
                        .size(40.dp)
                )
                Spacer(modifier = modifier.width(10.dp))
                Text(text = "신라면", fontFamily = fonts, fontWeight = FontWeight.Bold)
                Spacer(modifier = modifier.width(5.dp))
                Text(text = "7%", fontFamily = fonts, fontWeight = FontWeight.Bold)
                Spacer(modifier = modifier.weight(1f))
                Image(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }
    }
}
