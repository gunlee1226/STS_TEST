package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @SystemName : rcms
 * @ProgramName : SwaggerConfig
 * @Author : LaVega
 * @CreateDate : 2020.10.19
 * @Version : 1.0
 * @Description :
 */
@Configuration
public class SwaggerConfig {

	public Docket api() {
		List<Response> responses = new ArrayList<>();
		responses.add(new ResponseBuilder().code("200").description("OK").build());
		responses.add(new ResponseBuilder().code("400").description("필수 파라메터 부족").build());
		responses.add(new ResponseBuilder().code("401").description("인증 오류").build());

		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(RequestHandlerSelectors.basePackage("config"))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.globalResponses(HttpMethod.GET, responses)
				.globalResponses(HttpMethod.POST, responses)
				.globalResponses(HttpMethod.PUT, responses)
				.globalResponses(HttpMethod.DELETE, responses);
	}
}
