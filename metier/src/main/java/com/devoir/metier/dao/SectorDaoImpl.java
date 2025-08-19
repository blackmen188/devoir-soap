package com.devoir.metier.dao;

import com.devoir.metier.config.MySQLConnection;
import com.devoir.metier.entity.Sector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectorDaoImpl implements SectorDao {
    @Override
    public Sector findById(int id) {
        String sql = "SELECT * FROM sectors WHERE id = ?";
        try (Connection con = MySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Sector(rs.getInt("id"), rs.getString("nom"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Sector> findAll() {
        List<Sector> sectors = new ArrayList<>();
        String sql = "SELECT * FROM sectors";
        try (Connection con = MySQLConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                sectors.add(new Sector(rs.getInt("id"), rs.getString("nom")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sectors;
    }

    @Override
    public void save(Sector sector) {
        String sql = "INSERT INTO sectors (nom) VALUES (?)";
        try (Connection con = MySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, sector.getNom());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    sector.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Sector sector) {
        String sql = "UPDATE sectors SET nom = ? WHERE id = ?";
        try (Connection con = MySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sector.getNom());
            ps.setInt(2, sector.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM sectors WHERE id = ?";
        try (Connection con = MySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
