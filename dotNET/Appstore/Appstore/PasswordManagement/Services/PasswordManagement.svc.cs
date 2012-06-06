using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using Newtonsoft.Json;


namespace Appstore.PasswordManagement.Services 
{
	
	public class PasswordManagementService : IPasswordManagementService
	{
		public String generatePasswordHash(String passwordInput)
		{
			//Objektumok parse-ol�sa a bemenetb�l.
			String password;
			try 
			{
				password = JsonConvert.DeserializeObject<String>(passwordInput);
			}
			catch (JsonReaderException)
			{
				return "Hiba t�rt�nt a JSON parseol�sakor";
			}
			
			Int32 result;
			try
			{
				result = PasswordManagementHelper.generatePasswordHash(password);
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
		public String checkPassword(String passwordInput, String passwordHashInput)
		{
			//Objektumok parse-ol�sa a bemenetb�l.
			String password;
			Int32 passwordHash;
			try 
			{
				password = JsonConvert.DeserializeObject<String>(passwordInput);
				passwordHash = JsonConvert.DeserializeObject<Int32>(passwordHashInput);
			}
			catch (JsonReaderException)
			{
				return "Hiba t�rt�nt a JSON parseol�sakor";
			}
			
			Boolean result;
			try
			{
				result = PasswordManagementHelper.checkPassword(password, passwordHash);
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

