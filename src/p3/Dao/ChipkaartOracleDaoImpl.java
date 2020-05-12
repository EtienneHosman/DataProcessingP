package p3.Dao;

import p3.Domain.Chipkaart;
import p3.Domain.Reiziger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChipkaartOracleDaoImpl extends OracleBaseDao implements ChipkaartDao {

    private ReizigerDao reizigerDao = new ReizigerOracleDaoImpl();
    private ProductDao productDao = new ProductOracleDaoImpl();

    public ChipkaartOracleDaoImpl() throws SQLException{
        super();
    }

    public ArrayList<Chipkaart> findAll() throws SQLException {
        String query = "SELECT * FROM ov_chipkaart";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        ResultSet result = pstmt.executeQuery();

        ArrayList<Chipkaart> alleKaarten = new ArrayList<Chipkaart>();
        while(result.next()){
            Chipkaart c = new Chipkaart();
            c.setKaartNummer(result.getInt("kaartnummer"));
            c.setGeldig(result.getDate("geldigtot"));
            c.setKlasse(result.getInt("klasse"));
            c.setSaldo(result.getDouble("saldo"));
            c.setEigenaar(reizigerDao.findById(result.getInt("reizigerid")));
            c.setProducten(productDao.findByChipkaart(c));
            alleKaarten.add(c);
        }
        result.close();
        pstmt.close();
        return alleKaarten;
    }

    public Chipkaart findByKaartNummer(int kaartNummer) throws SQLException {
        String query = "SELECT * FROM ov_chipkaart WHERE kaartnummer = ?";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setInt(1, kaartNummer);
        ResultSet result = pstmt.executeQuery();

        Chipkaart c = new Chipkaart();
        while (result.next()){
            c.setEigenaar(reizigerDao.findById(result.getInt("reizigerid")));
            c.setSaldo(result.getDouble("saldo"));
            c.setKlasse(result.getInt("klasse"));
            c.setGeldig(result.getDate("geldigtot"));
            c.setKaartNummer(result.getInt("kaartnummer"));
            c.setProducten(productDao.findByChipkaart(c));
        }
        result.close();
        pstmt.close();
        return c;
    }

    public ArrayList<Chipkaart> findByReiziger(Reiziger reiziger) throws SQLException {
        String query = "SELECT * FROM ov_chipkaart WHERE reizigerid = ?";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setInt(1,reiziger.getReizigerID());
        ResultSet result = pstmt.executeQuery();

        ArrayList<Chipkaart> alleKaarten = new ArrayList<Chipkaart>();
        while(result.next()){
            Chipkaart c = new Chipkaart();
            c.setKaartNummer(result.getInt("kaartnummer"));
            c.setGeldig(result.getDate("geldigtot"));
            c.setKlasse(result.getInt("klasse"));
            c.setSaldo(result.getDouble("saldo"));
            c.setEigenaar(reizigerDao.findById(result.getInt("reizigerid")));
            c.setProducten(productDao.findByChipkaart(c));
            alleKaarten.add(c);
        }
        result.close();
        pstmt.close();
        return alleKaarten;
    }

    public Chipkaart save(Chipkaart chipkaart, Reiziger reiziger) throws SQLException{
        String query = "INSERT INTO ov_chipkaart (kaartnummer, geldigtot, klasse, saldo, reizigerid) " +
                "VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setInt(1, chipkaart.getKaartNummer());
        pstmt.setDate(2,chipkaart.getGeldig());
        pstmt.setInt(3,chipkaart.getKlasse());
        pstmt.setDouble(4,chipkaart.getSaldo());
        pstmt.setInt(5, reiziger.getReizigerID());
        ResultSet result = pstmt.executeQuery();

        result.close();
        pstmt.close();
        return  chipkaart;
    }

    public Chipkaart update(Chipkaart chipkaart) throws SQLException{
        String query = "UPDATE ov_chipkaart SET kaartnummer = ?, geldigtot = ?, klasse = ?, saldo = ?, reizigerid = ? " +
                " WHERE kaartnummer = ?";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setInt(1,chipkaart.getKaartNummer());
        pstmt.setDate(2,chipkaart.getGeldig());
        pstmt.setInt(3,chipkaart.getKlasse());
        pstmt.setDouble(4,chipkaart.getSaldo());
        pstmt.setInt(5,chipkaart.getEigenaar().getReizigerID());
        pstmt.setInt(6,chipkaart.getKaartNummer());

        ResultSet result = pstmt.executeQuery();

        result.close();
        pstmt.close();
        return chipkaart;
    }

    public Chipkaart delete(Chipkaart chipkaart) throws SQLException {
        String query = "DELETE ov_chipkaart WHERE kaartnummer = ?";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setInt(1,chipkaart.getKaartNummer());
        ResultSet result = pstmt.executeQuery();

        result.close();
        pstmt.close();
        return chipkaart;
    }
}
