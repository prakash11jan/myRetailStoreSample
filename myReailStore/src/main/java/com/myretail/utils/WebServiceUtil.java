package com.myretail.utils;

import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;


public class WebServiceUtil {
	// Logger logger = LoggerFactory.getLogger(WebServiceUtil.class);
	private static RestTemplate restTemplate = new RestTemplate();

	public static String getNameFromResponse(String response) {
		String name = "";
		if (!StringUtils.isEmpty(response)) {
			JSONObject jsonObject = new JSONObject(response);
			try {
				name = jsonObject.getJSONObject("product").getJSONObject("item").getJSONObject("product_description")
						.getString("title");
			} catch (JSONException e) {//proper exception to be caught here as per the service provider
				System.out.println("json parser exception");
			}
		}
		return name;
	}

	public static String invokeRest(String url) {
		String response = "";
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);

			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			if (result.getStatusCode().equals(HttpStatus.OK)) {
				response = result.getBody();
			}
		} catch (Exception exe) {
			exe.printStackTrace();
			System.out.println("target service failed");
		}
		
		return response;

	}

}
