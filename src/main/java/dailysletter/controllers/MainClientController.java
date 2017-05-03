package dailysletter.controllers;

import dailysletter.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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



}
