package com.example.connectdb;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.example.connectdb.dto.InsertAddressDto;
import com.example.connectdb.entity.Address;
import com.example.connectdb.entity.User;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AddressControllerTests {

	@LocalServerPort
	int randomServerPort;
	String url = "http://localhost:";
	RestTemplate restTemplate = new RestTemplate();


	@Test
	public void retrieveAddressSuccess() throws URISyntaxException {

		final String baseUrl = url + randomServerPort + "/address/USER_ID_1";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("userId"));
		Assert.assertEquals(true, result.getBody().contains("houseNo"));
		Assert.assertEquals(true, result.getBody().contains("subDistrict"));
		Assert.assertEquals(true, result.getBody().contains("district"));
		Assert.assertEquals(true, result.getBody().contains("city"));
		Assert.assertEquals(true, result.getBody().contains("postcode"));

	}

	@Test
	public void createAddressSuccess() throws URISyntaxException {

		final String baseUrl = url + randomServerPort + "/address/insert";
		URI uri = new URI(baseUrl);

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String formattedDate = myDateObj.format(myFormatObj);


		InsertAddressDto insertAddressDto = new InsertAddressDto();
		insertAddressDto.setUserId("test_userId_" + formattedDate);
		insertAddressDto.setHouseNo("test_HouseNo_" + formattedDate);
		insertAddressDto.setSubDistrict("test_SubDistrict_" + formattedDate);
		insertAddressDto.setDistrict("test_District_" + formattedDate);
		insertAddressDto.setCity("test_City_" + formattedDate);
		insertAddressDto.setPostcode("test_Postcod_" + formattedDate);

		ResponseEntity<String> result = restTemplate.postForEntity(uri, insertAddressDto, String.class);
		// Verify request succeed
		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("userId"));
		Assert.assertEquals(true, result.getBody().contains("username"));
		Assert.assertEquals(true, result.getBody().contains("houseNo"));
		Assert.assertEquals(true, result.getBody().contains("subDistrict"));
		Assert.assertEquals(true, result.getBody().contains("district"));
		Assert.assertEquals(true, result.getBody().contains("city"));
		Assert.assertEquals(true, result.getBody().contains("postcode"));

	}

}
