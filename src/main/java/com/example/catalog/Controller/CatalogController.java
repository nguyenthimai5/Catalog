package com.example.catalog.Controller;

import com.example.catalog.Model.Service.CatalogService;
import com.example.catalog.Model.entity.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("CatalogController")
public class CatalogController {
    @Autowired
     private CatalogService catalogService;
    @RequestMapping("getAllCatalog")
    public ModelAndView getAllCatalog() {
        ModelAndView mav=new ModelAndView("catalog");
        List<Catalog> catalogList=catalogService.getAll();
        mav.addObject("catalogList",catalogList);
        return mav;
    }
    @RequestMapping("insertCatalog")
    public String insertCatalog(Model model){
        Catalog catalogN=new Catalog();
        model.addAttribute("catalogN",catalogN);
        return "catalogNew";
    }
    @PostMapping("create")
    public String createCatalog(@ModelAttribute ("catalogN") Catalog catalogN){
        boolean create=catalogService.save(catalogN);
        if (create){
            return "redirect:getAllCatalog";
        }else {
            return "err";
        }

    }
    @GetMapping("updateCatalog")
    public String updateCatalog(Model model,int catalogId){
        Catalog catalogUp=catalogService.getById(catalogId);
        model.addAttribute("catalogUp",catalogUp);
        return "catalogUp";
    }
    @PostMapping("update")
    public String update(@ModelAttribute("catalogUp") Catalog catalogUp){
        boolean update= catalogService.update(catalogUp);
        if (update){
            return "redirect:getAllCatalog";
        }else {
            return "err";
        }
    }
    @GetMapping("delete")
    public String delete(int catalogId){
        boolean delete=catalogService.delete(catalogId);
        if (delete){
            return "redirect:getAllCatalog";
        }else {
            return "err";
        }

    }
    @PostMapping("search")
    public String search(Model model,String search){
        List<Catalog> catalogListSearch=catalogService.search(search);
       if (catalogListSearch==null){
           return "redirect:getAllCatalog";
       }else {
           model.addAttribute("catalogList",catalogListSearch);
           return "catalog";
       }
    }

}
