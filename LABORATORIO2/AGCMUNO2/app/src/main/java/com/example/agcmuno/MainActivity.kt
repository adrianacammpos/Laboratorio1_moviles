package com.example.agcmuno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agcmuno.ui.theme.AGCMUNOTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AGCMUNOTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NameListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun NameListScreen(modifier: Modifier = Modifier) {
    var nombre by remember { mutableStateOf("") }
    // Estado para almacenar la lista de nombres
    val listaNombres = remember { mutableStateListOf<String>() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7FD))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = Color(0xFFE5E5EA),
                unfocusedContainerColor = Color(0xFFE5E5EA)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                if (nombre.isNotBlank()) {
                    listaNombres.add(nombre)
                    nombre = ""
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4B5E91)),
            shape = RoundedCornerShape(50)
        ) {
            Text("Guardar", color = Color.White)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Listado de nombres y\nposición en la lista",
                modifier = Modifier.weight(1f),
                color = Color.Black
            )

            Button(
                onClick = { listaNombres.clear() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4B5E91)),
                shape = RoundedCornerShape(50)
            ) {
                Text("Limpiar", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(
                    width = 3.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(12.dp)
        ) {
            LazyColumn {
                itemsIndexed(listaNombres) { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item,
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "${index + 1}",
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NameListPreview() {
    AGCMUNOTheme {
        NameListScreen()
    }
}
