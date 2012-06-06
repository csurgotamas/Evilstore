package hu.bme.mit.inf.evilstore.UserManagement.interfaces;

public interface IRegistrationService {
	public String registerNewUser(String userName, String accountId, String passwordHash, String birth);
	public String deleteProfile(String userID);
	public String login(String userName);
	public String IsMatchingPasswordHash(String userID, String passwordHash);
	public String userage(String userID);
}
