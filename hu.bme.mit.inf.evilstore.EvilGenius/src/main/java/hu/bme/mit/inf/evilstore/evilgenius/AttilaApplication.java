package hu.bme.mit.inf.evilstore.evilgenius;

public class AttilaApplication {

	private String name;
	private String developer;
	private String category;
	private int age;
	private int cost;
	private int downloadNumber;
	
	public AttilaApplication(String n, String dev, String cat, int a, int c) {
		name = n;
		developer = dev;
		category = cat;
		age = a;
		cost = c;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDeveloper() {
		return developer;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getDownloadNumber() {
		return downloadNumber;
	}
	
	public void downloads(int number) {
		downloadNumber += number;
	}
	
}
