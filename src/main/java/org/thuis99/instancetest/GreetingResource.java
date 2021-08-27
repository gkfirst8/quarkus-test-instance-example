package org.thuis99.instancetest;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thuis99.instancetest.validators.Validator;

@Path("/hello")
public class GreetingResource {
    private static final Logger LOG = LoggerFactory.getLogger(GreetingResource.class);

    @Inject
    public GreetingResource(Instance<Validator> validators) {
        LOG.info("GreetingResource created");
        for (Validator validator : validators) {
            LOG.info("Just called: {}.validate()", validator.validate());
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
}