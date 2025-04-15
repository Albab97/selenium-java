package demo;

import org.testng.annotations.Test;

public class TestClass05 extends BaseClass{
    public void method01(){
        System.out.println("TestClass05 : Inside method01");
    }
    @Test
    public void method02(){
        System.out.println("TestClass05 : Inside method02");
    }
}
