using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using Newtonsoft.Json;


namespace Appstore.PasswordManagement.Services 
{
	
	public class PasswordManagementHelper
	{
		public static Int32 generatePasswordHash(String password)
		{
			Int32 ret;
			
            /* Implement function */
            ret = password.GetHashCode();
            /* */

            return ret;
		}
		public static Boolean checkPassword(String password, Int32 passwordHash)
		{
			Boolean ret;
			
			/* Implement function */
            ret = (passwordHash == password.GetHashCode());
			/* */
			
			return ret;
		}
	}
}

