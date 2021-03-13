package pl.edu.wszib.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.services.IAccountService;
import pl.edu.wszib.bank.session.SessionObject;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountController {

    @Autowired
    IAccountService accountService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/deposit/{id}", method = RequestMethod.GET)
    public String deposit(@PathVariable int id, Model model) {
        if( !this.sessionObject.isLogged()) {
            return "redirect:/login";
        }

        Account account = this.accountService.getAccountById(id);

        model.addAttribute("curAccount", account);
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "deposit";
    }

    @RequestMapping(value = "/deposit/{id}", method = RequestMethod.POST)
    public String deposit(@ModelAttribute Account curAccount) {
        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        Pattern regexp = Pattern.compile("[0-9]{5}.*");
        Double credit =  0.0;
        Matcher creditMatcher = regexp.matcher(credit.toString());

        if(!creditMatcher.matches()) {
            this.sessionObject.setInfo("input error !!");
            return "redirect:/deposit/{id}";
        }

        this.accountService.deposit(credit, curAccount);

        return "redirect:/accounts";
    }

    @RequestMapping(value = "/withdraw/{id}", method = RequestMethod.GET)
    public String withdraw(@PathVariable int id, Model model) {
        if( !this.sessionObject.isLogged()) {
            return "redirect:/login";
        }

        Account account = this.accountService.getAccountById(id);

        model.addAttribute("curAccount", account);
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "deposit";
    }

    @RequestMapping(value = "/withdraw/{id}", method = RequestMethod.POST)
    public String withdraw(@ModelAttribute Account curAccount) {
        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        Pattern regexp = Pattern.compile("[0-9]{5}.*");
        Double credit =  0.0;
        Matcher creditMatcher = regexp.matcher(credit.toString());

        if(!creditMatcher.matches()) {
            this.sessionObject.setInfo("input error !!");
            return "redirect:/withdraw/{id}";
        }

        this.accountService.withdraw(credit, curAccount);

        return "redirect:/accounts";
    }

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET)
    public String transaction(@PathVariable int id, Model model) {
        if( !this.sessionObject.isLogged()) {
            return "redirect:/login";
        }

        Account accountFrom = this.accountService.getAccountById(id);

        model.addAttribute("accFrom", accountFrom);
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "deposit";
    }

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.POST)
    public String transaction(@ModelAttribute String NUM_From, @ModelAttribute String NUM_To) {
        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        Pattern regexp = Pattern.compile("[0-9]{5}.*");
        Double credit =  0.0;
        Matcher accNUMFromMatcher = regexp.matcher(NUM_From);
        Matcher accNUMToMatcher   = regexp.matcher(NUM_To);
        Matcher creditMatcher  = regexp.matcher(credit.toString());

        if(!accNUMFromMatcher.matches()
                || !accNUMToMatcher.matches()
                || !creditMatcher.matches()) {
            this.sessionObject.setInfo("input error !!");
            return "redirect:/deposit/{id}";
        }

        this.accountService.makeTransaction(credit, NUM_From, NUM_To);

        return "redirect:/accounts";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String account(Model model) {


        model.addAttribute("isLogged", this.sessionObject.isLogged());

        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "account";
    }
}
