package dailysletter.controllers;

import dailysletter.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by Home on 02.05.2017.
 */
@Controller
public class MainClientController {

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @RequestMapping(name ="/dailynewsletter/authoriz")
    public ModelAndView authoriz() {
        return new ModelAndView("authoriz","user", new User());
    }

//    test methods
    @RequestMapping(value = "/user",  method = RequestMethod.GET)
    public String mainPage() {
        return "/authorization/user";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage() {
        return "/authorization/admin";
    }
    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false)String error) {
        ModelAndView modelAndView = new ModelAndView();
        if(error != null) {
            modelAndView.addObject("error", "Invalid username or password");
        }
        modelAndView.setViewName("login");

        return modelAndView;
    }
    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user) {
        ModelAndView model = new ModelAndView();

        if(user != null) {
            model.addObject("errorMsg", user.getName() + " ,you have no access to this page!");
        } else {
            model.addObject("errorMsg","You have no access to this page!");
        }
        model.setViewName("/authorization/access-denied");
        return model;
    }




}
