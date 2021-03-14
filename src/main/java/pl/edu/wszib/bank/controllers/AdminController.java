package pl.edu.wszib.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.bank.model.User;
import pl.edu.wszib.bank.model.view.AccCreationModel;
import pl.edu.wszib.bank.model.view.RegistrationModel;
import pl.edu.wszib.bank.services.IUserService;
import pl.edu.wszib.bank.session.SessionObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

@Controller
public class AdminController {

    @Autowired
    IUserService userService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/newuser", method = RequestMethod.GET)
    public String createUser(Model model) {
        if(!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }
        model.addAttribute("newUser", new RegistrationModel());
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "newuser";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String createUser(@ModelAttribute RegistrationModel newUser) {
        if(!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }
        Pattern regexp = Pattern.compile("[A-Za-z0-9]{5}.*");
        Matcher loginMatcher = regexp.matcher(newUser.getLogin());
        Matcher passMatcher = regexp.matcher(newUser.getPass());
        Matcher pass2Matcher = regexp.matcher(newUser.getPass2());

        if(!loginMatcher.matches()
                || !passMatcher.matches()
                || !pass2Matcher.matches()
                || !newUser.getPass().equals(newUser.getPass2())) {
            this.sessionObject.setInfo("validation error !!");
            return "redirect:/newuser";
        }

        if(this.userService.newUser(newUser)) {
            return "redirect:/main";
        } else {
            this.sessionObject.setInfo("contested login!!");
            return "redirect:/newuser";
        }
    }

    @RequestMapping(value = "/newacc", method = RequestMethod.GET)
    public String createAccount(Model model) {
        if(!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }

        model.addAttribute("newAccMod", new AccCreationModel());
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);

        return "newacc";
    }

    @RequestMapping(value = "/newacc", method = RequestMethod.POST)
    public String createAccount(@ModelAttribute AccCreationModel newAccMod) {
        if(!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }

        Pattern regexp = Pattern.compile("[A-Za-z0-9]{5}.*");
        Matcher loginMatcher = regexp.matcher(newAccMod.getChosenLogin());

        if(!loginMatcher.matches()) {
            this.sessionObject.setInfo("validation error !!");
            return "redirect:/newuser";
        }
        if(this.userService.makeAccount(this.userService.getUserByLogin(newAccMod.getChosenLogin()))) {
            return "redirect:/login";
        } else {
            this.sessionObject.setInfo("account creating error!!");
            return "redirect:/newacc_for_user";
        }
    }
}
