package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class HelloApplication {

	@RequestMapping("/")
	@ResponseBody@
	RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting(@RequestParam(value="tall1", required=false)  String tall1,
                           @RequestParam(value = "tall2", required = false) String tall2,
                           @RequestParam(value = "mathType", required = false) String mathType,
                           Model model) {
        if (tall1 != null && tall2 != null && mathType != null) {
            switch (mathType) {
                case "pluss" :
                    model.addAttribute("svar", Double.parseDouble(tall1) + Double.parseDouble(tall2));
                    break;
                case "gange" :
                    model.addAttribute("svar", Double.parseDouble(tall1) * Double.parseDouble(tall2));
                    break;
                case "dele" :
                    model.addAttribute("svar", Double.parseDouble(tall1) / Double.parseDouble(tall2));
                    break;
                default:
                    break;

            }
        }
        return "index";
    }
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
}
