# Lord of the Rings RPG - Ironhack Project

Este proyecto es una API para gestión de personajes, razas y eventos del universo LOTR, con autenticación JWT y base de datos relacionales. 
Implementación de todas las operaciones CRUD y patron de diseño por capas definidas
Modelado de Bases de Datos (DB) utilizando relaciones complejas y persistencia mediante herencia JPA, mejorando la escalabilidad
Diagrama de clases donde se esquematizan: DTOs, Security, Controller, Service, Repository, DAOs...
Fue desarrollado como parte del bootcamp de desarrollo web backend en Ironhack.

Tecnologías Utilizadas
- Java
- Programación Orientada a Objetos (OOP)
- Git / GitHub
- IntelliJ IDEA
- Spring Boot
- JWT
- MySQL
- Postman

Estructura del Proyecto

/src/main
- controller
- dao
- dto
- enums
- exceptions
- JWTlogin
- models
- repositories
- security
- service
/resources
- json
- querys SQL

Endpoints (ejemplo)
GET (All individuals, Elfs, Dwarfs, Humans, Events, exception)
POST (Add -Elf, Dwarf, Human-, AddEvent, AddRaceToEvent, 
PUT updateEvent
PATCH Event, exception
DELETE individual by ID
Probados mediante Postman

Cómo Ejecutar
Clona el repositorio: git clone https://github.com/Kirutasu/Project_LordOfTheRingsIronhack.git
Abre el proyecto en tu IDE de Java (recomendado: IntelliJ)
Ejecuta la clase Main.java

Pendiente / Mejoras Futuras
-Añadir interfaz gráfica (GUI)
-Mayor variedad de personajes y habilidades
