package org.example.TP3P1.EXO1.EXO3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Exercice 3 – ProductService × ProductApiClient")
class ProductServiceTest {

    @Mock
    private ProductApiClient productApiClient;  // interface → pas de problème Java 25

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productApiClient);
    }

    @Test
    @DisplayName("getProduct : récupération réussie")
    void getProduct_shouldReturnProduct_whenApiRespondsCorrectly() {
        // ARRANGE
        String productId = "P-001";
        when(productApiClient.getProduct(productId)).thenReturn("Laptop");

        // ACT
        String result = productService.getProduct(productId);

        // ASSERT
        assertEquals("Laptop", result);
        verify(productApiClient, times(1)).getProduct(productId);
    }

    @Test
    @DisplayName("getProduct : format de données incompatible")
    void getProduct_shouldThrowIllegalStateException_whenApiReturnsEmptyData() {
        // ARRANGE
        String productId = "P-002";
        when(productApiClient.getProduct(productId)).thenReturn("");

        // ACT + ASSERT
        IllegalStateException ex = assertThrows(
                IllegalStateException.class,
                () -> productService.getProduct(productId)
        );

        assertTrue(ex.getMessage().contains("incompatible"));
        verify(productApiClient, times(1)).getProduct(productId);
    }

    @Test
    @DisplayName("getProduct : échec d'appel API")
    void getProduct_shouldThrowRuntimeException_whenApiFails() {
        // ARRANGE
        String productId = "P-003";
        doThrow(new RuntimeException("Erreur API"))
                .when(productApiClient).getProduct(productId);

        // ACT + ASSERT
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> productService.getProduct(productId)
        );

        assertEquals("Erreur API", ex.getMessage());
        verify(productApiClient, times(1)).getProduct(productId);
    }

    @Test
    @DisplayName("getProduct : productId nul")
    void getProduct_shouldThrowIllegalArgumentException_whenProductIdIsNull() {
        // ACT + ASSERT
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> productService.getProduct(null)
        );

        assertTrue(ex.getMessage().contains("nul"));
        verify(productApiClient, never()).getProduct(any());
    }
}