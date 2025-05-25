package com.example.d2c_test.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.d2c_test.R
import com.example.d2c_test.model.Product
import com.example.d2c_test.ui.theme.neuzeitSltstdBook
import com.example.d2c_test.ui.theme.tangerine

@Composable
fun ProductItem(product: Product) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .aspectRatio(3.75f / 5.28f),
        contentAlignment = Alignment.Center
    ) {
        // Background image
        Image(
            painter = painterResource(R.drawable.card_grey_bg_png),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        // Main content overlayed on the background
        Box(modifier = Modifier.fillMaxSize()) {

            // TOP: Icons Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 16.dp, top = 8.dp)
                    .align(Alignment.TopStart), // Align to top
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Color.Black, shape = CircleShape)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "",
                        tint = Color.White
                    )
                }


                Box(
                    modifier = Modifier
                        .background(color = Color.Black, shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Best Seller", color = Color.White,
                        fontFamily = neuzeitSltstdBook,
                        fontSize = 14.sp
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = "", // Center the product image
                    modifier = Modifier.size(250.dp),
                    contentScale = ContentScale.FillHeight
                )
                ProductInfoBox(product)
            }


        }
    }
}

@Composable
fun ProductInfoBox(product: Product) {
    Box(
        modifier = Modifier.fillMaxWidth(), // Align to bottom
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.card_black_shape),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            contentScale = ContentScale.FillWidth
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .background(
                    color = Color(0xFF262525),
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(R.drawable.cart3),
                contentDescription = "",
                modifier = Modifier
                    .size(65.dp)
                    .padding(20.dp),
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopEnd)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 36.dp, end = 36.dp, top = 18.dp),

                ) {
                ProductNameWithAvailability(product.name, product.isAvailable)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = product.description,
                    maxLines = 2,
                    softWrap = true,
                    fontFamily = neuzeitSltstdBook,
                    fontSize = 12.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                ProductPrice(product.price, product.offerPrice)
                Spacer(modifier = Modifier.height(8.dp))
                ProductRating(product.rating)

            }

        }

    }
}

@Composable
fun ProductRating(rating: Double) {
    Row(modifier = Modifier.fillMaxWidth()) {
        for (i in 1..5) {
            val icon = if (i <= rating) Icons.Filled.Star else Icons.Outlined.Star
            Icon(
                imageVector = icon,
                contentDescription = "Star $i",
                tint = Color.Yellow,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = " 259 Review",
            maxLines = 2,
            softWrap = true,
            fontFamily = neuzeitSltstdBook,
            fontSize = 12.sp,
            color = Color.White
        )
    }
}

@Composable
fun ProductPrice(price: Double, offerPrice: Double) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Row {
            Text(
                text = "Rs $offerPrice",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = neuzeitSltstdBook,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF906DCD),
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Rs $price",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = neuzeitSltstdBook,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    textDecoration = TextDecoration.LineThrough
                )
            )
        }


    }
}

@Composable
fun ProductNameWithAvailability(name: String, inStock: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            style = TextStyle(
                fontFamily = tangerine,
                color = Color.Green,
                fontSize = 22.sp
            )
        )
        val bullet = "\u2022"
        if (!inStock) {
            Text(
                text = "${bullet} Out of Stock",
                style = TextStyle(
                    fontFamily = neuzeitSltstdBook,
                    color = Color.Red,
                    fontSize = 12.sp
                )
            )
        } else {
            Text(
                text = "$bullet In Stock",
                style = TextStyle(
                    fontFamily = neuzeitSltstdBook,
                    color = Color.Green,
                    fontSize = 12.sp
                )
            )
        }
    }
}