## Отчет по тестированию.

Произведено автоматизированное тестирование формы оплаты "Путешесвие дня - Марракэш"

Способы оплаты разделен на две категорий
- Оплата по дебетовой карте
- Выдача кредита с указанием банковкой карты

### При тестирований были проверены процессы:
- сохранение информации в СУБД (MySQL и PostgreSQL)
- взаимодействие приложения с банковскими сервисами;
- функциональность формы оплаты (по дебетовой карте и в кредит) через веб-браузер Google Chrome;

### Результаты

Общее количество тест-кейсов 25, повторяющихся для обеих СУБД:
- 2 позитивных тестов (по 2 для каждого способа оплаты)
- 18 негативных тестов (по 2 для каждого способа оплаты)

### Отчет Gradle
![](https://sun9-36.userapi.com/impg/QO6NyadR2y7XoYuhTZGvORMBKYLwuBAouedRFg/6Bvzde_2YxY.jpg?size=707x476&quality=96&sign=8590532ac506b7d3dd996c17f05140ce&type=album)

### Баг-реппорты
Описаны в `issues` в репозиторий GitHub проекта


### Общие рекомендации

- Устранить найденные баги
- Провести повторное тестирование
- Составить техзадание на продукт с указанием требований к полям
______________
Во время тестирования пришлось отказатся от Allure 


