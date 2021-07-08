## Автотесты на страницу: https://www.raiffeisen.ru/
# Технологии и инструменты используемые в тестах

 <img src="images/IDEA.svg" width="40" height="40">  <img src="images/GitHub.svg" width="40" height="40">
 <img src="images/JAVA.svg" width="40" height="40">  <img src="images/Gradle.svg" width="40" height="40">
 <img src="images/Junit5.svg" width="40" height="40">  <img src="images/Selenide.svg" width="40" height="40"> 
 <img src="images/Jenkins.svg" width="40" height="40">  <img src="images/Selenoid.svg" width="40" height="40">
 <img src="images/Allure Report.svg" width="40" height="40"> <img src="images/Allure TestOps.svg" width="40" height="40"> 
 <img src="images/Telegram.svg" width="40" height="40">
 
### Параметры с помощью которых можно [запустить тесты](https://jenkins.autotests.cloud/job/raiffeisen-dmitryhli/build?delay=0sec):
![parameters](https://user-images.githubusercontent.com/48554235/124589772-0875d280-de63-11eb-9fcd-87a38b8a04f9.png)
* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)

## Запуск тестов из терминала
### Запуск теста по умолчанию:
```bash
gradle clean test
```
### Запуск теста с нужными параметрами:
```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

### Собрать отчет в Allure:
```bash
allure serve build/allure-results
```
## [анализ результатов](https://jenkins.autotests.cloud/job/raiffeisen-dmitryhli/17/allure/#suites) Allure Report
![allure](https://user-images.githubusercontent.com/48554235/124589627-e2e8c900-de62-11eb-8c82-a7796dc03eb5.png)
## [анализ результатов](https://allure.autotests.cloud/project/241/test-cases?treeId=0) Allure TestOps
![allure-testops](https://user-images.githubusercontent.com/48554235/124589735-fe53d400-de62-11eb-880c-77d141614af7.png)
## Оповещение о прохождении тестов в telegram
![telegram](https://user-images.githubusercontent.com/48554235/124589747-03188800-de63-11eb-879b-d4c75d6592d5.png)
## Видео прохождение тестов прямиком из selenoid
![5ea9af587bbda6ed](https://user-images.githubusercontent.com/48554235/124590515-e4ff5780-de63-11eb-8f89-60602eb07df6.gif)


