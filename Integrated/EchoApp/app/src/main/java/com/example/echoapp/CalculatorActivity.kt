package com.example.echoapp

class CalculatorActivity {
    private var currentInput = ""

    fun parseInput(): Double {
        val number = currentInput.toDoubleOrNull() ?: 0.0
        return number
    }
}
