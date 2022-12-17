package TestNG;

import org.testng.annotations.*;

public class ClassAnnotations {

    @Test
    void test2() {
        System.out.println("Test2 method");
    }

    @Test
    void test1() {
        System.out.println("Test1 method");
    }

    @Test
    void test3() {
        System.out.println("Test3 method");
    }
    @BeforeClass
    void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    void afterClass() {
        System.out.println("after class");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("before method");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("after method");
    }
}
//beforeclass
//beforemethod
//test1
//aftermethod
//beforemthod
//test2
//aftermethod
//afterclass
