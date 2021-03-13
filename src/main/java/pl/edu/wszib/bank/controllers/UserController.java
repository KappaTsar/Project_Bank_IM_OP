package pl.edu.wszib.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.bank.model.User;
import pl.edu.wszib.bank.model.view.NewPassModel;
import pl.edu.wszib.bank.services.IUserService;
import pl.edu.wszib.bank.session.SessionObject;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        if(this.sessionObject.isLogged()) {
            return "redirect:/main";
        }
        model.addAttribute("userModel", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {
        this.userService.authenticate(user);
        if(this.sessionObject.isLogged()) {
            return "redirect:/main";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.userService.logout();
        return "redirect:/login";
    }

    @RequestMapping(value = "/newpass", method = RequestMethod.GET)
    public String changePass(Model model) {
        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        User curUser = this.sessionObject.getLoggedUser();
        model.addAttribute("curUser", curUser );
        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("newPass", new NewPassModel());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "newpass";
    }

    @RequestMapping(value = "/newpass", method = RequestMethod.POST)
    public String changePass(@ModelAttribute User curUser, @ModelAttribute NewPassModel NewPass) {
        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        Pattern regexp = Pattern.compile("[A-Za-z0-9]{5}.*");
        Matcher oldpassMatcher = regexp.matcher(NewPass.getOld_pass());
        Matcher newpassMatcher = regexp.matcher(NewPass.getNew_pass());
        Matcher newpass2Matcher = regexp.matcher(NewPass.getNew_pass2());

        if(!oldpassMatcher.matches()
                || !newpassMatcher.matches()
                || !newpass2Matcher.matches()
                || !NewPass.getNew_pass().equals(NewPass.getNew_pass2())
                || !NewPass.getOld_pass().equals(curUser.getPass())) {
            this.sessionObject.setInfo("validation error !!");
            return "redirect:/newpass";
        }

        this.userService.changePass(curUser);
        return "redirect:/login";
    }

}
