#Task: CTF-hackathon

Условие: 

Идет CTF-соревнование, в котором участвуют команды. Также даны различные сервера, которые командам необходимо взломать. Цель - взломать наибольшее к-во серверов с наименьшим штрафом. 
Если команда совершает неудачную попытку взлома - к их времени на решение данной задачи прибавляется штраф 20 минут за каждую неудачную попытку. 
Если команда по итогам соревнования не взломала сервер, штрафное время взлома этого сервера не учитывается в финальный зачет.
Если команде удалось взломать сервер, то время на взлом этого сервера состоит из времени, за которое они его взломали с момента начала соревнования + штраф за неудачные попытки (если есть).
Финальная таблица формируется следующим образом: побеждает команда, взломавшая наибольшее к-во серверов. В случае равенства, учитывается наименьшее затраченное время.

На вход подается время начала соревнования, суммарное количество попыток взлома N от всех команд, а затем N строк формата: 
название команды, время совершенной попытки, тип попытки

Где существует 3 типа попытки - FORBIDDEN, DENIED, ACCESED. Сервер считается взломанным, если тип попытки - ACCESSED.

Пример входных данных:

00:00:00

5

"VK" 00:10:21 A FORBIDDEN

"T" 00:00:23 A DENIED

"T" 00:20:23 A ACCESSED

"VK" 00:30:23 A ACCESSED

"YA" 00:40:23 B ACCESSED
