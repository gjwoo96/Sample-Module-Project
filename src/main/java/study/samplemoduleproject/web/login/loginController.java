package study.samplemoduleproject.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "/pages/login/login";
    }

}
