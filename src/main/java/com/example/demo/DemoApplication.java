package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String add(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/oddOrEven")
	public String oddOrEven(@RequestParam(value = "number") int number) {
		String result;

		if (number % 2 == 0) {
			result = "Even";
		} else {
			result = "Odd";
		}

		return String.format("%d is %s.", number, result);
	}


	@GetMapping("/palindrome")
	public String palindrome(@RequestParam(value = "name") String name) {
		String cleanName = name.replaceAll("", "").toLowerCase();

		String reversedName = "";
		for (int i = cleanName.length() - 1; i >= 0; i--) {
			reversedName += cleanName.charAt(i);
		}

		String result;
		if (cleanName.equals(reversedName)) {
			result = "is a palindrome";
		} else {
			result = "is not a palindrome";
		}

		return String.format("%s %s.", name, result);
	}

}