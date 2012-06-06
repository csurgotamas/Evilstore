package hu.bme.mit.inf.evilstore.UploadApplication.interfaces;

public interface IUploadApplicationService {
	public String upload(String appName, String developerId, String version, String desc, String cost, String progfile, String appType, String ageRestriction);
	public String setValidated(String ApplicationID, String isValid);
}
