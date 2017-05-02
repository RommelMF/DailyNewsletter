package dailysletter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Home on 02.05.2017.
 */
@Controller
public class MainClientController {

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }
}
