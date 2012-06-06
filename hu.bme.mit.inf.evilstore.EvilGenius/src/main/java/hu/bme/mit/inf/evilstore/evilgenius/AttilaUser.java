package hu.bme.mit.inf.evilstore.evilgenius;

import java.util.ArrayList;

public class AttilaUser {

	private String id;
	private int age;
	private ArrayList<AttilaApplication> applications;
	
	public AttilaUser(String name, int a) {
		id = name;
		age = a;
		applications = new ArrayList<AttilaApplication>();
	}
	
	public String getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}
	
	public void addApplication(AttilaApplication app) {
		applications.add(app);
	}
	
	public ArrayList<AttilaApplication> getApplications() {
		return applications;
	}
	
}
