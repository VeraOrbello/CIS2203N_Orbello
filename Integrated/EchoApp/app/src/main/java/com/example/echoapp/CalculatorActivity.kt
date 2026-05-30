package com.example.echoapp

class CalculatorActivity {

    fun calculate(a: Double, b: Double, op: String): Double {
        return when(op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> a / b
            else -> 0.0
        }
    }
}
