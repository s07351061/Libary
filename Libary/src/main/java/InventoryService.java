import java.util.List;

public interface InventoryService {
    List<Inventory> getAllInventories();
    Inventory getInventoryById(int inventoryId);
    boolean addInventory(Inventory inventory);
    boolean deleteInventory(int inventoryId);
    boolean updateInventory(Inventory inventory);
}
