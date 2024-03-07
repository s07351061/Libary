import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;
public class Main {
    public static void main(String[] args) {
        // 初始化服務
        BookService bookService = new BookServiceImpl();
        UserService userService = new UserServiceImpl();
        InventoryService inventoryService = new InventoryServiceImpl();
        BorrowingRecordService borrowingRecordService = new BorrowingRecordServiceImpl();
        //jdbc:mysql://127.0.0.1:3306/?user=koro
        //private static java.sql.Connection conn
        //final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=koro";
        final String USER = "koro";
        final String PASS = "123456";
        
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = (Statement) conn.createStatement();
            String sql;
            sql = "SELECT id, name, url FROM websites";
            ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            ((Connection) stmt).close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) ((Connection) stmt).close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}

