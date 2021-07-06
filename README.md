## Автотесты на страницу: https://www.raiffeisen.ru/
# Технологии и инструменты используемые в тестах
<img style="width=40; height=40;" "src="https://github.com/dzyumalin/raiffeisen-autotests/raw/main/images/IDEA.svg"/>
![GITHUB](https://github.com/dzyumalin/raiffeisen-autotests/raw/main/images/GitHub.svg){: width=40 height=40}![JAVA](https://github.com/dzyumalin/raiffeisen-autotests/raw/main/images/JAVA.svg)![GRADLE](https://github.com/dzyumalin/raiffeisen-autotests/raw/main/images/Gradle.svg){: width=40 height=40}![JUNIT](https://github.com/dzyumalin/raiffeisen-autotests/raw/main/images/Junit5.svg){: width=40 height=40}![SELENIDE](https://github.com/dzyumalin/raiffeisen-autotests/raw/main/images/Selenide.svg){: width=40 height=40}![JENKINS](https://github.com/dzyumalin/raiffeisen-autotests/raw/main/images/Jenkins.svg){: width=40 height=40}![SELENOID](https://github.com/dzyumalin/raiffeisen-autotests/raw/main/images/Selenoid.svg){: width=40 height=40}![ALLUREREPORT](https://github.com/dzyumalin/raiffeisen-autotests/raw/main/images/Allure Report.svg){: width=40 height=40}![ALLURETESTOPS](https://github.com/dzyumalin/raiffeisen-autotests/raw/main/images/Allure TestOps.svg){: width=40 height=40}![TELEGRAM](https://github.com/dzyumalin/raiffeisen-autotests/raw/main/images/Telegram.svg){: width=40 height=40}
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


