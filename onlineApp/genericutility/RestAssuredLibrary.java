package com.rmgyantra.genericutility;

import io.restassured.RestAssured.*;
import io.restassured.response.Response;

/**
 * Consist of methods of Rest Assured tool
 * @author Nikhita Biradar
 *
 */

public class RestAssuredLibrary {
	/**
	 * This method will return json data from the corresponding response body
	 * @author Nikhita Biradar
	 * 2param response
	 * @param path
	 * @return
	 */
	
	public String getJsonData(Response response, String path)
	{
		String jsonData = response.jsonPath().get(path);
		return jsonData;
	}

}
