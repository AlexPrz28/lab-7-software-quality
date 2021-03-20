package mx.tec.lab.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.lab.dto.Greeting;

@RestController
public class GreetingRestController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private static final String templateTwo = "Goodbye, %s!";
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/goodbye")
	public Greeting goodbye(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(templateTwo, name));
	}
	
}
