package org.thuis99.instancetest.validators;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Uncomment these to see the 'Old approach' (See https://quarkus.io/blog/mocking/)
// import io.quarkus.test.Mock;
// @Mock
@ApplicationScoped
public class TypeBMockValidator extends TypeBValidator {
    private static final Logger LOG = LoggerFactory.getLogger(TypeBMockValidator.class);

    @Override
    public String validate() {
        LOG.info("Validation: {}", TypeBMockValidator.class.getName());
        return TypeBMockValidator.class.getName();
    }
}
