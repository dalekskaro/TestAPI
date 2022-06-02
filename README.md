# TestAPI
### Оглавление  
[Описание задачи](#описание_задачи)  
[Структура проекта](#структура_проекта)  
[Как запустить тесты](#запуск)  
## Описание задачи <a name="описание_задачи"></a> 
Написать API - автотесты для сайта https://petstore.swagger.io/ по одному методу из любых блоков (GET,PUT,POST,DELETE).  
#### GET-запрос
Проверить, что при запросе "string" выдает 200 http responce status, а при "ivan" - 404  
#### POST-запрос
Успешное создание нового пользователя (выдадет 200 http responce status)
  ```
  {  
  "id": 394,  
  "username": "123Solas123",  
  "firstName": "Solas",  
  "lastName": "Fenharel",  
  "email": "dreadwolf@mail.com",  
  "password": "ilovetea",  
  "phone": "88005553535",  
  "userStatus": 1  
}
```
#### PUT-запрос
Успешно обновление данных только что созданного пользователя. Меняется id, username, email, phone  
  ```
  {  
  "id": 999,  
  "username": "TheBestWolf",    
  "email": "dw@tedas.com",  
  "phone": "8800", 
}
```
#### DELETE-запрос
Успешное удаление пользователя с юзернеймом "TheBestWolf"
### Структура проекта <a name="структура_проекта"></a>   
**Проект состоит из двух java классов**:  
***UserData*** - POJO класс для пользователей  
***TestsSwagger*** - содержит в себе сами тесты  
### Как запустить тесты <a name="запуск"></a>  
1. Открыть проект в IntelliJ IDEA (либо другой среде разработки)
2. Ввести в консоли `mvn clean test`
