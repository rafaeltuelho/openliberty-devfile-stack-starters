package dev.odo.starter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class StarterApplicationTest {
    WebTarget webTarget;

    Client client;
    Response response;
    final String BASE_URL = "http://localhost:9080/api";


    @BeforeEach
    public void setup() {
      this.client = ClientBuilder.newClient();
    }

    @Test
    public void helloTest() {
        webTarget = client.target(BASE_URL + "/hello/test");
        response = webTarget.request().get();
        String responseText = response.readEntity(String.class);
        System.out.println("Response code: " + response.getStatus());
        System.out.println("Response text: " + responseText);

        assertEquals(200, response.getStatus(), "No success!");
        assertEquals("Hello test", responseText, "Response doesn't match.");
    }

    @AfterEach
    public void teardown() {
        response.close();
        client.close();
    }
}
