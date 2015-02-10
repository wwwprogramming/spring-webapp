package edu.uta.courses.web;

import edu.uta.courses.repository.domain.WwwUser;
import edu.uta.courses.util.UserUtil;
import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by me on 3.1.2015.
 */

@Controller
public class HelloController {

    Logger logger = Logger.getLogger(HelloController.class.getName());

    @RequestMapping(value = {"/"})
    public String helloWorld(Model model) {
        model.addAttribute("greeting", "hello World!");
        System.out.println("helloWorld");
        return "hello";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("greeting", "hello World (from home)!");
        System.out.println("home");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("about", "This is ...");
        System.out.println("about");
        return "about";
    }

    @RequestMapping("/account")
    public String account(Model model) {
        model.addAttribute("account", "");
        // can not do this anymore! User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // OR check if the user is instance if WwwUser...?
        try {
            WwwUser wUser = UserUtil.getWwwUser();
        } catch (Exception e) {
          /* no op BUT REMEMBER, there is static user service too, those ARE instances of
           org.springframework.security.core.userdetails.User
           */
            logger.error("Trying to get WwwUser but the user is not such user?");
        }
        String name = user.getUsername(); //get logged in username

        model.addAttribute("username", name);
        return "account";
    }





        @RequestMapping("/login")
        public String login() {
            if (logger.isTraceEnabled()) { logger.trace("login()"); }
            return "/login";
        }

        @RequestMapping("/logout")
        public String logout() {
            if (logger.isTraceEnabled()) { logger.trace("logout()"); }
            return "/logout";
        }




}
