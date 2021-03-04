package world.ucode.cashflow;

import world.ucode.cashflow.db.User;
import world.ucode.cashflow.db.Transaction;
import world.ucode.cashflow.repos.TransactionRepo;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private TransactionRepo transactionRepo;

	@GetMapping("/home")
	public String index(Model model) {
		return "records";
	}

    @PostMapping("/home")
	public String recordAdd(@AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model) {
        Transaction transaction = new Transaction(text, tag, user);
        transactionRepo.save(transaction);
		return "records";
	}

    @GetMapping("/transaction")
	public String transaction(Model model) {
		return "transaction";
	}

    @PostMapping("/transaction")
    public String transactionPost(Map<String, Object> model) {
        Iterable<Transaction> transactions = transactionRepo.findAll();

        model.put("messages", transactions);
		return "transaction";
	}

}