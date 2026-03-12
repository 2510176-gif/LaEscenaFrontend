package org.example.project

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.PasswordVisualTransformation

import androidx.navigation.NavController
import androidx.navigation.compose.*


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController)
        }

        composable("login") {
            LoginScreen()
        }

        composable("register") {
            RegisterScreen()
        }

    }
}

@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Bienvenido a La Escena",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {}) { Text("Ver eventos") }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {}) { Text("Ver artistas") }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {}) { Text("Galerías disponibles") }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {}) { Text("Centro cultural") }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { navController.navigate("register") }
        ) {
            Text("Registrarse (artistas)")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("login") }
        ) {
            Text("Ingresar")
        }
    }
}

@Composable
fun LoginScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Ingresar a La Escena",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                Log.d("LOGIN", "Email: $email Password: $password")
            }
        ) {
            Text("Iniciar sesión")
        }
    }
}

@Composable
fun RegisterScreen() {

    var nombre by remember { mutableStateOf("") }
    var disciplina by remember { mutableStateOf("") }
    var fechaNacimiento by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Registro de Artista",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre completo") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = disciplina,
            onValueChange = { disciplina = it },
            label = { Text("Disciplina artística") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = fechaNacimiento,
            onValueChange = { fechaNacimiento = it },
            label = { Text("Fecha de nacimiento") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = genero,
            onValueChange = { genero = it },
            label = { Text("Género") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                Log.d(
                    "REGISTER",
                    "Nombre: $nombre Disciplina: $disciplina Fecha: $fechaNacimiento Genero: $genero Email: $email"
                )
            }
        ) {
            Text("Registrarse")
        }

    }
}



