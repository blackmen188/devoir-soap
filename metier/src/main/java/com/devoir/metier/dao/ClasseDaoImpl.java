package com.devoir.metier.dao;

import com.devoir.metier.config.MySQLConnection;
import com.devoir.metier.entity.Classe;
import com.devoir.metier.entity.Sector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClasseDaoImpl implements ClasseDao {

    @Override
    public Classe findById(int id) {
        String sql = "SELECT c.*, s.nom as sector_nom FROM classes c JOIN sectors s ON c.sector_id = s.id WHERE c.id = ?";
        try (Connection con = MySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Sector sector = new Sector(rs.getInt("sector_id"), rs.getString("sector_nom"));
                    System.out.println("Classe trouvée avec ID : " + id);
                    return new Classe(
                            rs.getInt("id"),
                            rs.getString("libelle"),
                            rs.getString("description"),
                            sector
                    );
                } else {
                    System.out.println("Aucune classe trouvée avec ID : " + id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de la classe avec ID : " + id);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Classe> findAll() {
        List<Classe> classes = new ArrayList<>();
        String sql = "SELECT c.*, s.nom as sector_nom FROM classes c JOIN sectors s ON c.sector_id = s.id";
        try (Connection con = MySQLConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Sector sector = new Sector(rs.getInt("sector_id"), rs.getString("sector_nom"));
                classes.add(new Classe(
                        rs.getInt("id"),
                        rs.getString("libelle"),
                        rs.getString("description"),
                        sector
                ));
            }
            System.out.println("Liste des classes récupérée avec succès. Nombre : " + classes.size());
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de toutes les classes.");
            e.printStackTrace();
        }
        return classes;
    }

    @Override
    public void save(Classe classe) {
        String sql = "INSERT INTO classes (libelle, description, sector_id) VALUES (?, ?, ?)";
        try (Connection con = MySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, classe.getLibelle());
            ps.setString(2, classe.getDescription());
            ps.setInt(3, classe.getSector().getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        classe.setId(rs.getInt(1));
                    }
                }
                System.out.println("Classe ajoutée avec succès : " + classe.getLibelle());
            } else {
                System.err.println("Échec de l'ajout de la classe.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la classe : " + classe.getLibelle());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Classe classe) {
        String sql = "UPDATE classes SET libelle = ?, description = ?, sector_id = ? WHERE id = ?";
        try (Connection con = MySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, classe.getLibelle());
            ps.setString(2, classe.getDescription());
            ps.setInt(3, classe.getSector().getId());
            ps.setInt(4, classe.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Classe mise à jour avec succès : ID " + classe.getId());
            } else {
                System.err.println("Aucune classe mise à jour : ID " + classe.getId());
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour de la classe : ID " + classe.getId());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM classes WHERE id = ?";
        try (Connection con = MySQLConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Classe supprimée avec succès : ID " + id);
            } else {
                System.err.println("Aucune classe supprimée : ID " + id);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la classe : ID " + id);
            e.printStackTrace();
        }
    }
}
