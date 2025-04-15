package demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClass04 {
    @Test
    public void method01(){
        System.out.println("Method01 starts.");
        Assert.assertTrue(80>10);
        System.out.println("Method01 ends.");
    }

    @Test
    public void method02(){
        System.out.println("Method02 starts.");
        Assert.assertEquals("Hello user!","Hello user.","Message mismatch");
        System.out.println("Method02 ends.");
    }
    // Behaviour of Hard Assertions : We are checking 2 conditions in the same method using Assert class then if the 1st condition fails then rest of the code will not execute in that method.
    // If we want to check both the conditions and then state the results then we have to use Soft Assertion.
    @Test
    public void method03(){
        System.out.println("Checking 1st condition");
        Assert.assertEquals(10,15);
        System.out.println("Checking 2nd condition");
        Assert.assertEquals("Hi","Hi");
    }

    SoftAssert sa = new SoftAssert();
    @Test
    public void method04(){
        System.out.println("Checking 1st condition");
        sa.assertEquals(10,15);
        System.out.println("Checking 2nd condition");
        sa.assertEquals("Hi","Hi");

        sa.assertAll(); // to collate the overall result of both conditions
    }
}
