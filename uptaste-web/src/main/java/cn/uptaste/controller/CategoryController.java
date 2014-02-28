package cn.uptaste.controller;

import cn.uptaste.model.Category;
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
 * 对菜品分类的操作
 */
@Controller
public class CategoryController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "/shop/{shopId}/category/create", method = RequestMethod.GET)
    public ModelAndView showCategoryForm(@PathVariable Long shopId){
        ModelAndView modelAndView=new ModelAndView();
        Shop shop=merchantService.getShopById(shopId);
        modelAndView.addObject("shop",shop);
        modelAndView.addObject("category",new Category());
        modelAndView.setViewName("category/saveupdate");
        return modelAndView;
    }

    @RequestMapping(value = "/shop/{shopId}/category/create",method = RequestMethod.POST)
    public ModelAndView addCategory(@Valid Category category,BindingResult result,HttpServletRequest request,@PathVariable Long shopId){
        ModelAndView modelAndView= new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("category/saveupdate");
            return modelAndView;
        }
        Shop shop=merchantService.getShopById(shopId);
        category.setShop(shop);
        merchantService.addCategory(category);
        modelAndView.setViewName("redirect:/shop/"+shopId+"/category/"+category.getId());
        return  modelAndView;
    }

    @RequestMapping(value = "/shop/*/category/{id}",method = RequestMethod.GET)
    public ModelAndView showCategoryInformation(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView();
        Category category=merchantService.getCategoryById(id);
        Shop shop=category.getShop();
        modelAndView.addObject("shop",shop);
        modelAndView.addObject("category",category);
        modelAndView.setViewName("category/home");
        return modelAndView;
    }
}
