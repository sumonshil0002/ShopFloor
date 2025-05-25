package com.example.d2c_test.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.d2c_test.R
import com.example.d2c_test.ui.theme.centuryOld
import com.example.d2c_test.ui.theme.neuzeitSltstdBook
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType


@Composable
fun Banner() {
    val bannerList = listOf<String>("Get 20% Off", "Get 30% Off", "Get 55% Off")
    val pagerState = rememberPagerState(0) {
        bannerList.size
    }
    Box(modifier = Modifier.fillMaxWidth()
        .aspectRatio(15.00f / 8.92f)) {
        Image(painter = painterResource(R.drawable.shopflowcard1), contentDescription = "",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth)
        Column(Modifier.fillMaxWidth()) {

            HorizontalPager(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                state = pagerState,
                pageSpacing = 16.dp
            ) { page ->
                BannerItem(bannerList[page])
            }

        }
        DotsIndicator(
            dotCount = bannerList.size,
            type = ShiftIndicatorType(dotsGraphic = DotGraphic(color = Color.Green)),
            pagerState = pagerState,
            modifier = Modifier.align(Alignment.BottomStart).padding(
                end = 155.dp,

            )
        )
    }

}
@Composable
fun BannerItem(name: String) {
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 26.dp, vertical = 46.dp),
        verticalArrangement = Arrangement.Center) {
        Text(text = name,
            style = TextStyle(
                fontFamily = centuryOld,
                color = Color.White,
                fontSize = 38.sp
            )
        )
        Spacer(modifier = Modifier.height(26.dp))
        Text(text = name,
            style = TextStyle(
                fontFamily = centuryOld,
                color = Color.White,
                fontSize = 18.sp
            )
        )
        Spacer(modifier = Modifier.height(26.dp))
        Box(
            modifier = Modifier.background(
                color = Color.Green,
                shape = RoundedCornerShape(8.dp)
            )
        ) {
            Text(text = "12 - 16 October",
                modifier = Modifier.padding(3.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = neuzeitSltstdBook,
                    fontSize = 14.sp
                ))
        }
    }

}