package hooks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Props {
	private Properties property = new Properties();
	private final String propertyFilePath = "configs/configuration.properties";
	
	public Props() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
			try {
				property.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
		}	
	}
	
	public String fetchEndpoint(String endpoint) {
		String returnEndPoint = "";
			switch(endpoint)
			{
				case "index":
					returnEndPoint = property.getProperty("rippleIndexEndPoint");
					break;
				case "ScopeSession":
					returnEndPoint = property.getProperty("rippleScopeSessionEndpoint");
					break;
				case "ScopeApplication":
					returnEndPoint = property.getProperty("rippleScopeApplicationEndpoint");
					break;
				case "logout":
					returnEndPoint = property.getProperty("rippleLogoutEndpoint");
					break;
				case "CreateUser":
					returnEndPoint = property.getProperty("rippleCreateUserEndpoint");
					break;
				case "GetUser":
					returnEndPoint = property.getProperty("rippleGetUserEndpoint");
					break;
				default:
					returnEndPoint=null;
					
			}
		return returnEndPoint;
	}
	
	public String fetchBaseURI() {
		return property.getProperty("baseUri");
	}

	public String fetchcreateuserjsonpath() {
		return property.getProperty("creatUserJson");
	}
	

}
