package world.ucode.cashflow;

import world.ucode.cashflow.db.Role;
import world.ucode.cashflow.db.User;
import world.ucode.cashflow.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserRepo userRepo;

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
        User userFromDb = userRepo.findByUsername(user.getUsername());
        
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
		return "redirect:login";
	}

}