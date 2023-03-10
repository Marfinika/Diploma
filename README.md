## Установка и запуск приложения, автотестов и отчетов

Учётные данные и url для подключения задаются в файле `application.properties`

* запустить IntelliJ IDEA
    * перейти в папку с проектом
        * cd ```Diploma```
    * запустить docker container (настройки в файле docker-compose.yml)
        * ```docker-compose up```
______
* запустить SUT:
    -  БД `MySQL` командой
  
       java -jar artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:mysql://localhost:3306/app

    -  БД `PostgreSQL` командой
  
      java -jar artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app
  
___________
* запустить автотесты командой:
    - для конфигурации БД `MySql`: 
  
      ```./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"```
    - для конфигурации БД PostgreSQL:  
      ```./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"```
___________
* запустить отчеты командой:
    - ```./gradlew allureReport (первоначальная команда)```
    - ```./gradlew allureServe (запуск и открытие отчетов)```
