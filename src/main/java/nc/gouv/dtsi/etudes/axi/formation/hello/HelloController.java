package nc.gouv.dtsi.etudes.axi.formation.hello;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private static final String hello = "Hello World !";

	@RequestMapping(value = "/api/v1/hello", 
                        method = RequestMethod.GET, 
                        produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<String> sayHello() {

		return new HttpEntity<String>(hello);

	}

}
