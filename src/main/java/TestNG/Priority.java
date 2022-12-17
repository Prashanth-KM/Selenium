package TestNG;

import org.testng.annotations.Test;

public class Priority {

    @Test(priority = 2)
    void test1(){
        System.out.println("test1");
    }

    @Test(priority = 1)
    void test2(){
        System.out.println("test2");
    }

    @Test(priority = 0)
    void test3(){
        System.out.println("test3");
    }

    @Test(priority = -1)
    void test4(){
        System.out.println("test4");
    }

    @Test(priority = -2)
    void test5(){
        System.out.println("test5");
    }

    @Test(enabled = false)
    void test6(){
        System.out.println("test6");
    }

    @Test(invocationCount = 5)
    void test7(){
        System.out.println("test7");
    }

    @Test(alwaysRun = true)
    void test(){
        System.out.println("test");
    }

    @Test
    void test9(){
        System.out.println("test9");
    }

    @Test
    void test8(){
        System.out.println("test8");
    }

}
