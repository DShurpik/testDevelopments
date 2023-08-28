package firstHW.task1;

import org.testng.annotations.*;

public class Annotation {

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @BeforeClass
    public void beforeclass(){
        System.out.println("BeforeClass");
    }
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite");
    }
    @BeforeGroups
    public void BeforeGroup(){
        System.out.println("BeforeGroups");
    }
    @Test
    public void test1(){

        System.out.println("1 test");
    }
    @Test
    public void test2(){
        System.out.println("test 2");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite");
    }
    @AfterGroups
    public void AfterGroups(){
        System.out.println("AfterGroups");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod");
    }
    @AfterClass
    public void AfterClass() {
        System.out.println("AfterClass");
    }
}
