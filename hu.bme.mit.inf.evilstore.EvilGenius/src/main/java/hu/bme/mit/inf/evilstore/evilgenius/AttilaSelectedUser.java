package hu.bme.mit.inf.evilstore.evilgenius;

import hu.bme.mit.evilsystem.entities.Application;
import hu.bme.mit.evilsystem.entities.User;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class AttilaSelectedUser {

	private AttilaUser user;
	private Map<AttilaApplication, Double> score;
	
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

	public AttilaSelectedUser(AttilaUser user) {
		super();
		this.user = user;
		score = new HashMap<AttilaApplication, Double>();
		popularWeight = 1.0;
		developerWeight = 1.0;
		categoryWeight = 1.0;
	}
	
	public AttilaUser getUser() {
		return user;
	}

	public void setUser(AttilaUser user) {
		this.user = user;
	}
	
	public Map<AttilaApplication, Double> getScore() {
		return score;
	}
	
	public void addApplicationToScore(AttilaApplication app) {
		score.put(app, 0.0);
	}
	
	public void removeApplication(Application app) {
		score.remove(app);
	}
	
	public void incrementApplicationScore(AttilaApplication app, double scorePoint) {
		Double currentScore = score.get(app);
		score.put(app, currentScore.doubleValue() + scorePoint);
	}
	
	public boolean isGoodAge(Application app)
	{
		return user.getAge() >= app.getDescription().getAgeRestriction().intValue();
	}
	
}
