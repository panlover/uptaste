package cn.uptaste.controller;

import cn.uptaste.model.Customer;
import cn.uptaste.model.Merchant;
import cn.uptaste.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 对用户操作的类
 */
@Controller
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "merchant/{username}",method = RequestMethod.GET)
    public ModelAndView getMerchantInformation(@PathVariable String username,HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        Merchant customer=merchantService.getMerchantByUsername(username);
        modelAndView.addObject("merchant",customer);
        modelAndView.setViewName("merchant/home");
        return modelAndView;
    }

    @RequestMapping(value = "merchant/login",method = RequestMethod.GET)
    public ModelAndView showLoginForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("merchant",new Customer());
        modelAndView.setViewName("merchant/login");
        return modelAndView;
    }

    @RequestMapping(value = "merchant/login",method = RequestMethod.POST)
    public ModelAndView processLogin(@ModelAttribute Merchant merchant,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Merchant merchant1=merchantService.getMerchantByUsernameAndPassword(merchant.getUsername(),merchant.getPassword());
        if (merchant == null) {
            modelAndView.addObject("message","登录失败，用户名或者密码错误！");
            modelAndView.setViewName("merchant/login");
            return modelAndView;
        }
        HttpSession session=request.getSession();
        session.setAttribute("merchant",merchant1);
        modelAndView.setViewName("redirect:/merchant/"+merchant1.getUsername());
        return modelAndView;
    }

    @RequestMapping(value = "merchant/register",method = RequestMethod.GET)
    public ModelAndView showRegisterForm(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("merchant",new Merchant());
        modelAndView.setViewName("merchant/register");
        return modelAndView;
    }


    @RequestMapping(value = "merchant/register",method = RequestMethod.POST)
    public ModelAndView processRegisterInfomation(@Valid Merchant merchant,BindingResult result,HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        if (result.hasErrors()){
            modelAndView.setViewName("merchant/register");
        }
        merchantService.addMerchant(merchant);
        HttpSession session=request.getSession();
        session.setAttribute("merchant",merchant);
        modelAndView.setViewName("redirect:/merchant/"+merchant.getUsername());
        return modelAndView;
    }

}
