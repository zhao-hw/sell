package pers.zhw.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pers.zhw.dataobject.ProductCategory;
import pers.zhw.exception.SellException;
import pers.zhw.form.CategoryForm;
import pers.zhw.service.CategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("list")
    public ModelAndView list(Map<String,Object> map){
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("/category/categoryList",map);
    }

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String,Object> map){
        if (categoryId != null){
            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("category",productCategory);
        }
        return new ModelAndView("/category/index",map);
    }

    @RequestMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("/common/error", map);
        }
        ProductCategory category = new ProductCategory();
        try {
            if (form.getCategoryId() != null){
                category = categoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form,category);
            categoryService.save(category);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("/common/error", map);
        }
        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("/common/suces",map);
    }
}
