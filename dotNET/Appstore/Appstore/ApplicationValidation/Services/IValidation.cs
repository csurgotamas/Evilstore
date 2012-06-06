using System;
using System.ServiceModel;
using System.ServiceModel.Web;


namespace Appstore.ApplicationValidation.Services 
{
	
	[ServiceContract]
	public interface IValidationService
	{
		[OperationContract(Name = "validateApplication")]
		[WebInvoke(UriTemplate = "/validateApplication/{programData}", Method = "POST", ResponseFormat = WebMessageFormat.Json)]
		String validateApplication(String programData);
	}
}

