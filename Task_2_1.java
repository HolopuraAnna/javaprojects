/**
 * Task_2_1
 * @author Holopura Anna
 */

package Topic_2;

public class Task_2_1
{
    public static void main(String[] args) {
        int a = 10;
        int b = 21;
    
        int a1 = a >> 1;
        int b1 = b << 1;
        int c = a&b;
        int d = a|b;
        int e = a^b;
        int f = ~b;
    
        int g = -10;
        int g1 = g >>> 2;
        int g2 = g << 2;
    
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(a1));
        System.out.println(Integer.toBinaryString(b1));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(d));
        System.out.println(Integer.toBinaryString(e));
        System.out.println(Integer.toBinaryString(f));
        System.out.println(Integer.toBinaryString(g));
        System.out.println(Integer.toBinaryString(g1));
        System.out.println(g1);
        System.out.println(g2);
        }
}
