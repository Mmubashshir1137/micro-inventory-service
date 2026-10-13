package micro_inventory_service.service;


import micro_inventory_service.model.Inventory;
import micro_inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Service
public class InventoryService {

    @Autowired
   private InventoryRepository inventoryRepository;

//    public String checkStock(@PathVariable String productId) {
//        String response = productId.equals("1") ? "Stock available" : " Out of Stock";
//        return response;
//    }

    public String addProduct(Inventory inventory) {

        Inventory stock = inventoryRepository.save(inventory);
        return "Product Added";

    }

    public Inventory checkStock(Long productId) throws Exception {




            Optional<Inventory> inventory = inventoryRepository.findById(productId);

            //for retry pattern
            //throw new RuntimeException("Database connection failed");
            return inventory.get();
        }
    }

