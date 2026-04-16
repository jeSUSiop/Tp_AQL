package org.example.TP3P1.EXO3;

public class ProductService {

    private final ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public String getProduct(String productId) {
        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("L'identifiant du produit ne peut pas être nul.");
        }
        String result = productApiClient.getProduct(productId);
        if (result == null || result.isBlank()) {
            throw new IllegalStateException("Format de données incompatible.");
        }
        return result;
    }
}