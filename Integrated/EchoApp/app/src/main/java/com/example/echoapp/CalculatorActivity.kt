package com.example.echoapp

class CalculatorActivity {

    private var currentInput = ""
    private var firstOperand = 0.0
    private var currentOperator = ""

    fun calculate(a: Double, b: Double, op: String): Double {
        return when(op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> if(b != 0.0) a / b else 0.0
            else -> 0.0
        }
    }
}
