package Ecommerce.example.Shopy.Service;

import Ecommerce.example.Shopy.Config.GlobalRESTAPIHandler;
import Ecommerce.example.Shopy.Config.ResponseAPI;
import Ecommerce.example.Shopy.Entity.Category;
import Ecommerce.example.Shopy.Entity.Order;
import Ecommerce.example.Shopy.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    GlobalRESTAPIHandler globalRESTAPIHandler;

    public ResponseEntity<ResponseAPI<Order>> saveOrUpdateOrder(Order order, String
            successMessage) {
        Order savedOrder = orderRepository.save(order);
        return globalRESTAPIHandler.createResponse(successMessage, HttpStatus.OK, order);
    }

    public ResponseEntity<ResponseAPI<String>> deleteOrder(Order order) {
        Optional<Order> orderFound = orderRepository.findById(order.getId());

        if (orderFound.isPresent()) {
            orderRepository.deleteById(order.getId());
            return globalRESTAPIHandler.createResponse("Deleted Successfully!", HttpStatus.OK, "Order ID: "
                    + order.getId());
        } else {
            return globalRESTAPIHandler.createResponse("Order not found!", HttpStatus.NOT_FOUND,
                    null);
        }
    }
    public Page<Order> findAllPaginated(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}
