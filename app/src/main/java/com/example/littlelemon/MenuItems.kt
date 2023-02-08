package com.example.littlelemon

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.example.littlelemon.ui.theme.PrimaryColor1

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItems(items: List<MenuItemRoom>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        items(
            items = items,
            itemContent = { menuItem ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .weight(1f)
                    ) {
                        Text(
                            menuItem.title,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(
                            modifier = Modifier
                                .height(10.dp)
                        )
                        Text(
                            menuItem.description,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(
                            modifier = Modifier
                                .height(10.dp)
                        )

                        val price = menuItem.price.toFloat()
                        Text(
                            "$ %.2f".format(price),
                            color = PrimaryColor1
                        )
                    }

                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(100.dp)
                    ) {
                        GlideImage(
                            model = menuItem.image,
                            contentDescription = "Dish Image",
                            modifier = Modifier
                                .height(100.dp)
                                .width(80.dp)
                        )
                    }
                }

                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenuItems() {
    LittleLemonTheme {
        MenuItems(emptyList())
    }
}