package world.ucode.cashflow.controller;

import world.ucode.cashflow.db.User;
import world.ucode.cashflow.db.Transaction;
import world.ucode.cashflow.banking.*;
import world.ucode.cashflow.repos.TransactionRepo;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import java.io.IOException;

@Controller
public class MainController {
    @Autowired
    private TransactionRepo transactionRepo;

	@GetMapping("/home")
	public String index(@AuthenticationPrincipal User user,Model model) {
        model.addAttribute("user",user.getUsername());
		return "records";
	}

    // @PostMapping("/home")
	// public String recordAdd(@AuthenticationPrincipal User user,
    //         @RequestParam String text,
    //         @RequestParam String tag, Map<String, Object> model) {
    //     // Transaction transaction = new Transaction(text, tag, user);
    //     // transactionRepo.save(transaction);
	// 	return "records";
	// }

    @GetMapping("/transaction")
	public String transaction(Model model) {
		return "transaction";
    }
    
    // @GetMapping("/records")
	// public String recordGet(Model model) {
	// 	return "records";
	// }

    @PostMapping("/home")
    public String transactionPost(Model model,@ModelAttribute Transaction transaction) {
        // Iterable<Transaction> transactions = transactionRepo.findAll();
        model.addAttribute("transaction", transaction);
        // transaction.setType("food");
        // System.out.println(transaction.getType());
        // System.out.println(transaction.getText());
        // model.put("messages", );
		return "transaction";
    }
    
    @GetMapping("/monobank")
    public String Mono(Map<String, Object> model,@AuthenticationPrincipal User user) throws Exception {
        Iterable<Transaction> transactions = transactionRepo.findAll();
        Mono mono = new Mono();
        String data = mono.sendGet();
        model.put("user",user.getUsername());
        model.put("data",data);
		return "monobank";
	}

}