package main.Service;

import main.DTO.DTOConverter;
import main.DTO.Product.ProductDTO;
import main.Entity.Category;
import main.Entity.Product;
import main.Repository.CategoryRepository;
import main.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<ProductDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId(Long categoryId) {
        return productRepository.getProductByCategory(categoryId)
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        return Objects.nonNull(product) ? DTOConverter.convert(product) : null;
    }

    public ProductDTO save(ProductDTO productDTO) {
        Product productToBeSaved = Product.convert(productDTO);
        Optional<Category> category = categoryRepository.findById(productDTO.getCategoryDTO().getId());
        category.ifPresent(productToBeSaved::setCategory);

        Product productSaved = productRepository.save(productToBeSaved);
        return DTOConverter.convert(productSaved);
    }

    public ProductDTO delete(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()) {
            productRepository.delete(product.get());
            return DTOConverter.convert(product.get());
        }
        return null;
    }
}