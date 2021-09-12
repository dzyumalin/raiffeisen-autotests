## Автотесты:
## UI - https://www.raiffeisen.ru/ <br> API - https://reqres.in/ <br> Mobile - <a href="https://play.google.com/store/apps/details?id=org.wikipedia&referrer=utm_source%3Dportal%26utm_medium%3Dbutton%26anid%3Dadmob">https://www.wikipedia.org/ </a>
# Технологии и инструменты используемые в тестах

 <img src="images/JAVA.svg" width="40" height="40">
 <img src="images/Gradle.svg" width="40" height="40">
 <img src="images/browserstack.jpeg" width="40" height="40">
 <img src="images/Junit5.svg" width="40" height="40">
 <img src="images/Selenide.svg" width="40" height="40">
 <img src="images/Selenoid.svg" width="40" height="40">
 <img src="images/IDEA.svg" width="40" height="40">  
 <img src="images/GitHub.svg" width="40" height="40">
 <img src="images/Jenkins.svg" width="40" height="40">  
 <img src="images/Allure Report.svg" width="40" height="40"> 
 <img src="images/Allure TestOps.svg" width="40" height="40">
 <img src="images/Jira_icon.png" width="40" height="40">
 <img src="images/Telegram.svg" width="40" height="40">

 `Gradle` `JUnit5` `Selenide` `Selenoid` `IDEA` `Github` `Jenkins` `Allure Report` `Allure TestOps` `Telegram`

### Параметры с помощью которых можно [запустить тесты](https://jenkins.autotests.cloud/job/raiffeisen-dmitryhli/build?delay=0sec):
![parameters](https://user-images.githubusercontent.com/48554235/132631901-704e82f9-03b7-4c50-b3ef-6bc68f9adeed.png)
* **TESTS_TAG** (web (для UI тестов), api (для API тестов) и mobile (для мобильных тестов))
* **DEVICE_HOST** (remoteweb (для UI тестов) и browserstack (для мобильных тестов))
* **BROWSER** (web параметр)
* **BROWSER_VERSION** (web параметр)
* **BROWSER_SIZE** (web параметр)
* **DEVICE** (mobile параметр)
* **PLATFORM_VERSION** (mobile параметр)
* **ALLURE_NOTIFICATIONS_VERSION** (По умолчанию 3.1.1)

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
## Результат выполнения Allure Report в Jenkins
![WEB](https://user-images.githubusercontent.com/48554235/132939526-6b5d28d4-e718-49d4-97c7-30ad250c8379.png)
## Allure TestOps
<img src="images/testops1.png" width="45%"> <img src="images/testops2.png" width="45%">
<img src="images/testops3.png" width="45%"> <img src="images/testops4.png" width="45%">

## Оповещение о прохождении тестов в telegram
(![R2D2](https://user-images.githubusercontent.com/48554235/132939853-f4ad636e-dd31-4a6b-87dd-29650e219612.png)
## Интеграция с Jira
<img src="images/Jira.png">

## Видео прохождение тестов из selenoid https://selenoid.autotests.cloud/#/
![20fe4121f338fa7c](https://user-images.githubusercontent.com/48554235/125010873-12205580-e070-11eb-9585-6ee00cb2d2c3.gif)