package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.example.littlelemon.ui.theme.PrimaryColor1
import com.example.littlelemon.ui.theme.PrimaryColor2

@Composable
fun HeroSection(): String {
    var searchPhrase by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryColor1)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                "Little Lemon",
                color = PrimaryColor2,
                fontSize = 40.sp
            )
            Text(
                "Chicago",
                color = Color.White,
                fontSize = 22.sp
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            Text(
                "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist.",
                color = Color.White,
                modifier = Modifier.width(200.dp)
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )

            TextField(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search icon"
                    )
                },
                value = searchPhrase,
                onValueChange = { searchPhrase = it },
                label = {
                    Text(
                        "Enter search phrase"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(2.dp))
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp, end = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.hero_image),
                contentDescription = "Hero Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
    return searchPhrase
}

@Preview(showBackground = true)
@Composable
fun PreviewHeroSection() {
    LittleLemonTheme {
        HeroSection()
    }
}