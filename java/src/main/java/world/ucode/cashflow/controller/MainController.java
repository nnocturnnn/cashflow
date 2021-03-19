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
import java.util.List;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {
    @Autowired
    private TransactionRepo transactionRepo;

	@GetMapping("/home")
	public String index(@AuthenticationPrincipal User user,Model model, @ModelAttribute Transaction transaction) {
        model.addAttribute("user",user.getUsername());
        model.addAttribute("transaction",transaction);
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
    public String transactionPost(@AuthenticationPrincipal User user,Map<String, Object> model) {
        Transaction transaction = new Transaction();
        Iterable<Transaction> transactions = transactionRepo.findAll();
        model.put("transaction", transaction);
		return "transaction";
    }
    
    @GetMapping("/monobank")
    public String Mono(Map<String, Object> model,@AuthenticationPrincipal User user) throws Exception {
        Mono mono = new Mono();
        List<MonoTransaction> data = mono.sendGet();
        int count = 0;
        String balance = "";
        for(MonoTransaction i : data) {
            if (count == 0) {
                balance = i.getBalance();
            }
            Date currentTime = new Date(Integer.parseInt(i.getTime()));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(currentTime);
            i.setBalance(Double.toString(Double.parseDouble(i.getBalance()) / 100));
            i.setAmount(Double.toString(Double.parseDouble(i.getAmount()) / 100));
            i.setTime(dateString);
            if (i.getCurrencyCode() == "980") {
                i.setCurrencyCode("UAN");
            } else if (i.getCurrencyCode() == "978") {
                i.setCurrencyCode("EUR");
            } else if (i.getCurrencyCode() == "840") {
                i.setCurrencyCode("USD");
            }
            if (Integer.parseInt(i.getOperationAmount()) > 0){
                i.setOperationAmount("Income");
            } else {
                i.setOperationAmount("Expense");
            } 
            count++;
        }
        model.put("balance",balance);
        model.put("monos",data);
        model.put("user",user.getUsername());
		return "monobank";
	}

}