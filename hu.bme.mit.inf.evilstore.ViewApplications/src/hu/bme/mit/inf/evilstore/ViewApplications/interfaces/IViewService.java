package hu.bme.mit.inf.evilstore.ViewApplications.interfaces;

public interface IViewService {
	public String viewUncheckedApplication();
	public String viewValidatedApplication();
	public String viewBuyedApplication(String userID);
	public String viewApplicationDetails(String applicationID);
}
