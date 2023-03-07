## Установка и запуск приложения, автотестов и отчетов

Учётные данные и url для подключения задаются в файле `application.properties`

* запустить IntelliJ IDEA
    * перейти в папку с проектом
        * cd ```Diploma```
    * запустить docker container (настройки в файле docker-compose.yml)
        * ```docker-compose up```
* в терминале IntelliJ IDEA запустить SUT:
    -  БД `MySQL` командой
  
      java "-Dspring.datasource.url=jdbc:mysql://185.119.57.47:3306/app" -jar artifacts/aqa-shop.jar

    -  БД `PostgreSQL` командой
  
      java "-Dspring.datasource.url=jdbc:postgresql://185.119.57.47:5432/app" -jar artifacts/aqa-shop.jar
  
* в терминале IntelliJ IDEA запустить автотесты командой:
    - для конфигурации БД `MySql`: 
  
      ```./gradlew clean test "-Ddb.url=jdbc:mysql://185.119.57.47:3306/app"```
    - для конфигурации БД PostgreSQL:  
      ```./gradlew clean test "-Ddb.url=jdbc:postgresql://185.119.57.47:5432/app"```
* в терминале IntelliJ IDEA запустить отчеты командой:
    - ```./gradlew allureReport (первоначальная команда)```
    - ```./gradlew allureServe (запуск и открытие отчетов)```
