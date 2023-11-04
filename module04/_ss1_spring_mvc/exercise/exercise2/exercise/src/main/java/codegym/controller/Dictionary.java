package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {

    static Map<String, String> map =  new HashMap<>();
    static {
        map.put("hello","xin chào");
        map.put("car","ô tô");
        map.put("bike","xe đạp");
        map.put("table","bảng");
    }

    @GetMapping("/")
    public String home() {
        return "search";
    }

    @GetMapping("/search")
    public String search(@RequestParam String word, Model model){
        String english = word.toLowerCase();
        String vietnam = map.get(english);
        if (vietnam != null) {
            model.addAttribute("result",vietnam);
        }else {
            model.addAttribute("result","not found");
        }
        return "search";
    }
}
