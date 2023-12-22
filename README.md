# Backend
Микросервисное Spring Boot приложение c применением Spring Cloud 
## 1.verba-proxy 
Микросервис являющийся единой точкой входа в микросервисную среду 

Функции:
- переадресация запросов на микросервисы
- аутентификация запросов

Технологический стэк:
- Kotlin
- Spring Boot 3.0
- Spring Cloud Gateway
- Spring Cloud Eureka Client
 
## 2.verba-api
Микросервис предоставляющий основное внешнее API для работы с сущностями БД   

Функции:
- предоставление внешнему сервису точки для изменения состояния БД

Технологический стэк:
- Kotlin
- Spring Boot 3.0
- JPA (hibernate)
- JUnit5
- TestContainer 
- MapStruct
- Swagger
- Flyway(Миграция БД)
- Spring Cloud Eureka Client
 

## 3.verba-auth
Микросервис предоставляющий основное внешнее API для авторизации и аутентификации пользователей

Функции:
- создание пользователей 
- создание токенов доступа 

Технологический стэк:
- Java
- Spring Boot 3.0
- JPA (hibernate)
- Spring Cloud Eureka Client

## 4. eureka-server
Микросервис создающий сетевое пространство для других микросервисов 

Функции:
- регистрация микросервисов в сетевом пространстве 
- валидация состояний микросервисов 
- регулирование коммуникации микросервисов 


Технологический стэк:
- Java
- Spring Boot 3.0
- Spring Cloud Eureka Server 

## 5.verba-data 
Микросервис предоставляющий основное внешнее API для работы с данными внешних API

Функции:
- поиск информации по слову
- перевод слова 
- поиск картинок связанных с словом 

Технологический стэк:
- Java
- Spring Boot 3.0
- Retrofit 2
- Spring Cloud Eureka Client

# Система сборки
- Gradle

# Система деплоя 
- Docker Compose

# Запуск 
1. Получение jar
```
./gradlew bootJar
```
2. Запуск контейнеров
```
docker-compose up -d --force-recreate --no-deps --build
```

# Вещи на подумать 
- [Вместо hibernate](https://github.com/JetBrains/Exposed)
- [радар tinkoff](https://radar.tinkoff.ru/android/m-agent/)
- [можно использовать для создания мини-сервис приложений](https://www.http4k.org/)
