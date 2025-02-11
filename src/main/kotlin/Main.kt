package org.example

import java.io.File
import org.example.models.Alumno

import java.time.LocalDate

fun main() {

    val file = File("data", "alumnos.csv")

    if (file.exists() && file.isFile && file.canRead()) {
        println("El fichero existe 👍")
    } else {
        throw IllegalArgumentException("El fichero no existe o no se puede leer 😔")
    }

    // leer el csv
    val alumnos = file.readLines()
        .drop(1) // para saltar la cabecera

        .map { linea -> linea.split(',') }
        .map { item ->
            Alumno(
                id = item[0].toInt(),
                nombre = item[1],
                createdAt = LocalDate.parse(item[2]),
                tipo = item[3],
                edad = item[4].toInt()
            )
        }

    println("Listado de Alumnos:")
    alumnos.forEach {println(it)}
    println()


    // alumno más mayor
    val mayor = alumnos.maxByOrNull { it.edad }
    println("Alumno más mayor -> $mayor")

    // alumno más joven
    val menor = alumnos.minByOrNull { it.edad }
    println("Alumno más joven -> $menor")

    // media de edad de alumnos
    val mediaEdad = alumnos.map { it.edad }.average()
    println("Media de edad -> $mediaEdad")

    // media de longitud de nombre
    val mediaLongitudNombre = alumnos.map { it.nombre.length }.average()
    println("Media de longitud de nombre -> $mediaLongitudNombre")

    // lista de agrupados por edad
    val listaAgrupadosPorEdad = alumnos.groupBy { it.edad }
    println("Lista de estudiantes agrupados por edad -> $listaAgrupadosPorEdad")

}