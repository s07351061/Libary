import java.util.List;

public interface BorrowingRecordService {
    List<BorrowingRecord> getBorrowingRecordsByUserId(int userId);
    boolean addBorrowingRecord(int userId, int inventoryId);
    boolean updateReturnTime(int userId, int inventoryId);
}
