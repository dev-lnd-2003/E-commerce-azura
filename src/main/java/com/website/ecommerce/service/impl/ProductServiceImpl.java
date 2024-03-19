package com.website.ecommerce.service.impl;

import com.website.ecommerce.dto.ProductDTO;
import com.website.ecommerce.entity.Product;
import com.website.ecommerce.repository.ProductRepository;
import com.website.ecommerce.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<ProductDTO> findAllProductByCategory(String cid) {
        return productRepository.findAllProductByCategoryId(cid)
                .stream()
                .map(this::productConvertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findProductById(Integer pid) {
        Optional<Product> product = productRepository.findProductById(pid);
        return product.map(this::productConvertToDTO).orElse(null);
    }

    public ProductDTO productConvertToDTO(Product product){

        return modelMapper.map(product,ProductDTO.class);
    }
}
