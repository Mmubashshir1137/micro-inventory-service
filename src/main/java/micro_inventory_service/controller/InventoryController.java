package micro_inventory_service.controller;


import micro_inventory_service.model.Inventory;
import micro_inventory_service.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public String addProduct(@RequestBody Inventory inventory) {
        return inventoryService.addProduct(inventory);

    }

    @GetMapping("/{productId}")
    public Inventory checkInventory(@PathVariable Long productId) throws Exception {
        return inventoryService.checkStock(productId);
    }


//    @GetMapping("/{productId}")
//    public String checkStock(@PathVariable String productId) {
//        String response = inventoryService.checkStock(productId);
//
//        return response;
//    }
}
