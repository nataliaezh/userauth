# userauth

Ссылка на swagger http://localhost:8189/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
В БД postgres создать схему userauth, поменять логин и пароль в application.properties
Послать Post запрос на http://localhost:8189/register
Тестовые данные:
{
"email":"liz@mail.ru",
"password":91011
}

Далее можно получить токен через POST запрос http://localhost:8189/auth
скрипты с тестовыми данными для дркгих таблиц в БД
INSERT INTO profiles (id,cash,user_id) VALUES (1, 45.00, 1);
INSERT INTO profiles (id,cash,user_id) VALUES (2, 55.00, 2);

INSERT INTO phones (id,value,user_id) VALUES (1, '89163597331', 1);
INSERT INTO phones (id,value,user_id) VALUES (2, '89163597332', 2);
