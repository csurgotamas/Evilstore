using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using Newtonsoft.Json;


namespace Appstore.ApplicationValidation.Services 
{
	
	public class ValidationHelper
	{
		public static Boolean validateApplication(String programData)
		{
			Boolean ret;
			/* Implement function */
            ret = programData.Contains("evil");
			/* */
			
			return ret;
		}
	}
}

