package world.ucode.cashflow.controller;

import world.ucode.cashflow.db.Role;
import world.ucode.cashflow.db.User;
import world.ucode.cashflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

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

    @PostMapping("/register")
    public String postRegister(User user, Map<String, Object> model) {
        if (!userService.addUser(user)) {
            return "redirect:start";
        }
		return "redirect:login";
	}

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        // if (isActivated) {
        //     model.addAttribute("message", "User successfully activated");
        // } else {
        //     model.addAttribute("message", "Activation code is not found!");
        // }

        return "login";
    }

}