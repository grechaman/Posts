package ru.netology

import kotlin.random.Random

data class Users(
    val names: String,
    val id: Int = Random.nextInt(1000)
)