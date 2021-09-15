package org.thuis99.instancetest.validators;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.arc.DefaultBean;

@DefaultBean
@ApplicationScoped
public class TypeBValidator implements Validator {
    private static final Logger LOG = LoggerFactory.getLogger(TypeBValidator.class);

    @Override
    public String validate() {
        LOG.info("Validation: {}", TypeBValidator.class.getName());
        return TypeBValidator.class.getName();
    }
}
