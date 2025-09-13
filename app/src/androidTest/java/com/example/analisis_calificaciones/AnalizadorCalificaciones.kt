package com.example.analisis_calificaciones

class AnalizadorCalificaciones {
    val calificaciones = mutableListOf<Float>()
    fun agregarCalificacion(calificacion: Float) {
        calificaciones.add(calificacion)
    }
    fun calcularPromedio(): Float {/*Devuelve el promedio de las calificaciones*/
        return if (calificaciones.isNotEmpty()) calificaciones.average().toFloat() else 0f
    }
    fun contarAprobadas(): Int{/*Devuelve el número de materias con calificación igual o mayor a 7*/
        return calificaciones.count { it >= 7 }
    }
    fun contarReprobadas(): Int {/*Devuelve el número de materias con calificación menor a 7*/
        return calificaciones.count { it < 7 }
    }
    fun obtenerCalificacionMaxima(): Float {/*Devuelve la calificación más alta del arreglo*/
        return calificaciones.maxOrNull() ?: 0f
    }
    fun obtenerCalificacionMinima(): Float {/*Devuelve la calificación más baja del arreglo.*/
        return calificaciones.minOrNull() ?: 0f
    }

    fun main() {
        val verificar = AnalizadorCalificaciones()
        println("Solicitud de calificaciones")
        for (i in 1..7) {
            println("Ingresa la calificacion: ${i}:° ")
            val calif: Float = readln().toFloat()
            verificar.agregarCalificacion(calif)
            calificaciones.add(calif)
        }
        println("\nResultados:")
        println("Promedio final: ${verificar.calcularPromedio()}")
        println("Número de materias aprobadas: ${verificar.contarAprobadas()}")
        println("Número de materias reprobadas: ${verificar.contarReprobadas()}")
        println("Calificación más alta: ${verificar.obtenerCalificacionMaxima()}")
        println("Calificación más baja: ${verificar.obtenerCalificacionMinima()}")
    }
}