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
			//Objektumok parse-ol�sa a bemenetb�l.
			String programData;
			try 
			{
				programData = JsonConvert.DeserializeObject<String>(programDataInput);
			}
			catch (JsonReaderException)
			{
				return "Hiba t�rt�nt a JSON parseol�sakor";
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
				return "Hiba t�rt�nt a JSON parseol�sakor";
			}
		}
	}
}

