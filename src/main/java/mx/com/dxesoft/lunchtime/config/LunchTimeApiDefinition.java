package mx.com.dxesoft.lunchtime.config;

import io.swagger.annotations.*;

@SwaggerDefinition(
        info = @Info(
                description = "Manages the weekly family lunch menu",
                version = "V1.0.0",
                title = "Lunch Time API",
                termsOfService = "http://lunchtime.com/terms.html",
                contact = @Contact(
                        name = "DxeSoft",
                        email = "dxesoft@gmail.com",
                        url = "http://lunchtime.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        tags = {
                @Tag(name = "Comidas", description = "Family lunch Menu")
        }
        //,externalDocs = @ExternalDocs(value = "Meteorology", url = "http://theweatherapi.io/meteorology.html")
)
public interface LunchTimeApiDefinition {
}
