package hu.bme.mit.inf.evilstore.ApplicationBuy.interfaces;

public interface IBuyApplicationService {
	public String buy(String userID, String applicationID);
	public String download(String applicationID);
}
