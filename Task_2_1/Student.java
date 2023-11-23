package Topic_4.Task_2_1;

public class Student
{
    private Integer id;
    private String surname;
    private String name;
    private Integer birthYear;
    private String address;
    private String phone;
    private String faculty;
    private Integer course;
    private String group;

    public void setId(Integer id)  { this.id =  id; }
    public Integer getId()  { return id; }

    public void setSurname(String surname)  { this.surname =  surname; }
    public String getSurname()  { return surname; }
    
    public void setName(String name)  { this.name =  name; }
    public String getName()  { return name; }
    
    public void setBirthYear(Integer birthYear)  { this.birthYear =  birthYear; }
    public Integer getBirthYear()  { return birthYear; }
    
    public void setAddress(String address)  { this.address =  address; }
    public String getAddress()  { return address; }
    
    public void setPhone(String phone)  { this.phone =  phone; }
    public String getPhone()  { return phone; }
    
    public void setFaculty(String faculty)  { this.faculty =  faculty; }
    public String getFaculty()  { return faculty; }

    public void setCourse(Integer course)  { this.course =  course; }
    public Integer getCourse()  { return course; }

    public void setGroup(String group)  { this.group =  group; }
    public String getGroup()  { return group; }

    public Student(Integer id, String surname, String name, Integer birthYear, 
                   String address, String phone, String faculty, Integer course, String group)
    {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.birthYear = birthYear;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public void printStudent()
    {
        System.out.println("Student: " + name + " " + surname + ", id: " + id + 
                            ", year: " + birthYear + ", faculty: " + faculty + ", course: " + course + 
                            ", group: " + group + ", phone: " + phone + ", address: " + address);
    }
}
