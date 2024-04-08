# Administracion de consultorio odontologico

Este proyecto implementa una aplicación web utilizando Spring Boot para el backend y HTML, CSS y JavaScript para el frontend. Este archivo README proporciona una visión general del proyecto y guía sobre cómo ejecutarlo.

## Capas de la Aplicación

1. **Capa de Entidades de Negocio:**
   - En esta capa, definimos las clases Java que representan las entidades de nuestro negocio, siguiendo el paradigma orientado a objetos.

2. **Capa de Acceso a Datos (Repository):**
   - Las clases en esta capa se encargan de interactuar con la base de datos. Utilizaremos el patrón Repository para gestionar la persistencia de datos.

3. **Capa de Datos (Base de Datos):**
   - La base de datos de la aplicación está modelada utilizando un esquema entidad-relación. Para este proyecto, hemos optado por la base de datos H2 debido a su facilidad de uso y configuración.

4. **Capa de Negocio:**
   - En esta capa, definimos las clases de servicio (Service) que encapsulan la lógica de negocio. Estas clases desacoplan el acceso a datos de la capa de presentación.

5. **Capa de Presentación:**
   - Esta capa consiste en las pantallas web desarrolladas utilizando el framework Spring Boot MVC para manejar los controladores. Para la vista, hemos elegido utilizar HTML y JavaScript, junto con CSS para estilos adicionales.

## Tecnologías Utilizadas

- **Spring Boot:** Framework para crear aplicaciones Java rápidamente.
- **HTML:** Lenguaje de marcado para la estructura de las páginas web.
- **CSS:** Lenguaje de estilos para el diseño de las páginas web.
- **JavaScript:** Lenguaje de programación para la interactividad en el lado del cliente.
- **H2 Database:** Base de datos en memoria para el desarrollo y pruebas.
## Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Clona este repositorio en tu máquina local.
2. Importa el proyecto en tu IDE preferido como un proyecto Maven existente.
3. Ejecuta la aplicación Spring Boot.
4. Abre tu navegador y navega a `http://localhost:8081` para ver la aplicación en funcionamiento.
