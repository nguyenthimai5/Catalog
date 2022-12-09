package com.example.catalog.Model.DaoImp;

import com.example.catalog.Model.Dao.CatalogDao;
import com.example.catalog.Model.entity.Catalog;
import com.example.catalog.Model.util.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CatalogDaoimp implements CatalogDao {
    @Override
    public List<Catalog> getAll() {
        Connection conn = null;
        List<Catalog> catalogList = null;
        CallableStatement call = null;
        try {
            conn = ConnectionDB.openConnection();
            call = conn.prepareCall("{call getAllCatalog()}");
            ResultSet rs = call.executeQuery();
            catalogList = new ArrayList<>();
            while (rs.next()) {
                Catalog catalog = new Catalog();
                catalog.setCatalogId(rs.getInt("catalogId"));
                catalog.setCatalogName(rs.getString("catalogName"));
                catalog.setCatalogStatus(rs.getBoolean("catalogStatus"));
                catalog.setDescriptions(rs.getString("descriptions"));
                catalogList.add(catalog);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, call);
        }
        return catalogList;
    }


    @Override
    public Catalog getById(int catalogId) {
        Connection conn = null;
        Catalog catalog = null;
        CallableStatement call = null;
        try {
            conn = ConnectionDB.openConnection();
            call = conn.prepareCall("{call getByIdCatalog(?)}");
            call.setInt(1, catalogId);
            ResultSet rs = call.executeQuery();
            catalog = new Catalog();
            if (rs.next()) {
                catalog.setCatalogId(rs.getInt("catalogId"));
                catalog.setCatalogName(rs.getString("catalogName"));
                catalog.setCatalogStatus(rs.getBoolean("catalogStatus"));
                catalog.setDescriptions(rs.getString("descriptions"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, call);
        }
        return catalog;
    }

    @Override
    public boolean save(Catalog catalog) {
        Connection connection = null;
        CallableStatement call = null;
        boolean result = false;
        try {
            connection = ConnectionDB.openConnection();
            call = connection.prepareCall("call insertCatalog(?,?,?)");
            call.setString(1, catalog.getCatalogName());
            call.setBoolean(2, catalog.isCatalogStatus());
            call.setString(3, catalog.getDescriptions());
            call.executeUpdate();
            result=true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection,call);
        }
        return result;
    }

    @Override
    public boolean update(Catalog catalog) {
        Connection conn=null;
        CallableStatement call=null;
        boolean result=false;
        try{
            conn=ConnectionDB.openConnection();
            call=conn.prepareCall("call updateCatalog(?,?,?,?)");
            call.setInt(1,catalog.getCatalogId());
            call.setString(2,catalog.getCatalogName());
            call.setBoolean(3,catalog.isCatalogStatus());
            call.setString(4, catalog.getDescriptions());
            call.executeUpdate();
            result=true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
           ConnectionDB.closeConnection(conn,call);
        }
        return result;
    }

    @Override
    public boolean delete(int catalogId) {
        Connection conn=null;
        CallableStatement call=null;
        boolean result=false;
        try{
            conn=ConnectionDB.openConnection();
            call=conn.prepareCall("call deleteCatalog(?)");
            call.setInt(1,catalogId);
            call.executeUpdate();
            result=true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn,call);
        }
        return result;
    }

    @Override
    public List<Catalog> search(String search) {
        Connection conn=null;
        CallableStatement call=null;
        List<Catalog> catalogListSearch=null;
        try {
            conn=ConnectionDB.openConnection();
            call=conn.prepareCall("call searchCatalog(?)");
            call.setString(1,search);
           ResultSet rs= call.executeQuery();
            catalogListSearch = new ArrayList<>();
            while (rs.next()) {
                Catalog catalog = new Catalog();
                catalog.setCatalogId(rs.getInt("catalogId"));
                catalog.setCatalogName(rs.getString("catalogName"));
                catalog.setCatalogStatus(rs.getBoolean("catalogStatus"));
                catalog.setDescriptions(rs.getString("descriptions"));
                catalogListSearch.add(catalog);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn,call);
        }
        return catalogListSearch;
    }
}
