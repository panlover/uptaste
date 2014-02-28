package cn.uptaste.controller;

import cn.uptaste.model.Merchant;
import cn.uptaste.model.Shop;
import cn.uptaste.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 店铺操作类
 */
@Controller
public class ShopController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "merchant/{merchantName}/shop/create", method = RequestMethod.GET)
    public ModelAndView showShopForm(@PathVariable String merchantName){
        ModelAndView modelAndView=new ModelAndView();
        Merchant merchant=merchantService.getMerchantByUsername(merchantName);
        modelAndView.addObject("merchant",merchant);
        modelAndView.addObject("shop",new Shop());
        modelAndView.setViewName("shop/saveupdate");
        return modelAndView;
    }

    @RequestMapping(value = "merchant/{merchantName}/shop/create",method = RequestMethod.POST)
    public ModelAndView addShop(@Valid Shop shop,BindingResult result,HttpServletRequest request,@PathVariable String merchantName){
        ModelAndView modelAndView= new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("shop/saveupdate");
            return modelAndView;
        }
        Merchant merchant=merchantService.getMerchantByUsername(merchantName);
        shop.setMerchant(merchant);
        merchantService.addShop(shop);
        modelAndView.setViewName("redirect:/merchant/"+merchantName+"/shop/"+shop.getId());
        return  modelAndView;
    }

    @RequestMapping(value = "/merchant/*/shop/{id}",method = RequestMethod.GET)
    public ModelAndView showShopInformation(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView();
        Shop shop=merchantService.getShopById(id);
        Merchant merchant=shop.getMerchant();
        modelAndView.addObject("shop",shop);
        modelAndView.addObject("merchant",merchant);
        modelAndView.setViewName("shop/home");
        return modelAndView;
    }
}
