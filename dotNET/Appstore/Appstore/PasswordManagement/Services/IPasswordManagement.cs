using System;
using System.ServiceModel;
using System.ServiceModel.Web;


namespace Appstore.PasswordManagement.Services 
{
	
	[ServiceContract]
	public interface IPasswordManagementService
	{
		[OperationContract(Name = "generatePasswordHash")]
		[WebGet(UriTemplate = "/generatePasswordHash/{password}", ResponseFormat = WebMessageFormat.Json)]
		String generatePasswordHash(String password);
		[OperationContract(Name = "checkPassword")]
		[WebGet(UriTemplate = "/checkPassword/{password}/{passwordHash}", ResponseFormat = WebMessageFormat.Json)]
		String checkPassword(String password, String passwordHash);
	}
}

