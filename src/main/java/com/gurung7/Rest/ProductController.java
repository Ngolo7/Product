package com.gurung7.Rest;

import com.gurung7.Entity.Product;
import com.gurung7.Model.ProductDto;
import com.gurung7.Service.ServiceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

        @Autowired
        private ProductServiceImpl productimpl;

        @PostMapping("/pro")
        public ResponseEntity<?> saveProduct(@RequestBody ProductDto product) {
            ProductDto productInfo =productimpl.createProduct(product);
            return new ResponseEntity<>(productInfo, HttpStatus.CREATED);
        }

        @GetMapping(value ="/view")
        public ResponseEntity<?> getAllProducts() {
            List<ProductDto> products = productimpl.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }

        @GetMapping("/Bypid/{pid}")
        public Product getProductInfo(@PathVariable Long pid) {
            Product productByPid = productimpl.getProductById(pid);
            return productByPid;
        }
    @DeleteMapping("/delete/{}pid")
      public ResponseEntity<String> deleteProduct(@PathVariable Long pid){
            boolean deletProduct = productimpl.deleteProduct(pid);
            if (deletProduct) {
                return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);

            }
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
      }

}
