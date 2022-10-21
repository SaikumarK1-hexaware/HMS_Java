package com.JavaSpring.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "JavaSpring Resources",
                version = "V12.0.12",
                title = "JavaSpring Resource API",
                contact = @Contact(
                   name = "JavaSpring Team", 
                   email = "JavaSpring@hexaware.com", 
                   url = "http://www.hexaware.com"
                ),
                license = @License(
                   name = "JavaSpring 2.0",  
                   url = "http://www.hexaware.com/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "http://www.JavaSpring.org")
)
public interface ApiDocumentationConfig {

}