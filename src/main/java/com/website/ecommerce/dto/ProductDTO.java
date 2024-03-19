package com.website.ecommerce.dto;

import com.website.ecommerce.entity.Category;
import com.website.ecommerce.entity.Product;
import com.website.ecommerce.entity.ProductInventory;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    Integer id;
    String name;
    String image;
    Double price;
    Date createDate;
    Boolean available;
    String categoryId;
    String categoryName;
    String categoryPhoto;
    Integer inventoryId;
    Integer inventoryQuantity;
    Date inventoryCreateDate;
}
