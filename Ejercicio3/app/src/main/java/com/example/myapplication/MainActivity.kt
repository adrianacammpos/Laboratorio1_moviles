package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

data class Programa(
    var nombre: String
)

class Computadora(
    var ram: Int,
    var almacenamiento: Int,
    var sistemaOperativo: String,
    var programasInstalados: MutableList<Programa>
) {

    var encendida: Boolean = false

    fun encender() {
        if (!encendida) {
            encendida = true
            println("La computadora se ha encendido")
        } else {
            println("La computadora ya esta encendida")
        }
    }

    fun apagar() {
        if (encendida) {
            encendida = false
            println("La computadora se ha apagado")
        } else {
            println("La computadora ya esta apagada")
        }
    }

    fun actualizarRAM(nuevaRAM: Int) {
        ram = nuevaRAM
        println("RAM actualizada a $ram GB")
    }

    fun actualizarAlmacenamiento(nuevoAlmacenamiento: Int) {
        almacenamiento = nuevoAlmacenamiento
        println("Almacenamiento actualizado a $almacenamiento GB")
    }

    fun actualizarSistemaOperativo(nuevoSO: String) {
        sistemaOperativo = nuevoSO
        println("Sistema operativo actualizado a $sistemaOperativo")
    }

    fun programasDelAnio(anio: String): List<Programa> {
        return programasInstalados.filter { it.nombre.contains(anio) }
    }
}

fun main() {
    val programas = mutableListOf(
        Programa("Notion 2026"),
        Programa("Facebook 2024"),
        Programa("Spotify 2026"),
        Programa("VSCode 2025")
    )

    val pc = Computadora(
        ram = 8,
        almacenamiento = 256,
        sistemaOperativo = "Windows 10",
        programasInstalados = programas
    )

    pc.encender()

    pc.actualizarRAM(16)
    pc.actualizarAlmacenamiento(512)
    pc.actualizarSistemaOperativo("Windows 11")

    val programas2026 = pc.programasDelAnio("2026")

    println("Programas del 2026:")
    programas2026.forEach {
        println(it.nombre)
    }

    pc.apagar()
}