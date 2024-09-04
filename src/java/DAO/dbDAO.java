/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dbcontext.DBContext;
import entities.FAQs;
import entities.categories;
import entities.items;
//import entities.cars;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class dbDAO {

    public static List<items> getAllItems() {
        try {
            String query = "select * from Items";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<items> list = new ArrayList<>();
            while (rs.next()) {
                items i = new items(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                list.add(i);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public static void update1(int ItemId, String ItemName, int Price, int CateId, int id_origin) {
        try {
            String query1 = ("alter table FAQ drop constraint FK_Items_FAQ;"
            +"update Items set ItemId=" + ItemId + ", ItemName='" + ItemName + "', Price=" + Price + ", CateId="+ CateId +"where ItemId=" + id_origin + ";"
            +"update FAQ set ItemId=" + ItemId + "where ItemId=" + id_origin + ";"
            +"alter table FAQ with nocheck add constraint FK_items_FAQ foreign key (itemId) references items(itemId);");
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps1 = conn.prepareStatement(query1);
            ps1.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public static void update(int id_origin, String ItemName, int Price, int CateId) {
        try {
            String query1 = ("update Items set ItemId=" + id_origin + ", ItemName='" + ItemName + "', Price=" + Price + ", CateId="+ CateId +"where ItemId=" + id_origin + ";");
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps1 = conn.prepareStatement(query1);
            ps1.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public static void delete(int id_origin) {
        try {
            String query1 = ("alter table FAQ drop constraint FK_Items_FAQ;"
            +"delete from Items where ItemId=" + id_origin + ";"
            +"delete from FAQ where ItemId=" + id_origin + ";"
            +"alter table FAQ with nocheck add constraint FK_items_FAQ foreign key (itemId) references items(itemId);");
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps1 = conn.prepareStatement(query1);
            ps1.executeQuery();
        } catch (Exception e) {
        }
    }

    public static List<FAQs> getFAQs(String item_name) {
        try {
            int id = dbDAO.getItemIDbyName(item_name);
            String query = "select * from FAQ where ItemId=?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<FAQs> list = new ArrayList<>();
            while (rs.next()) {
                FAQs f = new FAQs(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(f);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public static List<categories> getCategories() {
        try {
            String query = "select * from Categories";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<categories> list = new ArrayList<>();
            while (rs.next()) {
                categories i = new categories(rs.getInt(1), rs.getString(2), rs.getInt(3));
                list.add(i);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public static int getCategoriesIDbyName(String name) {
        try {
            String query = "select * from Items where ItemName='" + name + "'";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                return id;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public static int getItemIDbyName(String name) {
        try {
            String query = "select * from Items where ItemName='" + name + "'";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                return id;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public static boolean checkItems(int id) {
        boolean isValid = false;
        try {
            String query = ("select * from Items where ItemId=?");
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isValid = true;
            } else {
                isValid = false;
            }
        } catch (Exception e) {
        }
        return isValid;
    }

    public static List<items> getItems(String ItemName, int id_origin) {
        try {
            String query = ("select * from Items where ItemId=?, ItemName=?");
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id_origin);
            ps.setString(2, ItemName);
//            ps.setInt(3, Price);
//            ps.setInt(4, cateid);
            ResultSet rs = ps.executeQuery();
            List<items> list = new ArrayList<>();
            while (rs.next()) {
                items i = new items(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                list.add(i);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
}
