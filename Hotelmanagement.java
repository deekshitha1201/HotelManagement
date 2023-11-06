package hotel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class WithACRooms {
	private int roomNo;
	private double cost;
	private int sharing;

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getSharing() {
		return sharing;
	}

	public void setSharing(int sharing) {
		this.sharing = sharing;
	}

	public WithACRooms(int roomNo, double cost, int sharing) {
		super();
		this.roomNo = roomNo;
		this.cost = cost;
		this.sharing = sharing;
	}

	@Override
	public String toString() {
		return "Room No " + roomNo + " Cost is = " + cost + ", Sharing = " + sharing;
	}

}

class WithoutACRooms {

	private int roomNo;
	private double cost;
	private int sharing;

	public WithoutACRooms(int roomNo, double cost, int sharing) {
		super();
		this.roomNo = roomNo;
		this.cost = cost;
		this.sharing = sharing;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getSharing() {
		return sharing;
	}

	public void setSharing(int sharing) {
		this.sharing = sharing;
	}

	@Override
	public String toString() {
		return "RoomNo= " + roomNo + ", Cost= " + cost + ", Sharing= " + sharing;
	}

}

class Food1 {
	private int id;
	private String name;
	private int cost;
	private int quantity;

	public Food1(int id, String name, int cost, int quantity) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return name + " Cost: " + cost + " Quantity: " + quantity;
	}

}

interface HotelManagementSystem {
	void addWithoutACRooms();

	void addWithACRooms();

	void displayWithoutACRooms();

	void displayWithACRooms();

	void bookingWithoutACRooms();

	void bookingWithACRooms();

	void addFood();

	void displayFood();

	void orderFood();

	void checkOut();

}

class HotelManagementSystemImpl implements HotelManagementSystem {

	Scanner sc = new Scanner(System.in);
	Map<Integer, WithoutACRooms> db1 = new LinkedHashMap<Integer, WithoutACRooms>();
	Map<Integer, WithACRooms> db2 = new LinkedHashMap<Integer, WithACRooms>();
	Map<Integer, Food1> db = new LinkedHashMap<Integer, Food1>();

	double totalCost = 0;
	WithoutACRooms noac1 = new WithoutACRooms(101, 1200, 2);
	WithoutACRooms noac2 = new WithoutACRooms(102, 300, 5);
	WithoutACRooms noac3 = new WithoutACRooms(103, 800, 4);
	WithoutACRooms noac4 = new WithoutACRooms(104, 1000, 3);

	@Override
	public void addWithoutACRooms() {

		db1.put(noac1.getRoomNo(), noac1);
		db1.put(noac2.getRoomNo(), noac2);
		db1.put(noac3.getRoomNo(), noac3);
		db1.put(noac4.getRoomNo(), noac4);
	}

	WithACRooms ac1 = new WithACRooms(201, 1800, 2);
	WithACRooms ac2 = new WithACRooms(202, 1500, 3);
	WithACRooms ac3 = new WithACRooms(203, 1200, 4);

	@Override
	public void addWithACRooms() {
		db2.put(ac1.getRoomNo(), ac1);
		db2.put(ac2.getRoomNo(), ac2);
		db2.put(ac3.getRoomNo(), ac3);

	}

	@Override
	public void displayWithoutACRooms() {
		Set<Integer> keys = db1.keySet();
		for (int key : keys) {
			System.out.println("Enter " + key + " ---> " + db1.get(key));
		}

	}

	@Override
	public void displayWithACRooms() {
		Set<Integer> keys = db2.keySet();
		for (int key : keys) {
			System.out.println("Enter " + key + " ---> " + db2.get(key));
		}
	}

	@Override
	public void bookingWithoutACRooms() {
		System.out.println("select Without AC Rooms By using Room number");
		int id = sc.nextInt();
		WithoutACRooms room = db1.get(id);
		if (id == room.getRoomNo()) {
			System.out.println("Without Ac Room Number " + room.getRoomNo() + " Booked  and Cost is " + room.getCost());
			totalCost += room.getCost();
		} else {
			System.out.println("Invalid Room number ");
		}

	}

	@Override
	public void bookingWithACRooms() {
		System.out.println("Select AC room By using Room number ");

		int id = sc.nextInt();
		WithACRooms ac = db2.get(id);
		if (id == ac.getRoomNo()) {
			System.out.println("Ac Room Number " + ac.getRoomNo() + " is Booked and Cost is " + ac.getCost());
			totalCost += ac.getCost();
		} else {
			System.out.println("Invalid Room Number");
		}

	}

	@Override
	public void checkOut() {
		if (totalCost != 0) {
			System.out.println("Total Cost Rs. " + totalCost);
			System.out.println("Thank you!!...");
		}

	}

	@Override
	public void addFood() {
		db.put(1, new Food1(1, "chicken biriyani  ", 250, 5));
		db.put(2, new Food1(2, "Mushroom biriyani ", 120, 7));
		db.put(3, new Food1(3, "Fish biriyani     ", 220, 2));
		db.put(4, new Food1(4, "Mutton biriyani   ", 350, 8));
		db.put(5, new Food1(5, "Paneer biriyani   ", 290, 4));

		System.out.println("Food Menu Created");

	}

	@Override
	public void displayFood() {
		Set<Integer> keys = db.keySet(); // 1 2 3 4 5
		for (int key : keys) {
			System.out.println("Enter " + key + " --> " + db.get(key));
		}

	}

	@Override
	public void orderFood() {
		System.out.println("Select Food");
		int id = sc.nextInt();
		Food1 food = db.get(id);

		System.out.println("Ordering " + food.getName());
		System.out.println("--------------------------");

		System.out.println("Enter Quantity");
		int quantity = sc.nextInt();

		if (quantity <= food.getQuantity()) {
			food.setQuantity(food.getQuantity() - quantity);
			int currentCost = food.getCost() * quantity;
			totalCost = totalCost + currentCost;

			System.out.println("Ordered " + quantity + " " + food.getName() + " at the cost of Rs." + currentCost);

		} else {
			System.out.println("Invalid Quantity Entered!!");

		}

	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HotelManagementSystem h = new HotelManagementSystemImpl();
		System.out.println("Hotel Management System ");
		System.out.println("=========================================");

		while (true) {
			System.out.println("1.Booking Rooms\n2.Food Menu ");
			System.out.println("3.Check Out\n4.Exit");
			System.out.println("Enter the Choice ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				h.addWithACRooms();
				h.addWithoutACRooms();
				System.out.println("With Ac Rooms\n---------------");
				h.displayWithACRooms();
				System.out.println("------------------------");
				System.out.println("Without Ac Rooms\n----------------");
				h.displayWithoutACRooms();
				System.out.println("---------------------------");
				System.out.println("Select Categorys\n--------------\n1.Ac Rooms \n2.Without Ac Rooms");
				int c = sc.nextInt();
				switch (c) {
				case 1:
					h.bookingWithACRooms();
					break;
				case 2:
					h.bookingWithoutACRooms();
					break;
				default:
					System.out.println("Invalid Choice ");
				}
				break;

			case 2:
				h.addFood();
				System.out.println("-------------");

				h.displayFood();
				h.orderFood();
				break;

			case 3:
				h.checkOut();
				break;

			case 4:
				System.out.println("Thank you");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice!!");

			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}
}