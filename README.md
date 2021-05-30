# Technical Workshop - Arquitecturas Reactivas.

En este Workshop veremos como crear un servicio de Http de forma reactiva utilizando vert.X.

También crearemos un servicio standard para mostrar sus diferencias.

## Requisitos
```
1. Tener instalado JDK Java 11.
2. Tener instalado Gradle 6.
```

## Standard Http Service

Para este ejemplo utilizaremos `HttpServer` de Oracle.

Crearemos un handler con las siguientes características:

|Method | Path | Response |
|-------|------|----------|
|[GET]| `/hello`| Hello World!|


#### Para Iniciarlo

Solo debemos correr en la raiz el siguiente comando:

```
gradle standard:run 
```

Luego llamaremos desde un browser el siguiente link

[http://localhost:8080/hello](http://localhost:8080/hello)

## Vert.X Http Service

Para este ejemplo crearemos un AbstractVerticle y crear un Http Server de Vert.X.

Crearemos un handler con las siguientes características:

|Method | Path | Response |
|-------|------|----------|
|[GET]| `/hello`| Hello World!|

#### Para Iniciarlo

Solo debemos correr desde la carpeta raiz el siguiente comando:

```
gradle vertx:run 
```

Luego llamaremos desde un browser el siguiente link

[http://localhost:8080/hello](http://localhost:8080/hello)


### Ejercicio:

*  En la cabecera de los servicios está un `logger`. Deberá incluirlo en tres estados: 
    1. Al momento de recibir un request.
    2. Al momento procesar el request.
    3. Al momento de responder el request.
    
* La función `greeting()`, tendrá que simular carga de al menos 2,5 segundos.


Muchas Gracias.
