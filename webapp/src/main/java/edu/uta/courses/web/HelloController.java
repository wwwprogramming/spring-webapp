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

    @RequestMapping("/slider")
    public String slider(Model model) {
        return "/slider";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("about", "This is ...");
        System.out.println("about");
        return "about";
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
