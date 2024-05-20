## Вступ
Цей проект є реалізацією гри "Хрестики-Нолики" для двох гравців через мережу. Він складається з двох частин: клієнта та сервера. Клієнт є графічним інтерфейсом гри, який зв'язується з сервером для гри. Сервер є центром гри, який керує ходом гри та зв'язує клієнтів між собою.

## Опис роботи

**Клієнт (Client.java)**

Клієнт є графічним інтерфейсом гри, який зв'язується з сервером для гри. Він складається з наступних елементів:

* JFrame - вікно гри, яке містить поле для гри та повідомлення про стан гри.
* Square - клас, який представляє окреме поле гри. Кожне поле може бути або вільним, або зайнятим крестиком або ноликом.
* Socket - об'єкт, який зв'язує клієнта з сервером.
* BufferedReader та PrintWriter - об'єкти, які дозволяють клієнту читати та писати дані на сервер.

Клієнт виконує наступні дії:

* Зв'язується з сервером за допомогою сокета.
* Створює графічний інтерфейс гри, який складається з поля для гри та повідомлення про стан гри.
* Реєструє слухача для обробки подій миші на полі гри.
* Очікує на повідомлення від сервера про стан гри та оновлює графічний інтерфейс відповідно.

**Сервер (Server.java)**

Сервер є центром гри, який керує ходом гри та зв'язує клієнтів між собою. Він складається з наступних елементів:

* ServerSocket - об'єкт, який слухає з'єднання від клієнтів.
* Game - клас, який представляє гру та керує ходом гри.
* Player - клас, який представляє гравця та керує його ходом.

Сервер виконує наступні дії:

* Створює об'єкт Game, який керує ходом гри.
* Очікує на з'єднання від клієнтів та створює об'єкти Player для кожного клієнта.
* Зв'язує клієнтів між собою, щоб вони могли грати один проти одного.
* Керує ходом гри, перевіряючи, чи є переможець, чи гра закінчена внічию.

