package Topic_4.Task_2_7;

public class Phone
{
    private Integer id;
    private String surname;
    private String name;
    private String address;
    private String card;
    private Integer shortDistanceCall;
    private Integer longDistanceCall;

    public Phone(Integer id, String surname, String name, String address,
                   String card, Integer shortDistanceCall, Integer longDistanceCall)
    {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.card = card;
        this.shortDistanceCall = shortDistanceCall;
        this.longDistanceCall = longDistanceCall;
    }

    public void setId(Integer id)  { this.id =  id; }
    public Integer getId()  { return id; }

    public void setSurname(String surname)  { this.surname =  surname; }
    public String getSurname()  { return surname; }
    
    public void setName(String name)  { this.name =  name; }
    public String getName()  { return name; }

    public void setAddress(String address)  { this.address =  address; }
    public String getAddress()  { return address; }
    
    public void setCard(String card)  { this.card =  card; }
    public String getCard()  { return card; }

    public void setShortDistanceCall(Integer shortDistanceCall)  { this.shortDistanceCall =  shortDistanceCall; }
    public Integer getShortDistanceCall()  { return shortDistanceCall; }

    public void setLongDistanceCall(Integer longDistanceCall)  { this.longDistanceCall =  longDistanceCall; }
    public Integer getLongDistanceCall()  { return longDistanceCall; }

    public void printPhone()
    {
        System.out.println("Name: " + name + " " + surname + ", id: " + id + 
                            ", time of short distance calls: " + shortDistanceCall + ", time of long distance calls: " + longDistanceCall +
                            ", card: " + card + ", address: " + address);
    }
}
