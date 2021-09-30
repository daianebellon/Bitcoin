package br.com.daianebellon.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class BitcoinWSTest {

    @Test
    void testarSeStatusCodeDaRequisicaoEh200() {
        RestAssured
                .given().get("bitcoins").then().statusCode(200);
    }
}