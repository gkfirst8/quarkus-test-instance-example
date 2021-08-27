package org.thuis99.instancetest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;
import org.thuis99.instancetest.validators.TypeBMockValidator;
import org.thuis99.instancetest.validators.TypeBValidator;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        TypeBMockValidator myTypeBMock = new TypeBMockValidator();
        QuarkusMock.installMockForType(myTypeBMock, TypeBValidator.class);

        given() //
                .when() //
                .get("/hello") //
                .then() //
                .statusCode(200) //
                .body(is("Hello RESTEasy"));
    }

    @Test
    void testHelloEndpoint_NoMocks() {
        given() //
                .when() //
                .get("/hello") //
                .then() //
                .statusCode(200) //
                .body(is("Hello RESTEasy"));
    }
}