package com.example.d2c_test.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.d2c_test.model.Category
import com.example.d2c_test.ui.theme.centuryOld
import com.example.d2c_test.ui.theme.neuzeitSltstdBook

@Composable
fun Category(categoryList: List<Category>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Category",
            style = TextStyle(
                fontFamily = centuryOld,
                color = Color.White,
                fontSize = 22.sp
            )
        )
        Text(
            text = "See all",
            style = TextStyle(
                fontFamily = centuryOld,
                color = Color.White,
                fontSize = 12.sp
            )
        )
    }
    LazyRow { items(categoryList) { CategoryItem(it) } }
}

@Composable
fun CategoryItem(category: Category) {
    Column {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .background(color = Color(0xFF000000), shape = CircleShape)
                .size(80.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = category.image), contentDescription = "",
                modifier = Modifier.size(60.dp)
            )
        }
        Text(
            text = category.name,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(
                fontFamily = neuzeitSltstdBook
            )
        )
    }
}