## Дз система управления магазинами.
1. Скачать репозиторий https://github.com/Ablazzing/shop-chain.  
   Вариантов для запуска два: либо открывать по очереди
   запустить в git bash вот эти команды  
   mvn clean install  
   java -jar -Dfile.encoding=UTF-8 -Dspring.profiles.active='seven' target/app.jar & java -jar -Dfile.encoding=UTF-8 -jar -Dspring.profiles.active='nine' target/app.jar  
2. Создать spring web приложение, которое:  
   2.1 Будет возвращать список наименований магазинов и их статус работы по запросу GET /shop/status.  
   2.1.1 Создать контроллер и метод для обработки http запроса выше.  
   2.1.2 Для получения статуса первого магазина сделает запрос   
   GET http://localhost:8081/application/status  
   2.1.3 Для получения статуса второго магазина сделает запрос    
   GET http://localhost:8082/application/status  
   Формат ответов двух магазинов будет одинаковый:  
   {  
   'name': 'Семерочка',  
   'status': 'work',  
   'time_open': '09:00',  
   'time_close': '18:00'  
   }  
   2.1.4  Вернуть список статусов магазинов:  
   [  
   {  
   'name': 'Семерочка',  
   'status': 'work',  
   'time_open': '09:00',  
   'time_close': '18:00'  
   },  
   {  
   'name': 'Девяточка',  
   'status': 'work',  
   'time_open': '09:00',  
   'time_close': '18:00'  
   }  
   ]  

2.2 Будет менять стоимость товара в магазинах по запросу PATCH /shop/good. Пример тела запроса:  
{  
"name": "Хлеб",  
"new_price": 200  
}  
2.2.1 Создать контроллер и метод для обработки http запроса выше.  
2.2.2 Отправить по следующим адресам отправить http запрос с полученным body из 2.2.1:  
PATCH http://localhost:8081/shop/good  
PATCH http://localhost:8082/shop/good

Для тестирования работоспособности метода 2.2:  
стоимость хлеба можно посмотреть через Insomnia до и после запуска метода обновления стоимости  
GET http://localhost:8081/shop/good?name=хлеб  
GET http://localhost:8082/shop/good?name=хлеб  

3. Подключить swagger и сделать описание методов и контроллеров вашего приложения.