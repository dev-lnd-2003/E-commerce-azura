package com.website.ecommerce.service;

import com.website.ecommerce.dto.ProductDTO;
import com.website.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProductByCategory(String cid);

    ProductDTO findProductById(Integer pid);
}
