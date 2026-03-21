package com.example.ejercicio_2

fun main() {

    val calc = Calculadora(
        marca = "Apple",
        anosDeVida = 5,
        precio = 25.99
    )

    println("--- Calculadora ${calc.marca} ---")
    println("Años de vida: ${calc.anosDeVida}")
    println("Precio: \$${calc.precio} ")

    println("\n--- Operaciones ---")
    println("10 + 5 = ${calc.sumar( 10.0, 5.0)}")
    println("10 - 5 = ${calc.restar( 10.0, 5.0)}")
    println("10 * 5 = ${calc.multiplicar( 10.0, 5.0)}")
    println("10 / 5 = ${calc.dividir( 10.0, 5.0)}")

    println("Division entre 0")
    println("10 / 0 = ${calc.dividir( 10.0, 0.0)}")


}