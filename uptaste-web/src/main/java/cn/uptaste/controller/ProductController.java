package cn.uptaste.controller;

import cn.uptaste.model.Category;
import cn.uptaste.model.Product;
import cn.uptaste.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.PublicKey;

/**
 * 产品操作类
 */
@Controller
public class ProductController {
    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "/category/{categoryId}/product/create", method = RequestMethod.GET)
    public ModelAndView showProductForm(@PathVariable Long categoryId) {
        ModelAndView modelAndView = new ModelAndView();
        Category category = merchantService.getCategoryById(categoryId);
        modelAndView.addObject("category", category);
        modelAndView.addObject("product", new Product());
        modelAndView.setViewName("product/saveupdate");
        return modelAndView;
    }

    @RequestMapping(value = "/category/{categoryId}/product/create", method = RequestMethod.POST)
    public ModelAndView addProduct(@Valid Product product, BindingResult result, @PathVariable Long categoryId) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("product/saveupdate");
            return modelAndView;
        }
        Category category = merchantService.getCategoryById(categoryId);
        product.setCategory(category);
        merchantService.addProduct(product);
        modelAndView.addObject("category", category);
        modelAndView.addObject("product", product);
        modelAndView.setViewName("redirect:/category/" + categoryId + "/product/" + product.getId());
        return modelAndView;
    }

    @RequestMapping(value = "/category/*/product/{id}", method = RequestMethod.GET)
    public ModelAndView showProductInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = merchantService.getProductById(id);
        modelAndView.addObject("product", product);
        Category category = product.getCategory();
        modelAndView.addObject("category", category);
        modelAndView.setViewName("product/home");
        return modelAndView;
    }

}
