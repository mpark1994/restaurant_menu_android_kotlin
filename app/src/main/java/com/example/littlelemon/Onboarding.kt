package com.example.littlelemon

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.example.littlelemon.ui.theme.PrimaryColor1
import com.example.littlelemon.ui.theme.PrimaryColor2

@Composable
fun Onboarding(navController: NavController, sharedPreferences: SharedPreferences?) {
    val context = LocalContext.current
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
                    .height(80.dp)
                    .width(200.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(PrimaryColor1)
        ) {
            Text(
                "Let's get to know you",
                fontSize = 24.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .width(16.dp)
            )

            Text(
                "Personal information:",
                fontSize = 20.sp,
                textAlign = TextAlign.Left
            )

            Spacer(
                modifier = Modifier
                    .width(12.dp)
            )

            var firstName by remember {
                mutableStateOf("")
            }
            Text(
                "First Name"
            )
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                modifier = Modifier
                    .fillMaxWidth()
            )

            var lastName by remember {
                mutableStateOf("")
            }
            Text(
                "Last Name"
            )
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                modifier = Modifier
                    .fillMaxWidth()
            )

            var email by remember {
                mutableStateOf("")
            }
            Text(
                "Email"
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
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
                        validate(
                            context,
                            firstName,
                            lastName,
                            email,
                            sharedPreferences,
                            navController
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(
                    "Register",
                    color = Color.Black
                )
            }
        }
    }
}

private fun validate(context: Context, firstName: String, lastName: String, email: String, sharedPreferences: SharedPreferences, navController: NavController) {
    if (firstName.isBlank() || lastName.isBlank() || email.isBlank()) {
        Toast.makeText(context, "Please fill out all the data!", Toast.LENGTH_LONG).show()
    }
    else {
        sharedPreferences.edit(commit = true) {
            putString("firstName", firstName)
            putString("lastName", lastName)
            putString("email", email)
        }
        Toast.makeText(context, "Success!", Toast.LENGTH_LONG).show()
        navController.navigate(Home.route)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnboarding() {
    val navController = rememberNavController()
    LittleLemonTheme() {
        Onboarding(navController, null)
    }
}
