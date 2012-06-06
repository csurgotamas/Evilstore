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
			//Objektumok parse-olása a bemenetbõl.
			String password;
			try 
			{
				password = JsonConvert.DeserializeObject<String>(passwordInput);
			}
			catch (JsonReaderException)
			{
				return "Hiba történt a JSON parseolásakor";
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
				return "Hiba történt a JSON parseolásakor";
			}
		}
		public String checkPassword(String passwordInput, String passwordHashInput)
		{
			//Objektumok parse-olása a bemenetbõl.
			String password;
			Int32 passwordHash;
			try 
			{
				password = JsonConvert.DeserializeObject<String>(passwordInput);
				passwordHash = JsonConvert.DeserializeObject<Int32>(passwordHashInput);
			}
			catch (JsonReaderException)
			{
				return "Hiba történt a JSON parseolásakor";
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
				return "Hiba történt a JSON parseolásakor";
			}
		}
	}
}

