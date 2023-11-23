package Topic_4.Task_1_3;

/**
 * Task_1_3
 * @author Holopura Anna
 */

public class Task_1_3_Main
{
    public static void main(String[] args)
    {
        Task_1_3_Class t = new Task_1_3_Class();

        System.out.println(t.publicValue);
        //System.out.println(t.privateValue);    // error
        System.out.println(t.protectedValue);
        System.out.println(t.packageAccessValue);

        t.publicMethod();
        //t.privateMethod();   // error
        t.protectedMethod();
        t.packageAccessMethod();
    }
}
