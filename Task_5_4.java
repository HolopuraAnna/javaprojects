package Topic_4.hw_9;

/**
 * Task_5_4
 * @author Holopura Anna
 */

import java.util.ArrayList;
import java.util.List;

 class Country
 {
    private String country;
    private City capital;
    private int square;
    private List<Region> regions;

    public Country(String country, City capital, int square, List<Region> regions)
    {
        this.country = country;
        this.capital = capital;
        this.square = square;
        this.regions = regions;
    }

    public Country(String string, City kyiv, Region[] regions2) {
    }

    public int countRegionalCenters()
    {
        return regions.size();
    }

    public void printCountry()
    {
        System.out.println("Country: " + country);
        System.out.println("Capital: " + capital.getCity());
        System.out.println("Square: " + square + " km^2");
        System.out.println("Number of regions: " + countRegionalCenters());
        System.out.print("Regional centers: ");
        for (Region region : regions)
        {
            System.out.print(region.getRegionalCenter().getCity() + ", ");
        }
    }
 }

 class Region
 {
    private String region;
    private City regionalCenter;

    public Region(City regionalCenter) { this.regionalCenter = regionalCenter; }

    public void setRegion(String region) { this.region = region; }

    public String getRegion() {return region; }

    public City getRegionalCenter() { return regionalCenter; }
 }

 class District
 {
    private String district;
    private City districtCenter;

    public District(String district, City districtCenter)
    {
        this.district = district;
        this.districtCenter = districtCenter;
    }

    public String getDistrict() {return district; }

    public City getDistrictCenter() { return districtCenter; }
 }

 class City
 {
    private String city;

    public City(String city) { this.city = city; }

    public String getCity() { return city; }
 }

public class Task_5_4
{
    public static void main(String[] args)
    {
        City Kyiv = new City("Kyiv");

        List<Region> Regions = new ArrayList<>();
        Regions.add(new Region(Kyiv));
        Regions.add(new Region(new City("Volyn")));
        Regions.add(new Region(new City("Donetsk")));
        Regions.add(new Region(new City("Kirovohrad")));
        Regions.add(new Region(new City("Lviv")));
        Regions.add(new Region(new City("Mykolaiv")));

        Country Ukraine = new Country("Ukraine", Kyiv, 603628, Regions);
        Ukraine.printCountry();
    }
}
