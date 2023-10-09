package net.oguz.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring boot Rest Api Documentation",
                description = "Spring boot Rest Api Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "oguzhan",
                        email = "oguzhanngoley@gmail.com",
                        url = "https://github.com/oguzhangoley"

                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "apacheUrl.com"
                )

        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot User Management Documentation",
                url = "someUrl.com"
        )
)
public class SpringbootRestfulWebservicesApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
    }

}
