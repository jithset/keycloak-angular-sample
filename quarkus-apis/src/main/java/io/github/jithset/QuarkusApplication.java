package io.github.jithset;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title="Keycloak Sample Apis",
                version = "1.0.1",
                contact = @Contact(
                        name = "jithset",
                        url = "jithset.github.io",
                        email = "jithset@gmail.com")
        )
)
public class QuarkusApplication extends Application {
}
