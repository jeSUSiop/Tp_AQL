package org.example.TP3P1.EXO1.EXO2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Exercice 2 – OrderController × OrderService × OrderDao")
class OrderControllerTest {

    @Mock
    private OrderDao orderDao;

    private OrderService orderService;
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        orderService   = new OrderService(orderDao);
        orderController = new OrderController(orderService);
    }

    @Test
    @DisplayName("createOrder : doit propager la commande jusqu'au DAO")
    void createOrder_shouldDelegateToOrderService_withCorrectOrder() {
        Order order = new Order("CMD-001", "Laptop", 2, 2400.00);

        orderController.createOrder(order);

        verify(orderDao, times(1)).saveOrder(order);
        verifyNoMoreInteractions(orderDao);
    }

    @Test
    @DisplayName("createOrder : doit propager la commande jusqu'au DAO via un service réel")
    void createOrder_shouldPropagateToDao_throughRealService() {
        Order order = new Order("CMD-002", "Mouse", 5, 75.50);

        orderController.createOrder(order);

        verify(orderDao, times(1)).saveOrder(order);
    }

    @Test
    @DisplayName("createOrder : doit propager l'exception si la commande est nulle")
    void createOrder_shouldPropagateException_whenOrderIsNull() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> orderController.createOrder(null)
        );

        assertTrue(ex.getMessage().contains("nulle"));
        verify(orderDao, never()).saveOrder(any());
    }

    @Test
    @DisplayName("createOrder : doit lever IllegalArgumentException pour une quantité invalide")
    void createOrder_shouldThrow_whenQuantityIsInvalid() {
        Order badOrder = new Order("CMD-003", "Keyboard", -1, 50.0);

        assertThrows(IllegalArgumentException.class, () -> orderController.createOrder(badOrder));

        verify(orderDao, never()).saveOrder(any());
    }

    @Test
    @DisplayName("createOrder : doit propager l'exception si le DAO échoue")
    void createOrder_shouldPropagateDaoException() {
        Order order = new Order("CMD-004", "Monitor", 1, 350.0);

        doThrow(new RuntimeException("Erreur base de données"))
                .when(orderDao).saveOrder(order);

        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> orderController.createOrder(order)
        );

        assertEquals("Erreur base de données", ex.getMessage());
        verify(orderDao).saveOrder(order);
    }
}