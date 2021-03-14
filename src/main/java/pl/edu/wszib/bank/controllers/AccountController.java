package pl.edu.wszib.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.bank.model.Account;
import pl.edu.wszib.bank.model.view.InnerTransModel;
import pl.edu.wszib.bank.model.view.TransactionModel;
import pl.edu.wszib.bank.services.IAccountService;
import pl.edu.wszib.bank.session.SessionObject;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
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
        model.addAttribute("depositInfo", new InnerTransModel());
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "deposit";
    }

    @RequestMapping(value = "/deposit/{id}", method = RequestMethod.POST)
    public String deposit(@ModelAttribute InnerTransModel depositInfo, @ModelAttribute Account curAccount) {
        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        Pattern regexp = Pattern.compile("[0-9,]+");
        Matcher creditMatcher = regexp.matcher(depositInfo.getAmount().toString());

        if(!creditMatcher.matches() ) {
            this.sessionObject.setInfo("input error !!");
            return "redirect:/deposit/{id}";
        }

        this.accountService.deposit(curAccount, depositInfo.getAmount());

        return "redirect:/accounts";
    }

    @RequestMapping(value = "/withdraw/{id}", method = RequestMethod.GET)
    public String withdraw(@PathVariable int id, Model model) {
        if( !this.sessionObject.isLogged()) {
            return "redirect:/login";
        }

        Account account = this.accountService.getAccountById(id);

        model.addAttribute("curAccount", account);
        model.addAttribute("withdrawInfo", new InnerTransModel());
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "withdraw";
    }

    @RequestMapping(value = "/withdraw/{id}", method = RequestMethod.POST)
    public String withdraw(@ModelAttribute InnerTransModel withdrawInfo, @ModelAttribute Account curAccount) {
        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }

        Pattern regexp = Pattern.compile("[0-9,]+");
        Matcher creditMatcher = regexp.matcher(withdrawInfo.getAmount().toString());

        if(!creditMatcher.matches() ) {
            this.sessionObject.setInfo("input error !!");
            return "redirect:/withdraw/{id}";
        }

        this.accountService.withdraw(curAccount, withdrawInfo.getAmount());
        return "redirect:/accounts";
    }

    @RequestMapping(value = "/transfer/{id}", method = RequestMethod.GET)
    public String transfer(@PathVariable int id, Model model) {
        if( !this.sessionObject.isLogged()) {
            return "redirect:/login";
        }

        Account account = this.accountService.getAccountById(id);

        model.addAttribute("curAccount", account);
        model.addAttribute("transInfo", new TransactionModel());
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "transfer";
    }

    @RequestMapping(value = "/transfer/{id}", method = RequestMethod.POST)
    public String transfer(@ModelAttribute TransactionModel transInfo, @ModelAttribute Account curAccount) {
        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        Pattern regexpText = Pattern.compile("[A-Za-z0-9,.]{3}.*");
        Matcher titleMatcher = regexpText.matcher(transInfo.getTitle());
        Pattern regexpNum = Pattern.compile("[0-9]{26}");
        Matcher accountNumMatcher = regexpNum.matcher(transInfo.getAccNumber());
        Pattern regexpCred = Pattern.compile("[0-9,]+");
        Matcher creditMatcher = regexpCred.matcher(transInfo.getAmount().toString());

        if(!titleMatcher.matches()
                || !accountNumMatcher.matches()
                || !creditMatcher.matches() ) {
            this.sessionObject.setInfo("input error !!");
            return "redirect:/transfer/{id}";
        }

        this.accountService.crossAccTransfer(transInfo.getTitle(), transInfo.getAccNumber(), curAccount, transInfo.getAmount());
        return "redirect:/accounts";
    }

    @RequestMapping(value = "/history/{id}", method = RequestMethod.GET)
    public String history(@PathVariable int id, Model model) {
        if( !this.sessionObject.isLogged()) {
            return "redirect:/login";
        }

        Account account = this.accountService.getAccountById(id);

        model.addAttribute("historyList", account.getHistory());
        return "history";
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String accounts(Model model) {
        if( !this.sessionObject.isLogged()) {
            return "redirect:/login";
        }

        model.addAttribute("curUser", this.sessionObject.getLoggedUser());
        model.addAttribute("accounts", this.accountService.viewAccounts(this.sessionObject.getLoggedUser()));
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "accounts";
    }
}
