package com.website.ecommerce.api;

import com.website.ecommerce.dto.ProductDTO;
import com.website.ecommerce.entity.Category;
import com.website.ecommerce.service.CategoryService;
import com.website.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*")
public class ProductApi {


    private final ProductService productService;

    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/category-product")
    public ResponseEntity<List<ProductDTO>> findAllList(@RequestParam("cid") String cid){
        List<ProductDTO> result = productService.findAllProductByCategory(cid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/product/product-detail")
    public ResponseEntity<ProductDTO> productDetail(@RequestParam("pid") Integer pid){
        ProductDTO result = productService.findProductById(pid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
