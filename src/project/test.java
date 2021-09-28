package project;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Scanner;



public class test
{
@Test 
public void testMain() throws FileNotFoundException {
    
    Scanner keyboard = new Scanner(System.in);
    System.out.println("enter un entier maximum : ");
    int myint = keyboard.nextInt();
    keyboard.close();
    Main main = new Main(myint);
    main.start();
    
    //main.getResultat().close();
}
}
