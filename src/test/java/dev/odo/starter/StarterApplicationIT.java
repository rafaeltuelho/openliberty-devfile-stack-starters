package dev.odo.starter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.microshed.testing.SharedContainerConfig;
import org.microshed.testing.jaxrs.RESTClient;
import org.microshed.testing.jupiter.MicroShedTest;

@MicroShedTest
@SharedContainerConfig(AppDeploymentConfig.class)
public class StarterApplicationIT {

    @RESTClient()
    public static GreetingsResource greetingsResource;
    
    @Test
    public void testGreetings() {
        String greet = greetingsResource.hello("Rafael");
        assertNotNull(greet);
        assertTrue("Wrong response", "Rafael".equalsIgnoreCase(greet));
    }
}