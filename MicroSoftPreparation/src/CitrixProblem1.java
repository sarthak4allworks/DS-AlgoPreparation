import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class ParkingLot
{
	int totalNumberOfVehicleCurrentlyInParkingLot = 0;
	Map<Vehicle, Integer> mainTaingTheVehicle = null;  //key is vehicle and value is floow number slot type we can identified by vehicle height
	Map<Integer, Map<Integer, Integer>> floorWiseCapacity = null;  // key is floor number and value map of slot type of the floor and value is capacity of that type of slot
	public void setFloorWiseCapacity(Map<Integer, Map<Integer, Integer>> floorWiseCapacity)
	{
		this.floorWiseCapacity = floorWiseCapacity;
	}
	
	public int getCapacitySlotWiseInTheFloor(int floorNumber, int slotType)
	{
		if(floorWiseCapacity == null)
		{
			return 0;
		}
		else
		{
			Map<Integer, Integer> map = floorWiseCapacity.get(floorNumber);
			if(map == null)
			{
				return 0;
			}
			else
			{
				if(map.containsKey(slotType))
				{
					return map.get(slotType);
				}
				else
				{
					return 0;
				}
			}
		}
	}
	
	public int getFloorWiseTotalCapacity(int floorNumber)
	{
		if(floorWiseCapacity == null)
		{
			return 0;
		}
		else
		{
			int totalFloorCapacity = 0;
			Map<Integer, Integer> map = floorWiseCapacity.get(floorNumber);
			for(Map.Entry<Integer, Integer> ent: map.entrySet())
			{
				totalFloorCapacity += ent.getValue();
			}
			return totalFloorCapacity;
		}
	}
	
	public int getTotalCapacityOfParkingLot() 
	{
		if(floorWiseCapacity == null)
		{
			return 0;
		}
		else
		{
			int totalCapacity = 0;
			for (Map.Entry<Integer,Map<Integer, Integer>> entry : floorWiseCapacity.entrySet())
			{
				Map<Integer, Integer> map = entry.getValue();
				for(Map.Entry<Integer, Integer> ent: map.entrySet())
				{
					totalCapacity += ent.getValue();
				}
			}
			return totalCapacity;
		}
	}
	
	public boolean IsVehicleAllowed(Vehicle v)
	{
//		int height = v.getHeight();
//		
		return true;
	}
}

class Vehicle
{
	int vehicleHeight; // criteria for taking the parking slot
	public int getHeight()
	{
		return vehicleHeight; // vehicle height<10 slot0 height>=10 && <20 then slot1 else slot2
	}
	public void setHeight(int height)
	{
		vehicleHeight = height;
	}
}

public class CitrixProblem1 
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the no of floors in the parking slot: ");
		int floors = s.nextInt();
		Map<Integer, Map<Integer, Integer>> parkingLot = new LinkedHashMap<>();
		for(int i=0 ; i<floors ; i++)
		{
			System.out.print("Enter the number of slot type in floor "+i);
			int slotTypes = s.nextInt();
			Map<Integer, Integer> slotsWithCapacity = new LinkedHashMap<>();
			for(int j=0 ; j<slotTypes ; j++)
			{
				System.out.print("Enter the capacity of this slotType: ");
				int capacity = s.nextInt();
				if(slotsWithCapacity.containsKey(j))
				{
					int cap = slotsWithCapacity.get(j);
					slotsWithCapacity.put(j, capacity+cap);
				}
				else
				{
					slotsWithCapacity.put(j, capacity);
				}
			}
			parkingLot.put(i, slotsWithCapacity);
		}
		ParkingLot pl = new ParkingLot();
		pl.setFloorWiseCapacity(parkingLot);
		s.close();
	}
}
