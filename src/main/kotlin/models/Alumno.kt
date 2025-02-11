package org.example.models
import java.time.LocalDate

data class Alumno(
    val id: Int,
    val nombre: String,
    val createdAt: LocalDate = LocalDate.now(),
    val tipo: String,
    val edad: Int
)