package Topic_4.hw_9;

/**
 * Task_6_3
 * @author Holopura Anna
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Override;

class ElectricalAppliance
{
    int power;
    boolean on;
    String name;

    public ElectricalAppliance(String name, int power, boolean on)
    {
        this.name = name;
        this.power = power;
        this.on = on;
    }

    public void turnOn() { on = true; }

    public void turnOff() { on = false; }

    public int getPower() { return power; }

    public boolean getOn() { return on; }

    public void setOn(boolean on) { this.on = on; }

    @Override
    public String toString()
    {
        if (on)
        {
            return name + " (power: " + power + " W , turned on)";
        }
        else { return name + " (power: " + power + " W , turned off)"; }
    }
}

class Kettle extends ElectricalAppliance
{
    private int hierarchy;

    public Kettle(int hierarchy, int power, boolean on)
    {
        super("Kettle", power, on);
        this.hierarchy = hierarchy;
    }

    public int getHierarchy() { return hierarchy; }

    @Override
    public String toString() { return super.toString(); }
}

class Heater extends ElectricalAppliance
{
    private int hierarchy;

    public Heater(int hierarchy, int power, boolean on)
    {
        super("Heater", power, on);
        this.hierarchy = hierarchy;
    }

    public int getHierarchy() { return hierarchy; }

    @Override
    public String toString() { return super.toString(); }
}

class Lamp extends ElectricalAppliance
{
    private int hierarchy;

    public Lamp(int hierarchy, int power, boolean on)
    {
        super("Lamp", power, on);
        this.hierarchy = hierarchy;
    }

    public int getHierarchy() { return hierarchy; }

    @Override
    public String toString() { return super.toString(); }
}

class ElectricalAppliances
{
    private List<ElectricalAppliance> el = new ArrayList<>();

    public void addFlower(ElectricalAppliance appliance) { el.add(appliance); }

    public int countPower()
    {
        int totalPower = 0;
        for (ElectricalAppliance appliance : el)
        {
            if (appliance.getOn()) { totalPower += appliance.getPower(); }
        }
        return totalPower;
    }

    public void sortByPower()
    {
        Collections.sort(el, (el1, el2) -> Integer.compare(el2.getPower(), el1.getPower()));
    }

    public ElectricalAppliance findApplianceByPower(int minPow, int maxPow)
    {
        for (ElectricalAppliance appliance : el)
        {
            if (appliance.getPower() >= minPow && appliance.getPower() <= maxPow)
            {
                return appliance;
            }
        }
        return null;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder("ElectricalAppliances: ");
        for (ElectricalAppliance appliance : el)
        {
            result.append(appliance).append(", ");
        }

        result.delete(result.length() - 2, result.length());
        return result.toString();
    }
}

public class Task_6_3
{
    public static void main(String[] args)
    {
        Kettle kettle = new Kettle(2, 1500, false);
        Heater heater = new Heater(3, 2200, false);
        Lamp lamp = new Lamp(1, 10, false);

        heater.turnOn();
        lamp.turnOn();

        ElectricalAppliances electricalAppliances = new ElectricalAppliances();
        electricalAppliances.addFlower(kettle);
        electricalAppliances.addFlower(heater);
        electricalAppliances.addFlower(lamp);

        System.out.println("Turned on appliances consume " + electricalAppliances.countPower() + " W");

        electricalAppliances.sortByPower();
        System.out.println("Electrical appliances sorted by power: " + electricalAppliances);

        ElectricalAppliance appliance = electricalAppliances.findApplianceByPower(1000, 1800);
        if (appliance != null)
        {
            System.out.println("Appliance in the specified power range: " + appliance);
        }
        else { System.out.println("No appliance found in the specified power range."); }
    }
}
