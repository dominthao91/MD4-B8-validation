package thao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thao.model.User;

@Controller
@RequestMapping("users")
public class UserController {
    @GetMapping("")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @PostMapping("validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("index");
        }
        return new ModelAndView("result");
    }
}
