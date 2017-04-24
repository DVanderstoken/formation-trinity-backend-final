package nc.gouv.dtsi.etudes.axi.formation;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationApiDocConfiguration {

	@Autowired
	private Environment environment;

	/**
	 * Enabled only if Spring active profiles contains the apidoc profile !
	 * 
	 * @return a SpringFox Docket
	 */
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(Arrays.asList(this.environment.getActiveProfiles())
						.contains("apidoc"));
	}

}
