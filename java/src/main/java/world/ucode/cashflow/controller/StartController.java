package world.ucode.cashflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class StartController {

	@GetMapping("/")
	public String index(Model model) {
		return "start";
	}
}