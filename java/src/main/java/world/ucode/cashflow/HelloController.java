package world.ucode.cashflow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HelloController {

	@GetMapping("/")
	public String index(Model model) {
		return "home";
	}

}