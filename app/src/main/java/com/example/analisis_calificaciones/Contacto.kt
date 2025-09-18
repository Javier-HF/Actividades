package com.example.analisis_calificaciones

data class Contacto(var nombre: String, var telefono: String)
class Agenda {
    private val contactos = mutableListOf<Contacto>()

    fun agregarContacto(nombre:String, telefono: String) { /*Crea un nuevo objeto Contacto y lo añade a la lista.*/
        val nuevoContacto = Contacto(nombre, telefono)
        contactos.add(nuevoContacto)
        println("Se ha agregado un nuevo contacto")
    }
    fun mostrarTodosLosContactos() {/* Imprime en la consola la lista completa de contactos de forma ordenada. Si no hay contactos, debe mostrar un mensaje indicándolo.*/
        if (contactos.isEmpty()){
            println("Ups, no se encontro ningun contacto")
        }
        else {
            contactos.sortedBy { it.nombre.lowercase() }.forEachIndexed { index, contacto ->
                println("${index + 1}. Nombre: ${contacto.nombre} - Teléfono: ${contacto.telefono}")
            }
        }
    }
    fun buscarContacto(nombre: String?): Contacto? {/* Busca en la lista un contacto cuyo nombre coincida exactamente con el proporcionado. Si lo encuentra, devuelve el objeto Contacto. Sino, devuelve null.*/
        if (nombre == null) return null
        return contactos.find { it.nombre.equals (nombre, ignoreCase = true)}
    }

    }
    fun main(){
        val agenda= Agenda()
        var opcion=0
        while (opcion!=4){
            println("Agenda mia \n1. Añadir nuevo contacto\n2. Mostrar todos los contactos\n3. Buscar contacto\n4. Salir(chao)")
            opcion = readLine()?.toIntOrNull() ?: 0
            when(opcion){
                1->{
                    println("Ingresa el nombre de contacto")
                    val nombre=readLine()?.trim()
                    println("Ingresa el numero de contacto")
                    val telefono=readLine()?.trim()
                    if (!nombre.isNullOrEmpty() && !telefono.isNullOrEmpty()) {
                        agenda.agregarContacto(nombre, telefono)
                    }
                }
                2-> agenda.mostrarTodosLosContactos()
                3->{
                    println("Ingresa un nombre a buscar")
                    val nomBuscado = readLine()?.trim()
                        val encontrado = agenda.buscarContacto(nomBuscado)
                        if (encontrado != null) {
                            println("Contacto encontrado:")
                            println("Nombre: ${encontrado.nombre} - Teléfono: ${encontrado.telefono}")
                        } else {
                            println("No se encontró el contacto.")
                        }
                }
            }
        }
    }


