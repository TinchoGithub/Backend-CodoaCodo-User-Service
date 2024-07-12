# User Service API

Este proyecto es una API de servicio de usuarios desarrollada en Java con servlets y JDBC. Proporciona operaciones CRUD básicas para gestionar usuarios en una base de datos MySQL y devuelve respuestas HTTP adecuadas para cada solicitud.

## Características

- **Crear Usuario**: Permite registrar un nuevo usuario en la base de datos.
- **Listar Usuarios**: Obtiene todos los usuarios registrados.
- **Obtener Usuario por ID**: Recupera los detalles de un usuario específico.
- **Actualizar Usuario**: Actualiza la información de un usuario existente.
- **Eliminar Usuario**: Elimina un usuario de la base de datos.

## Tecnologías Utilizadas

- Java
- Servlets
- JDBC
- MySQL
- Apache Tomcat

## Endpoints
- **POST** /usuarios: Crea un nuevo usuario.
- **GET** /usuarios: Obtiene todos los usuarios.
- **GET** /usuarios/{id}: Obtiene un usuario por ID.
- **PUT** /usuarios: Actualiza un usuario existente.
- **DELETE** /usuarios/{id}: Elimina un usuario.