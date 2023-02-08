package com.example.littlelemon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun Home(navController: NavController, database: AppDatabase?) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        NavigationBar(navController)

        val searchPhrase = HeroSection()

        val filterType = MenuBreakdown()

        if (database != null) {
            val databaseMenuItems by database.menuItemDao().getAll().observeAsState(emptyList())

            val orderMenuItems by remember {
                mutableStateOf(false)
            }

            var menuItems = if (orderMenuItems) {
                databaseMenuItems.sortedBy { it.title }
            }
            else {
                databaseMenuItems
            }

            if (filterType.isNotEmpty()) {
                menuItems = menuItems.filter { it.category.equals(filterType, true) }
            }

            if (searchPhrase.isNotEmpty()) {
                menuItems = menuItems.filter { it.title.contains(searchPhrase, true) }
            }

            MenuItems(menuItems)
        }
        else {
            MenuItems(emptyList())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    val navController = rememberNavController()
    LittleLemonTheme {
        Home(navController, null)
    }
}
