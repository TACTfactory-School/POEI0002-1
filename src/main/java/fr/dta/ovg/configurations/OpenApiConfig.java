/* Api Swagger Configuration Class.
 * @author Colin Cerveaux @C-ambium.
 * License : ©2019 All rights reserved.
 */
package fr.dta.ovg.configurations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dta.ovg.contracts.ConfigurationContract;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** API "Swagger" Configuration Class. */
@Configuration
@EnableSwagger2
public class OpenApiConfig {

    /** API Swagger.
     * @return Docket : Spring Web plugin Docket Object.*/
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage(ConfigurationContract.API_BASE_PACKAGE))
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

    /** METADATA API.
     * @return ApiInfo : API informations.*/
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title(         ConfigurationContract.API_INFO_TITLE)
                .description(   ConfigurationContract.API_INFO_DESCRIPTION)
                .license(       ConfigurationContract.API_INFO_LICENSE)
                .licenseUrl(    ConfigurationContract.API_INFO_LICENSE_URL)
                .version(       ConfigurationContract.API_INFO_VERSION)
                .build();
    }

    /** HTTP Error Responses.
     * @param status HttpStatus.
     * @return List of Response Message.*/
    private List<ResponseMessage> httpErrorResponses(final HttpStatus...status) {
        return Stream
                .of(status)
                .map(this::httpErrorResponse)
                .collect(Collectors.toList());
    }

    /** HTTP Error Responses.
     * @param status HttpStatus.
     * @return Single Response Message.*/
    private ResponseMessage httpErrorResponse(final HttpStatus status) {
        return new ResponseMessageBuilder()
                .code(status.value())
                .message(status.getReasonPhrase())
                .build();
    }
}
