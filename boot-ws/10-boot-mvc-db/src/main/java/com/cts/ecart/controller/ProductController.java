package com.cts.ecart.controller;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Category;
import com.cts.ecart.entity.Product;
import com.cts.ecart.repository.BrandRepository;
import com.cts.ecart.repository.CategoryRepository;
import com.cts.ecart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private CategoryRepository catRepo;
    @Autowired
    private ProductRepository prodRepo;
    @Autowired
    private BrandRepository brandRepo;

    @GetMapping(value = "/")
    public String welcome(){
        return "index";
    }


    //lo
    //ad products page
    @GetMapping(value = "/findAllProducts")
    public String findAllProducts(Model model){

        List<Product> prods= prodRepo.findAll();
        model.addAttribute("products",prods);
        System.out.println(prods);
        return "products";

    }

    @GetMapping(value = "/loadProductForm")
    public String f1(Model model){
        // load all categoris from database
        List<Category> categories= catRepo.findAll();
        model.addAttribute("categories",categories);
        return "product-form";
    }

    @PostMapping(value = "/saveProduct")
    public String saveProduct(@RequestParam String productName,@RequestParam double price,@RequestParam String description){
        System.out.println(">>> saving "+productName+" "+price+" "+description);
        return "index";
    }

    @GetMapping(value = "/loadBrands")
    @ResponseBody
    public List<Brand> loadBrands(@RequestParam int categoryId){
        System.out.println(">>>> CatID: "+categoryId);
        Category category= catRepo.findById(categoryId).orElse(null);
        return category.getBrandsInfo();
    }


    @PostMapping(value = "/saveProductV1")
    public String saveProductV1(@ModelAttribute Product prod,@RequestParam int brandId){
        System.out.println(prod);
        Brand brand=brandRepo.findById(brandId).orElse(null);
        Product product=prodRepo.save(prod);
        brand.getProducts().add(product);
        brandRepo.save(brand);
        return "index";
    }




}

