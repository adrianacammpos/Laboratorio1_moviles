package com.example.ejercicio1

import android.util.Log

class Computadora(
    var ram: Int,
    var almacenamiento: Int,
    var sistemaOperativo: String,
    var programasInstalados: List<String>
) {

    fun encenderComputadora() {
        Log.d("PRUEBA", "Computadora encendida")
    }

    fun apagarComputadora() {
        Log.d("PRUEBA", "Computadora apagada")
    }

    fun actualizar(nuevaRam: Int, nuevoAlma: Int, nuevoSO: String) {
        ram = nuevaRam
        almacenamiento = nuevoAlma
        sistemaOperativo = nuevoSO
        Log.d("PRUEBA", "Computadora actualizada")
    }

    fun obtenerProgramas(): List<String> {
        return programasInstalados.filter { it.contains("2026") }
    }
}