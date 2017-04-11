package nc.gouv.dtsi.etudes.axi.formation.hello;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

	private static final String helloToSomeone = "Hello ";

	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<String> sayHelloToSomeone(
			@RequestParam(name = "someone", required = false, defaultValue = "World") final String someone) {

		return new HttpEntity<String>(helloToSomeone + someone + " !");

	}

}
