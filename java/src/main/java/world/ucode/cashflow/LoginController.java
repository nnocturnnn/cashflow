package world.ucode.cashflow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String index(Model model) {
		return "login";
	}

    @GetMapping("/register")
	public String index(Model model) {
		return "register";
	}

    @PostMapping("/login")
    public String index(Model model, HttpServletResponse response) {
		response.encodeRedirectURL("authorization");
	}

}