package org.thuis99.instancetest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thuis99.instancetest.validators.TypeBMockValidator;
import org.thuis99.instancetest.validators.TypeBValidator;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class GreetingResourceTest {
    private static final Logger LOG = LoggerFactory.getLogger(GreetingResourceTest.class);

    @Test
    void testHelloEndpoint() {
        LOG.info("With mocks");

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
        LOG.info("Without mocks");

        given() //
                .when() //
                .get("/hello") //
                .then() //
                .statusCode(200) //
                .body(is("Hello RESTEasy"));
    }
}