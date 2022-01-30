package org.misterstorm.resource;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
class BitcoinResourceTest {

	@Test
	void deve_retornar_status_code_200_quando_requisicao_for_correta_e_objeto_encontrado() {
		
		RestAssured.given().get("bitcoins").then().statusCode(200);
	}

}
