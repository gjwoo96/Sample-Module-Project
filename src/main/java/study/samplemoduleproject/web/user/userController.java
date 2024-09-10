package study.samplemoduleproject.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userController {

    @RequestMapping(value = "/user/list")
    public String list() {
        return "/pages/user/list";
    }

}
