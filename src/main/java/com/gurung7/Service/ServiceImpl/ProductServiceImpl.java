package com.gurung7.Service.ServiceImpl;

import com.gurung7.Entity.Product;
import com.gurung7.Model.ProductDto;
import com.gurung7.Repo.ProductRepo;
import com.gurung7.Service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

        @Override
        public ProductDto createProduct(ProductDto productDto) {
            Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
       Product saveEntity = productRepo.save(product);
       ProductDto pDto = new ProductDto();
       BeanUtils.copyProperties(saveEntity, pDto);
            return pDto;
        }

        @Override
        public Product getProductById(Long pid) {
            Optional<Product> productRecords = productRepo.findById(pid);
            return productRecords.get();
        }

        @Override
        public List<ProductDto> getAllProducts() {
            List<Product> productRecords = productRepo.findAll();
            List<ProductDto> viewRecords = new ArrayList<>();
            for (Product pro : productRecords) {
                ProductDto pDto = new ProductDto();
                BeanUtils.copyProperties(pro, pDto);
                viewRecords.add(pDto);
            }
            return viewRecords;
        }

        @Override
        public boolean deleteProduct(Long pid) {
            boolean flag = false;
            Product productId= productRepo.findById(pid).get();
            if (productId != null) {
                productRepo.deleteById(pid);
                flag = true;
            }

            return flag;
        }
    }

