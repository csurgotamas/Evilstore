using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using Newtonsoft.Json;


namespace Appstore.ApplicationValidation.Services 
{
	
	public class ValidationService : IValidationService
	{
		public String validateApplication(String programDataInput)
		{
			//Objektumok parse-olása a bemenetbõl.
			String programData;
			try 
			{
				programData = JsonConvert.DeserializeObject<String>(programDataInput);
			}
			catch (JsonReaderException)
			{
				return "Hiba történt a JSON parseolásakor";
			}
			
			Boolean result;
			try
			{
				result = ValidationHelper.validateApplication(programData);
			}
			catch (Exception e)
			{
				return e.ToString();
			}
			
			try
			{
				return JsonConvert.SerializeObject(result);
			}
			catch (JsonReaderException)
			{
				return "Hiba történt a JSON parseolásakor";
			}
		}
	}
}

