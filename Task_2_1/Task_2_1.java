package Topic_4.Task_2_1;

/*
 * Task_2_1
 * @author Holopura Anna
 */

public class Task_2_1
{
    public static void serchByFaculty(Student[] students, String faculty)
    {
        System.out.printf("students on %s faculty:\n", faculty);

        for (Student s: students)
        {
            if(s.getFaculty().equals(faculty))
            {
                s.printStudent();
            }
        }
    }

    public static void serchByYear(Student[] students, Integer Year)
    {
        System.out.printf("students born since %d:\n", Year);

        for (Student s: students)
        {
            if(s.getBirthYear() >= Year)
            {
                s.printStudent();
            }
        }
    }

    public static void serchByGroup(Student[] students, String group)
    {
        System.out.printf("students in group %s:\n", group);

        for (Student s: students)
        {
            if(s.getGroup().equals(group))
            {
                s.printStudent();
            }
        }
    }

    public static void main(String[] args)
    {
        Student[] students = {
            new Student(5734, "Skrynyk", "Vlad", 2004, "Kyiv", "0978463482", "MM", 3, "km1"),
            new Student(8620, "Reshetnyk", "Vitalii", 2003, "Kyiv", "0973457234", "MM", 3, "km1"),
            new Student(3042, "Chaichenko", "Oleg", 2004, "Kyiv", "0676742384", "FF", 3, "km"),
            new Student(2048, "Mikyshova", "Sasha", 2004, "Kyiv", "0635642396", "MM", 3, "km2"),
            new Student(2573, "Mandrenko", "Sasha", 2004, "Kyiv", "0659235428", "MM", 3, "km1")};


        serchByFaculty(students, "MM");
        System.out.println("\n");

        serchByYear(students, 2004);
        System.out.println("\n");

        serchByGroup(students, "km1");
    }
}
