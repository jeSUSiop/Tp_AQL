package org.example.TP3P1.EXO1.EXO2;


/**
 * Service métier pour la gestion des commandes.
 * Orchestre la logique métier et délègue la persistance au DAO.
 */
public class OrderService {

    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    public void createOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("La commande ne peut pas être nulle.");
        }
        if (order.getQuantity() <= 0) {
            throw new IllegalArgumentException("La quantité doit être positive.");
        }

        orderDao.saveOrder(order);
    }
}

