/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Category;
import model.Product;

/**
 *
 * @author Van Man
 */
public class DAO {
            Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Product> list = dao.getAllProduct();
        List<Category> listC = dao.getAllCategory();
        for(Category o : listC){
            System.out.println(o);
        }
        for (Product product : list) {
            System.out.println(product);
        }
    }
    
        public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
        public List<Product> getTop3() {
        List<Product> list = new ArrayList<>();
        String query = "select top 3 * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getLast() {
        String query = "select top 1 * from product\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Product> getAllProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where cateID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Product> getAllProductBySellID(int sid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where sell_ID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1,sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Product getAllProductByID(String cid) {
        String query = "select * from product\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Account login(String user, String pass) {
    String query = "select * from account where [user] = ? and pass = ?";
    try {
        conn = new DBContext().getConnection(); // Mở kết nối với SQL
        ps = conn.prepareStatement(query);
        ps.setString(1, user); // Thiết lập tham số cho cột user
        ps.setString(2, pass); // Thiết lập tham số cho cột pass
        rs = ps.executeQuery();
        while (rs.next()) {
            return new Account(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getInt(4),
                                rs.getInt(5));
        }
    } catch (Exception e) {
        // Xử lý ngoại lệ (nếu cần)
    } finally {
        // Đóng các tài nguyên (Connection, PreparedStatement, ResultSet) ở đây (nếu cần)
    }
    return null;
}
     public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = """
                       select * from product
                       where [name] like ?""";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,"%" + txtSearch +"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
     
     public void signup(String user, String pass){
         String query = "insert into account\n" 
                 + "values(?,?,0,0)";
    try {
        conn = new DBContext().getConnection(); // Mở kết nối với SQL
        ps = conn.prepareStatement(query);
        ps.setString(1, user);
        ps.setString(2, pass);// Thiết lập tham số cho cột user
        ps.executeUpdate();
        
    } catch (Exception e) {
        // Xử lý ngoại lệ (nếu cần)
    } 
     }
     
     public void deleteProduct(String pid){
         String query = "delete from product where id = ?";
         try {
        conn = new DBContext().getConnection(); // Mở kết nối với SQL
        ps = conn.prepareStatement(query);
        ps.setString(1,pid);// Thiết lập tham số cho cột user
        ps.executeUpdate();
        
    } catch (Exception e) {
        // Xử lý ngoại lệ (nếu cần)
    }
     }
     
     public void insertProduct(String name, String image, String price, String title, String description, String category, int sid){
         String query = "INSERT [dbo].[product] ([name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (?,?,?,?,?,?,?)";
         try {
        conn = new DBContext().getConnection(); // Mở kết nối với SQL
        ps = conn.prepareStatement(query);
        ps.setString(1,name);
        ps.setString(2,image);
        ps.setString(3,price);
        ps.setString(4, title);
        ps.setString(5,description);
        ps.setString(6,category);
        ps.setInt(7,sid);
// Thiết lập tham số cho cột user
        ps.executeUpdate();
        
    } catch (Exception e) {
        // Xử lý ngoại lệ (nếu cần)
    }
         
     }
     
     public Product getProductByID(String id) {
        String query = "select * from product\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
     
     public List<Product> getNext3Product(int amount) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT *\n"
                + "  FROM product\n"
                + " ORDER BY id\n"
                + "OFFSET ? ROWS\n"
                + " FETCH NEXT 3 ROWS ONLY";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
     
     public void editProduct(String name, String image, String price,
            String title, String description, String category, String pid) {
        String query = "update product\n"
                + "set [name] = ?,\n"
                + "[image] = ?,\n"
                + "price = ?,\n"
                + "title = ?,\n"
                + "[description] = ?,\n"
                + "cateID = ?\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
     public Account checkAccountExist(String user) {
    String query = "select * from account where [user] = ?";
    try {
        conn = new DBContext().getConnection(); // Mở kết nối với SQL
        ps = conn.prepareStatement(query);
        ps.setString(1, user); // Thiết lập tham số cho cột user
        rs = ps.executeQuery();
        while (rs.next()) {
            return new Account(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getInt(4),
                                rs.getInt(5));
        }
    } catch (Exception e) {
        // Xử lý ngoại lệ (nếu cần)
    } finally {
        // Đóng các tài nguyên (Connection, PreparedStatement, ResultSet) ở đây (nếu cần)
    }
    return null;
}
}
