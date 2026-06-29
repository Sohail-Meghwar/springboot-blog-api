package blogapp.com.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
    info = @Info(
        title = "Blog Application API",
        description = "API documentation for the Blog Application",
        version = "4.0",
        contact = @Contact(
            name = "Sohail",
            url = "https://github.com/Sohail-Meghwar/springboot-blog-api",
            email = "sohailkarmani16@gmail.com"
        ),
        license = @License(name = "License", url = "License URL"),
        termsOfService = "Terms of service URL"
    )
)
@SecurityScheme(
    name = "JWT",
    scheme = "bearer",
    bearerFormat = "JWT",
    type = SecuritySchemeType.HTTP
)
public class OpenApiConfig {
}