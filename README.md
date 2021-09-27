## Автотесты:
## UI - https://www.raiffeisen.ru/ <br> API - https://reqres.in/ <br> Mobile - <a href="https://play.google.com/store/apps/details?id=org.wikipedia&referrer=utm_source%3Dportal%26utm_medium%3Dbutton%26anid%3Dadmob">https://www.wikipedia.org/ </a>
# Технологии и инструменты используемые в тестах


<table>
<tbody>
<tr>
<td align="center"><img src="images/JAVA.svg" width="40" height="40"><br>Java</td>
<td align="center"><img src="images/Gradle.svg" width="40" height="40"><br>Gradle</td>
<td align="center"><img src="images/Browserstack.svg" width="40" height="40"><br>Browserstack</td>
<td align="center"><img src="images/Junit5.svg" width="40" height="40"><br>JUnit5</td>
<td align="center"><img src="images/Selenide.svg" width="40" height="40"><br>Selenide</td>
<td align="center"><img src="images/Appium.svg" width="40" height="40"><br>Appium</td>
<td align="center"><img src="images/Selenoid.svg" width="40" height="40"><br>Selenoid</td>
</tr>
<tr>
<td align="center"><img src="images/IDEA.svg" width="40" height="40"><br>IDEA</td>
<td align="center"><img src="images/GitHub.svg" width="40" height="40"><br>Github</td>
<td align="center"><img src="images/Jenkins.svg" width="40" height="40"><br>Jenkins</td>
<td align="center"><img src="images/Allure Report.svg" width="40" height="40"><br>Allure Report</td>
<td align="center"><img src="images/Allure TestOps.svg" width="40" height="40"><br>Allure TestOps</td>
<td align="center"><img src="images/Jira-icon.svg" width="40" height="40"><br>Jira</td>
<td align="center"><img src="images/Telegram.svg" width="40" height="40"><br>Telegram</td>


</tr>
</tbody>
</table>

  
  
  
  

UI
* Тест на скачивание и проверку PDF файла
* Проверка наличия заголовка на главной странице
* Проверка наличия заголовка "Для ипотечных клиентов"
* Проверка наличия заголовка "Ипотечные программы"
* Проверка калькулятора ипотеки

API
* Авторизация
* Ошибка авторизации
* Создание пользователя
* Получение и проверка списка пользователей
* Получение и проверка пользователя
* Получение и проверка года рождения в списке пользователей
* Обновление информации о пользователе

Mobile
* Проверка формы авторизации
* Проверка страницы приветствия
* Поиск и проверка адреса банка

### Параметры с помощью которых можно [запустить тесты](https://jenkins.autotests.cloud/job/raiffeisen-dmitryhli/build?delay=0sec):
![Screenshot 2021-09-12 at 17-14-08 Jenkins](https://user-images.githubusercontent.com/48554235/132991039-02ade48f-0d62-4da6-8733-25fd022634c3.png)
* **TESTS_TAG** (web (для UI тестов), api (для API тестов) и mobile (для мобильных тестов))
* **DEVICE_HOST** (remoteweb (для UI тестов) и browserstack (для мобильных тестов))
* **BROWSER** (web параметр)
* **BROWSER_VERSION** (web параметр)
* **BROWSER_SIZE** (web параметр)
* **DEVICE** (mobile параметр)
* **PLATFORM_VERSION** (mobile параметр)
* **ALLURE_NOTIFICATIONS_VERSION** (По-умолчанию 3.1.1)
* **THREADS** (По-умолчанию 1)

## Запуск тестов из терминала
### Запуск web тестов c localweb.properties / remoteweb.properties:
```bash
gradle clean web -DdeviceHost=localweb
gradle clean web -DdeviceHost=remoteweb
```
### Запуск web тестов без localweb.properties / remoteweb.properties:
```bash
gradle clean web -Ddriver=SelenoidDriver -Dbrowser=chrome -DbrowserVersion=91.0 -DbrowserSize=1920x1080
gradle clean web -Ddriver=SelenoidDriver -Dbrowser=chrome -DbrowserVersion=91.0 -DbrowserSize=1920x1080 -Dhub.url=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -Dselenoid.video.storage=https://selenoid.autotests/cloud/video/
```
### Запуск api тестов
```bash
gradle clean api
```
### Запуск mobile тестов c localmobile.properties / browserstack.properties:
```bash
gradle clean mobile -DdeviceHost=localmobile
gradle clean mobile -DdeviceHost=browserstack
```
### Собрать Allure отчет:
```bash
allure serve build/allure-results
```
## Allure Report
### Пример автоматизированного тест кейса
![WEB](https://user-images.githubusercontent.com/48554235/132939526-6b5d28d4-e718-49d4-97c7-30ad250c8379.png)
## Allure TestOps
### Пример автоматизированного тест кейса
<img src="images/testops1.png"> 

### Доска с аналитикой тестирования
<img src="images/testops2.png">

### Доска с командой тестирования и аналитикой
<img src="images/testops4.png">
## Оповещение о прохождении тестов в Telegram
(![R2D2](https://user-images.githubusercontent.com/48554235/132939853-f4ad636e-dd31-4a6b-87dd-29650e219612.png)
## Интеграция с Jira
<img src="images/Jira.png">

## Видео прохождение тестов из selenoid https://selenoid.autotests.cloud/#/
![0d6f346266bd9b031ad3168880297f7d](https://user-images.githubusercontent.com/48554235/132976900-e1093450-6eae-4d8b-937c-744f895080b1.gif)
![1dc9bf86022b3904437bc3fb6e9f14316eaa2d13](https://user-images.githubusercontent.com/48554235/132976904-334f9332-231c-4754-91b7-f9ab92be566c.gif)
