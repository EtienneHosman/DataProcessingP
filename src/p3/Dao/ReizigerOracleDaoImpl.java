package p3.Dao;


import p3.Domain.Reiziger;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {

    public ReizigerOracleDaoImpl() throws SQLException{
        super();
    }

    public ArrayList<Reiziger> findAll() throws SQLException{
        String query = "SELECT * FROM reiziger";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        ResultSet result = pstmt.executeQuery();

        ArrayList<Reiziger> alleReizigers = new ArrayList<Reiziger>();
        while (result.next()){
            Reiziger r = new Reiziger();

            r.setReizigerID(result.getInt("reizigerid"));
            r.setVoorletters(result.getString("voorletters"));
            r.setTussenvoegsel(result.getString("tussenvoegsel"));
            r.setAchternaam(result.getString("achternaam"));
            r.setGeboortedatum(result.getDate("gebortedatum"));

            alleReizigers.add(r);

        }
        result.close();
        pstmt.close();
        return alleReizigers;
    }

    public Reiziger findById(int id) throws SQLException{
        String query = "SELECT * FROM REIZIGER WHERE REIZIGERID = ?";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setInt(1,id);
        ResultSet result = pstmt.executeQuery();

        Reiziger r = new Reiziger();
        while (result.next()){
            r.setReizigerID(result.getInt("reizigerid"));
            r.setVoorletters(result.getString("voorletters"));
            r.setTussenvoegsel(result.getString("tussenvoegsel"));
            r.setAchternaam(result.getString("achternaam"));
            r.setGeboortedatum(result.getDate("gebortedatum"));
        }
        result.close();
        pstmt.close();
        return r;
    }

    public ArrayList<Reiziger> findByGeboorteDatum(Date geboortedatum) throws SQLException{
        String query = "SELECT * FROM REIZIGER WHERE GEBORTEDATUM = ?";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setDate(1, geboortedatum);
        ResultSet result = pstmt.executeQuery();

        ArrayList<Reiziger> alleReizigers = new ArrayList<Reiziger>();
        while(result.next()){
            Reiziger r = new Reiziger();

            r.setReizigerID(result.getInt("reizigerid"));
            r.setVoorletters(result.getString("voorletters"));
            r.setTussenvoegsel(result.getString("tussenvoegsel"));
            r.setAchternaam(result.getString("achternaam"));
            r.setGeboortedatum(result.getDate("gebortedatum"));

            alleReizigers.add(r);
        }
        result.close();
        pstmt.close();
        return alleReizigers;
    }

    public Reiziger save(Reiziger reiziger) throws SQLException{
        String query = "INSERT INTO REIZIGER (reizigerid, voorletters, tussenvoegsel, achternaam, gebortedatum) " +
                " VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = getConn().prepareStatement(query);

        pstmt.setInt(1, reiziger.getReizigerID());
        pstmt.setString(2,reiziger.getVoorletters());
        pstmt.setString(3,reiziger.getTussenvoegsel());
        pstmt.setString(4,reiziger.getAchternaam());
        pstmt.setDate(5,reiziger.getGeboortedatum());

        ResultSet result = pstmt.executeQuery();

        result.close();
        pstmt.close();
        return reiziger;
    }

    public Reiziger update(Reiziger reiziger) throws  SQLException{
        String query = "UPDATE reiziger SET reizigerid = ?, voorletters = ?, tussenvoegsel = ?, achternaam = ?, gebortedatum = ? " +
                "WHERE reizigerid = ?";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setInt(1, reiziger.getReizigerID());
        pstmt.setString(2, reiziger.getVoorletters());
        pstmt.setString(3, reiziger.getTussenvoegsel());
        pstmt.setString(4, reiziger.getAchternaam());
        pstmt.setDate(5, reiziger.getGeboortedatum());
        pstmt.setInt(6, reiziger.getReizigerID());

        ResultSet result = pstmt.executeQuery();

        result.close();
        pstmt.close();
        return reiziger;
    }

    public Reiziger delete(Reiziger reiziger) throws SQLException {
        String query = "DELETE reiziger WHERE reizigerid = ?";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setInt(1, reiziger.getReizigerID());
        ResultSet result = pstmt.executeQuery();

        result.close();
        pstmt.close();
        return reiziger;
    }
}

