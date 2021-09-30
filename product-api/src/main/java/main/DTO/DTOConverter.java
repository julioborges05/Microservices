package main.DTO;

import main.DTO.Product.CategoryDTO;
import main.DTO.Product.ProductDTO;
import main.Entity.Category;
import main.Entity.Product;

public class DTOConverter {
    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        if(product.getCategory() != null) {
            productDTO.setCategoryDTO(DTOConverter.convert(product.getCategory()));
        }
        return productDTO;
    }
}
