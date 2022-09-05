package com.nagarro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.*;

public class ProductDao {
	Connection con;

    public ProductDao(Connection con) {
        this.con = con;
    }
    
    
    //add books information to database
    public boolean addProduct(Product product){
        boolean test = false;
        
        try{
            String query =  "insert into product (title,quantity,size,image) values(?,?,?,?)";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, product.getTitle());
            pst.setString(2, product.getQuantity());
            pst.setString(3, product.getSize());
            pst.setString(4, product.getImage());
            pst.executeUpdate();
            test= true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return test;
    }
    
//    retrieve the book details from databse
    public List<Product> getAllProduct(){
        List<Product> product = new ArrayList<Product>();
        
        try{
            
            String query = "select * from product";
            PreparedStatement pt = this.con.prepareStatement(query);
            ResultSet rs = pt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String quantity = rs.getString("quantity");
                String size = rs.getString("size");
                String image = rs.getString("image");
                
                Product row = new Product(id,title,quantity,size,image);
                product.add(row);
                
            }
            System.out.println(product);
        }catch(Exception e){
            e.printStackTrace();;
        }
        return product;
    }
    
    
//    edit book information
    public void editProductInfo(Product product){
        
        try{
            String query = "update product set title=?, quantity=?, size=?, image=? where id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, product.getTitle());
            pt.setString(2, product.getQuantity());
            pt.setString(3, product.getSize());
            pt.setString(4, product.getImage());
            pt.setInt(5, product.getId());
            
            pt.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();;
        }
        
        
    }
    
//    get single book information in edit page
    public Product getSingleProduct(int id){
    	Product prod = null;
        
        try{
            String query = "select * from product where id=? ";
            
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next()){
                int id1 = rs.getInt("id");
                String title = rs.getString("title");
                String quantity = rs.getString("quantity");
                String size = rs.getString("size");
                String image  = rs.getString("image");
                prod = new Product(id1,title,quantity,size,image);
            }
        }catch(Exception ex){
            ex.printStackTrace();;
        }
        return prod;
    }
    
    
//    delete books from database
    
    
    public void deleteProduct(int id){
        try{
            
           String query= "delete from product where id=?";
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setInt(1, id);
           pt.execute();
            
        }catch(Exception ex){
            ex.printStackTrace();;
        }
    }
    
}
