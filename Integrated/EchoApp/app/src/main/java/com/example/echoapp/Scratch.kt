package com.example.echoapp

data class User(
    val username: String,
    var score: Int
)

fun main() {
    val users = listOf(
        User("Alice",100),
        User("Bob",90),
        User("Charlie",80)
    )

    for(user in users) {
        println(user)
    }
}
