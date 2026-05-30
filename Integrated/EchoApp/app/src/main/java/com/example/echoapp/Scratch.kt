package com.example.echoapp

fun greetUser(name: String): String {
    return "Hello, $name!"
}

fun main() {
    println(greetUser("Vera"))
}
