package hu.bme.mit.inf.evilstore.AccountManagement.interfaces;

public interface IAccountManagementService {
	public String transferMoney(String accountId, String ammount);
	public String withdrawMoney(String accountId, String ammount);
	public String getAccountOfUser(String userID);
}
