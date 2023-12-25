package com.example.conroller;

import com.example.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/login")
    public String home(Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser) {
        Cookie cookie = new Cookie("setUser", setUser);
        User user = new User();
        user.setUserName(cookie.getValue());
        model.addAttribute("user", user);
        return "/login";
    }

    @PostMapping("dologin")
    public String doLogin(@ModelAttribute("user") User user, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request, Model model) {

        if (user.getUserName().equals("demoCookie") && user.getPassWord().equals("123")) {
            setUser = user.getUserName();

            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            Cookie[] cookies = request.getCookies();

            for (Cookie ck : cookies) {
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck.getValue());
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck.getValue());
                    break;
                }
            }
            model.addAttribute("message", "Login success. Welcome ");
        } else {
            user.setUserName("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("massage", "fail login");
        }
        return "/login";
    }
}
