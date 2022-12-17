package TestNG;

import org.testng.annotations.Test;

public class DependsOn {

    @Test(dependsOnMethods = "registration")
    void login(){
        System.out.println("login");
    }

    @Test
    void registration(){
        System.out.println("registration");
    }
}
