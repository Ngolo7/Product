package com.gurung7.Service;

import com.gurung7.Entity.Product;
import com.gurung7.Model.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto studentDto);
    Product getProductById(Long pid);
    List<ProductDto> getAllProducts();
    boolean deleteProduct(Long pid);

}
