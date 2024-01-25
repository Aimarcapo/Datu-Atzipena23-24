package dambi.restgreeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static  String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name,@RequestParam(value = "hizki", defaultValue = "Kaixo") String hizki) {
		if(hizki.equals("es")){
			template="Hola, %s!";
		}
		else if(hizki.equals("eus")){
			template="Kaixo, %s!";
		}
		else{
			template="Pedro picapiedra";
		}
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	
}
