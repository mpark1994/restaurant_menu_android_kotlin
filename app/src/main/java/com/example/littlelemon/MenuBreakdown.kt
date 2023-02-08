package com.example.littlelemon

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun MenuBreakdown(): String {
    var filterType by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Text(
            "ORDER FOR DELIVERY!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    filterType = setFilterType(filterType, "starters")
                }
            ) {
                Text(
                    "Starters"
                )
            }

            Button(
                onClick = {
                    filterType = setFilterType(filterType, "mains")
                }
            ) {
                Text(
                    "Mains"
                )
            }

            Button(
                onClick = {
                    filterType = setFilterType(filterType, "desserts")
                }
            ) {
                Text(
                    "Desserts"
                )
            }

            Button(
                onClick = {
                    filterType = setFilterType(filterType, "drinks")
                }
            ) {
                Text(
                    "Drinks"
                )
            }
        }

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(start = 1.dp, end = 1.dp)
        )
    }
    return filterType
}

private fun setFilterType(filterType: String, type: String) = if (filterType == type) {
    ""
} else {
    type
}

@Preview(showBackground = true)
@Composable
fun PreviewMenuBreakdown() {
    LittleLemonTheme {
        MenuBreakdown()
    }
}