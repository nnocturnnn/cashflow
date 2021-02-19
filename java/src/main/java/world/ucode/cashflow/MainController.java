package world.ucode.cashflow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;

@Controller
public class MainController {

	@GetMapping("/home")
	public String index(Model model) {
		return "records";
	}

    @GetMapping("/transaction")
	public String transaction(Model model) {
		return "transaction";
	}    

}