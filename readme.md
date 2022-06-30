Berikut adalah automation test script dari challange yang dikerjakan:

## Pages
- BasePage: [src/main/java/sircloproject/qa2022/pages/BasePage.java](./src/main/java/sircloproject/qa2022/pages/BasePage.java)
- DataPage: [src/main/java/sircloproject/qa2022/pages/DataPage.java](./src/main/java/sircloproject/qa2022/pages/DataPage.java)
- HomePage [src/main/java/sircloproject/qa2022/pages/HomePage.java](/src/main/java/sircloproject/qa2022/pages/HomePage.java)
- LoginPage [src/main/java/sircloproject/qa2022/pages/LoginPage.java](./src/main/java/sircloproject/qa2022/pages/LoginPage.java)

## Test
- BaseWebTest: [src/test/java/sircloproject/qa2022/BaseWebTest.java](./src/test/java/sircloproject/qa2022/BaseWebTest.java)
- WebTestAfterPOM yang dapat di run as testNG (7 test case passed) [src/test/java/sircloproject/qa2022/WebTestAfterPOM.java](./src/test/java/sircloproject/qa2022/WebTestAfterPOM.java) maka akan tampak seperti gambar: [java_testng_qatest.jpeg](./java_testng_qatest.jpeg),

atau dapat di test/ Build Now dengan Jenkins pada goals: clean test -DsuiteXmlFile=WebSuite.xml -X 

akan seperti gambar: [Jenkins_qatest_repository.jpeg](./Jenkins_qatest_repository.jpeg)
