package com.example.mvn_proj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {

		return "index";
	}

	@PostMapping("/calculate")
	public String calculate(@RequestParam("numbers") String numbers, Model model) {

		try {

			String[] strNumbers = numbers.split(" ");
			int[] intNumbers = new int[strNumbers.length];
			double sum = 0;

			for (int i = 0; i < strNumbers.length; i++) {

				intNumbers[i] = Integer.parseInt(strNumbers[i]);
				sum += intNumbers[i];
			}

			double average = sum / strNumbers.length;
			model.addAttribute("average", average);
			return "result";
		}

		catch (NumberFormatException nf) {
			return "index";
		}

	}
}
