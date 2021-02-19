package world.ucode.cashflow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

    @GetMapping("/register")
	public String register(Model model) {
		return "register";
	}

    @PostMapping("/login")
    public String postLogin(Model model, HttpServletResponse response) {
		return "redirect:home";
	}

}