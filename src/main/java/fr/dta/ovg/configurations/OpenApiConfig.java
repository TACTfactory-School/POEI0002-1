package fr.dta.ovg.configurations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class OpenApiConfig {

    private static final String BASE_PACKAGE = "fr.dta.ovg";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                    .paths(PathSelectors.any())
                    .build()
                    .globalResponseMessage(
                            RequestMethod.GET, this.httpErrorResponses(
                                    HttpStatus.OK,
                                    HttpStatus.FORBIDDEN,
                                    HttpStatus.NOT_FOUND,
                                    HttpStatus.INTERNAL_SERVER_ERROR))
                    .globalResponseMessage(
                            RequestMethod.POST, this.httpErrorResponses(
                                    HttpStatus.CREATED,
                                    HttpStatus.FORBIDDEN,
                                    HttpStatus.BAD_REQUEST,
                                    HttpStatus.INTERNAL_SERVER_ERROR))
                    .globalResponseMessage(
                            RequestMethod.PUT, this.httpErrorResponses(
                                    HttpStatus.OK,
                                    HttpStatus.FORBIDDEN,
                                    HttpStatus.BAD_REQUEST,
                                    HttpStatus.NOT_FOUND,
                                    HttpStatus.INTERNAL_SERVER_ERROR))
                    .globalResponseMessage(
                            RequestMethod.DELETE, this.httpErrorResponses(
                                    HttpStatus.NO_CONTENT,
                                    HttpStatus.FORBIDDEN,
                                    HttpStatus.NOT_FOUND,
                                    HttpStatus.INTERNAL_SERVER_ERROR))
                    .apiInfo(this.metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("OVG API documentation")
                .description("Documentation of the back-end API of On Va Geeker")
                .license("© Tous droits réservés")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

    private List<ResponseMessage> httpErrorResponses(final HttpStatus...status) {
        return Stream
                .of(status)
                .map(this::httpErrorResponse)
                .collect(Collectors.toList());
    }

    private ResponseMessage httpErrorResponse(final HttpStatus status) {
        return new ResponseMessageBuilder()
                .code(status.value())
                .message(status.getReasonPhrase())
                .build();
    }
}
