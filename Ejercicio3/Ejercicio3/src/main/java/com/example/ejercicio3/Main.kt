package com.example.ejercicio3

fun main() {

    val Ciclo01 = listOf(

        // Programacion de Dispositivos Moviles
        Estudiante("Adriana Campos", "GA21001", "Programacion de Dispositivos Moviles"),
        Estudiante("Diego Mejia", "PE21002", "Programacion de Dispositivos Moviles"),
        Estudiante("Jose Hernandez", "LO21003", "Programacion de Dispositivos Moviles"),

        // Analisis Numerico
        Estudiante("Marcos Canales", "DI21004", "Analisis Numerico"),
        Estudiante("Sandra Torres", "MA21005", "Analisis Numerico"),
        Estudiante("Paola Caminos", "RA21006", "Analisis Numerico"),
        Estudiante("Maria Cruz", "TO21007", "Analisis Numerico")
    )

    println("--- Estudiantes en Dispositivos Moviles ---")

    val dispositivosMoviles = Ciclo01.filter {
        it.asignatura == "Programacion de Dispositivos Moviles"
    }

    dispositivosMoviles.forEach {
        println("Nombre: ${it.nombre} | Carnet: ${it.carnet}")
    }

    println("\nTotal: ${dispositivosMoviles.size} estudiantes")
}