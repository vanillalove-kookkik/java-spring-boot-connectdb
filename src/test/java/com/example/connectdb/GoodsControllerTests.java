package com.example.connectdb;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.connectdb.dto.GoodsDto;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GoodsControllerTests {

	@LocalServerPort
	int randomServerPort;
	String url = "http://localhost:";
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void getGoodsSuccess() throws URISyntaxException {

		final String baseUrl = url + randomServerPort + "/goods/" + "test_goodsId_20022025140722";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("goodsId"));
		Assert.assertEquals(true, result.getBody().contains("goodsName"));
		Assert.assertEquals(true, result.getBody().contains("goodsPrice"));
		Assert.assertEquals(true, result.getBody().contains("shopId"));
		Assert.assertEquals(true, result.getBody().contains("shopName"));

	}

	@Test
	public void insertGoodsSuccess() throws URISyntaxException {

		final String baseUrl = url + randomServerPort + "/goods/insert";
		URI uri = new URI(baseUrl);

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String formattedDate = myDateObj.format(myFormatObj);

		BigDecimal goodsPrice = new BigDecimal(100.00);

		GoodsDto insertGoodsDto = new GoodsDto();
		insertGoodsDto.setGoodsId("test_goodsId_" + formattedDate);
		insertGoodsDto.setGoodsName("test_goodsName_" + formattedDate);
		insertGoodsDto.setGoodsPrice(goodsPrice);
		insertGoodsDto.setShopId("fb168ff8-c0a3-401f-be6d-ba0b20931e3d");

		ResponseEntity<String> result = restTemplate.postForEntity(uri, insertGoodsDto, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("goodsId"));
		Assert.assertEquals(true, result.getBody().contains("goodsName"));
		Assert.assertEquals(true, result.getBody().contains("goodsPrice"));
		Assert.assertEquals(true, result.getBody().contains("shopId"));
		Assert.assertEquals(true, result.getBody().contains("shopName"));

	}

	@Test
	public void getGoodsByShopIdSuccess() throws URISyntaxException {

		final String baseUrl = url + randomServerPort + "/goods?shopId=" + "24bd2247-d212-40b5-96ec-14dcb5e52453";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("goodsId"));
		Assert.assertEquals(true, result.getBody().contains("goodsName"));
		Assert.assertEquals(true, result.getBody().contains("goodsPrice"));
		Assert.assertEquals(true, result.getBody().contains("shopId"));
		Assert.assertEquals(true, result.getBody().contains("shopName"));

	}

}
