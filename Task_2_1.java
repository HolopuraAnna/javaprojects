/**
 * Task_2_1
 * @author Holopura Anna
 */

import java.util.Scanner;

public class Task_2_1 {
    public static void main(String[] args) {
        System.out.println("Input name");

        Scanner myObj = new Scanner(System.in);
        String name = myObj.nextLine();

        System.out.println("Hello " + name);
        
        myObj.close();
    }
}
