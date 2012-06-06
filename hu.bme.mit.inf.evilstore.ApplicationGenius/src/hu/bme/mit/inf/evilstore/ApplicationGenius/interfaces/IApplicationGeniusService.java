package hu.bme.mit.inf.evilstore.ApplicationGenius.interfaces;

public interface IApplicationGeniusService {
	public String getUsers();
	public String getSelectedUser(String userID);
	public String classifyType(String age);
	public String GetSimilarities();
}
