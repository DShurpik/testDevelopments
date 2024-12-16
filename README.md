1. Demoblaze.com: mvn clean test -DsuiteXml="Demoblaze" -Dconfig="user"    
   For starting Demoblaze.xml with user.properties configurations

2. Demoblaze.com : mvn clean test -DsuiteXml="DemoblazePF"
   For starting DemoblazePF.xml without property file

3. mvn clean test -DsuiteXml="DDTest"
   Сommand for starting BuilderTests class with parameters from XML file

4. Command: mvn allure:serve for starting temp server
   Command: mvn allure:report to create an Allure report in the target directory, site directory, for viewing
   report via browser

5. mvn clean test -DsuiteXml="Profiles" -Dprofile=prod
6. mvn clean test -DsuiteXml="Profiles" -Dprofile=dev
7. mvn clean test -DsuiteXml="Profiles" -Dprofile=test
8. Для запуска тестов с разными профилями пользователей. Загрузка идет через ConfigLoader.class в loader
9. confOwnerUtils для загрузки нескольких файлов проперти и мержить их в 1. OwnersTest тесты различных загрузок 
проперти файлов