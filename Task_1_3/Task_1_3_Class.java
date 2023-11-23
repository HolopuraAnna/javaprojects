package Topic_4.Task_1_3;

public class Task_1_3_Class
{
    public String publicValue = "public value";
    private String privateValue = "private value";
    protected String protectedValue = "protected value";
    String packageAccessValue = "package access value";

    public void publicMethod()
    {
        System.out.println("public method.");
    }

    private void privateMethod()
    {
        System.out.println("private method.");
    }

    protected void protectedMethod()
    {
        System.out.println("protected method.");
    }

    void packageAccessMethod()
    {
        System.out.println("package access method.");
    }
}
