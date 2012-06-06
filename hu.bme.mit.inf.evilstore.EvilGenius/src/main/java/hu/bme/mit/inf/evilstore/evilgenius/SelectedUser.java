package hu.bme.mit.inf.evilstore.evilgenius;

import hu.bme.mit.evilsystem.entities.Application;
import hu.bme.mit.evilsystem.entities.User;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class SelectedUser {
	
	private User user;
	private Map<Long, Double> score;
	
	//súlyozó konstansok
	private double popularWeight;
	private double developerWeight;
	private double categoryWeight;

	public double getPopularWeight() {
		return popularWeight;
	}

	public void setPopularWeight(double popularWeight) {
		this.popularWeight = popularWeight;
	}

	public double getDeveloperWeight() {
		return developerWeight;
	}

	public void setDeveloperWeight(double developerWeight) {
		this.developerWeight = developerWeight;
	}

	public double getCategoryWeight() {
		return categoryWeight;
	}

	public void setCategoryWeight(double categoryWeight) {
		this.categoryWeight = categoryWeight;
	}

	public SelectedUser(User user) {
		super();
		this.user = user;
		score = new HashMap<Long, Double>();
		popularWeight = 1.0;
		developerWeight = 1.0;
		categoryWeight = 1.0;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Map<Long, Double> getScore() {
		return score;
	}
	
	public void addApplicationToScore(Application app) {
		score.put(app.getId(), 0.0);
	}
	
	public void removeApplication(Application app) {
		score.remove(app.getId());
	}
	
	public void incrementApplicationScore(Application app, double scorePoint) {
		Double currentScore = score.get(app.getId());
		score.put(app.getId(), currentScore.doubleValue() + scorePoint);
	}
	
	public int countSimilarApplicationType(Application ownedApplication, Application otherApplication) {
		int count = 0;
		List<String> ownedTypes = ownedApplication.getDescription().getApplicationType();
		List<String> otherTypes = otherApplication.getDescription().getApplicationType();
		
		for (String ownedType : ownedTypes) {
			for (String otherType : otherTypes) {
				if (ownedType.equals(otherType)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public boolean isGoodAge(Application app)
	{
		Integer age;// = (user.getBirth().longValue() - new Date().getTime()) / (1000*60*60*24*365);
		//return age >= app.getDescription().getAgeRestriction().intValue();
		Date birthdate=new Date(user.getBirth());
		Date now=new java.util.Date();
		age=now.getYear()-birthdate.getYear();
		if(now.getMonth()<birthdate.getMonth()){
			age--;
		}else if(now.getMonth()==birthdate.getMonth() && now.getDay()<birthdate.getDay()){
			age--;
		}
		return age >= app.getDescription().getAgeRestriction().intValue();
	}
}
