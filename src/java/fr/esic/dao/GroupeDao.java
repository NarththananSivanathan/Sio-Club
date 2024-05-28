/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esic.dao;

import fr.esic.model.Etudiant;
import fr.esic.model.Groupe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author filia
 */
public class GroupeDao {
    //avoir tout les groupes de la personne connectée : les groupes créés ???
    
     public static List<Groupe> groupeCree ( Etudiant e )throws SQLException {
        List<Groupe> list = new ArrayList();
        String sql = "SELECT * FROM groupe WHERE id_admin_groupe = ? "   ;
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);

        prepare.setInt(1, e.getIdentifiant());
        ResultSet rs = prepare.executeQuery();
        
        while (rs.next()) {
             Groupe g = new Groupe() ;
             list.add(g);
        }
        
        return list ;
        
    }
    //tous les groupe où il est membre ???
     public static List<Groupe> groupeOuMembre( Etudiant e )throws SQLException {
        
        List<Groupe> list = new ArrayList();
        String sql = "SELECT g.* , e.nom as createur FROM groupe g join membre m on  m.idgroupe = g.idgroupe  Join etudiant e on e.idetudiant = g.id_admin_groupe WHERE m.idetudiant = ? OR g.id_admin_groupe = ? "  ;
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);

        prepare.setInt(1, e.getIdentifiant());
        prepare.setInt(2, e.getIdentifiant());
        ResultSet rs = prepare.executeQuery();
        
        while (rs.next()) {
             Groupe g = new Groupe() ;
             g.setIdGroupe(rs.getInt("idgroupe"));
             g.setNomGroupe(rs.getString("nom_groupe"));
             Etudiant c = new Etudiant ();
             c.setNom(rs.getString("createur"));
             g.setAdminGroupe(c);
             list.add(g);
        }
         
        return list ;
    }
}
