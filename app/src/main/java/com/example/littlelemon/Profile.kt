package com.example.littlelemon

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.example.littlelemon.ui.theme.PrimaryColor2

@Composable
fun Profile(navController: NavController, sharedPreferences: SharedPreferences?) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(120.dp)
                    .width(200.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                "Personal information:",
                fontSize = 20.sp,
                textAlign = TextAlign.Left
            )

            Spacer(
                modifier = Modifier
                    .width(16.dp)
            )

            Text("First Name")
            var firstName = sharedPreferences?.getString("firstName", "")
            if (firstName == null) {
                firstName = ""
            }
            OutlinedTextField(
                value = firstName,
                onValueChange = { },
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text("Last Name")
            var lastName = sharedPreferences?.getString("lastName", "")
            if (lastName == null) {
                lastName = ""
            }
            OutlinedTextField(
                value = lastName,
                onValueChange = { },
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text("Email")
            var email = sharedPreferences?.getString("email", "")
            if (email == null) {
                email = ""
            }
            OutlinedTextField(
                value = email,
                onValueChange = { },
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(
                modifier = Modifier
                    .width(16.dp)
            )
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor2),
                onClick = {
                    if (sharedPreferences != null) {
                        logout(navController, sharedPreferences)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(
                    "Log out",
                    color = Color.Black
                )
            }
        }
    }
}

private fun logout(navController: NavController, sharedPreferences: SharedPreferences) {
    sharedPreferences.edit().clear().apply()
    navController.navigate(Onboarding.route)
}


@Preview(showBackground = true)
@Composable
fun PreviewProfile() {
    val navController = rememberNavController()
    LittleLemonTheme {
        Profile(navController, null)
    }
}