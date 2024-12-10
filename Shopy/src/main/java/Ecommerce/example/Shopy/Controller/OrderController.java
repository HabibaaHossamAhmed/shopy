package Ecommerce.example.Shopy.Controller;

import Ecommerce.example.Shopy.Config.Response;
import Ecommerce.example.Shopy.Entity.Order;
import Ecommerce.example.Shopy.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<Response<Order>> saveOrder(@RequestBody Order order) {
        return orderService.saveOrUpdateOrder(order, "Created Successfully!");
    }

    @PutMapping
    public ResponseEntity<Response<Order>> updateProduct(@RequestBody Order order) {
        return orderService.saveOrUpdateOrder(order, "Updated Successfully!");
    }

    @DeleteMapping
    public ResponseEntity<Response<String>> deleteProduct(@RequestBody Order order) {
        return orderService.deleteOrder(order);
    }
}
