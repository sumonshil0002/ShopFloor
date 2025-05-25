package com.example.d2c_test.screens.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.d2c_test.R
import com.example.d2c_test.model.Category
import com.example.d2c_test.model.Product
import com.example.d2c_test.ui.theme.centuryOld

@Composable
fun HomeScreen(innerPaddingValues: PaddingValues) {

    val productList = listOf(
        Product(
            name = "Glow",
            description = "a statement or account giving the characteristics of someone or something : a descriptive statement or account",
            price = 100.0,
            offerPrice = 80.0,
            rating = 2.0,
            isAvailable = true,
            image = R.drawable.product_image
        ),
        Product(
            name = "Glow1",
            description = "a statement or account giving the characteristics of someone or something : a descriptive statement or account",
            price = 100.0,
            offerPrice = 80.0,
            rating = 4.5,
            isAvailable = false,
            image = R.drawable.product_image
        ),
        Product(
            name = "Glow2",
            description = "a statement or account giving the characteristics of someone or something : a descriptive statement or account",
            price = 100.0,
            offerPrice = 80.0,
            rating = 3.3,
            isAvailable = true,
            image = R.drawable.product_image
        ),
        Product(
            name = "Glow3",
            description = "New Product",
            price = 100.0,
            offerPrice = 80.0,
            rating = 4.5,
            isAvailable = true,
            image = R.drawable.product_image
        )
    )
    val categoryList = listOf(
        Category(name = "Category1", image = R.drawable.categorysample),
        Category(name = "Category2", image = R.drawable.categorysample),
        Category(name = "Category3", image = R.drawable.categorysample),
        Category(name = "Category4", image = R.drawable.categorysample),
        Category(name = "Category4", image = R.drawable.categorysample),
        Category(name = "Category4", image = R.drawable.categorysample),
        Category(name = "Category4", image = R.drawable.categorysample),
        Category(name = "Category4", image = R.drawable.categorysample),
        Category(name = "Category4", image = R.drawable.categorysample),
        Category(name = "Category4", image = R.drawable.categorysample),
        Category(name = "Category4", image = R.drawable.categorysample),
        Category(name = "Category4", image = R.drawable.categorysample),
        Category(name = "Category4", image = R.drawable.categorysample),
        Category(name = "Category4", image = R.drawable.categorysample),
    )
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
            .background(
                color = Color(0xFF000000)
            ),
        topBar = { TopBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xFF2A2A2A)
                )
                .padding(paddingValues)

        ) {

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Spacer(modifier = Modifier.height(4.dp))
                    Banner()
                    Spacer(modifier = Modifier.height(4.dp))
                    Category(categoryList)
                    Spacer(modifier = Modifier.height(4.dp))
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 16.dp,
                                vertical = 16.dp
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "New Products",
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
                }
                items(productList) {
                    ProductItem(it)
                }
            }

        }
    }

}










