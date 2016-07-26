import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/7/22 0022.
 */
public class UserController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        List<User> users = new ArrayList<>();
//        users.add(new User(1, "翡青", new Date(), 1, "浙江-杭州"));
//        users.add(new User(2, "小芳", new Date(), 2, "山东-青岛"));

        ModelAndView result = new ModelAndView();
//        result.addObject("users", users);
//        result.setViewName("users");
        return result;
    }
}