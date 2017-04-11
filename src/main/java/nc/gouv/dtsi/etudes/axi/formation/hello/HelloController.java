package nc.gouv.dtsi.etudes.axi.formation.hello;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

	private static final String helloToSomeone = "Hello ";
	private static final String helloWorld = helloToSomeone + "World !";

	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<String> sayHello() {

		return new HttpEntity<String>(helloWorld);

	}

	@RequestMapping(value = "/hello/{someone}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<String> sayHelloToSomeone(
			@PathVariable("someone") final String someone) {

		return new HttpEntity<String>(helloToSomeone + someone + " !");

	}

}
