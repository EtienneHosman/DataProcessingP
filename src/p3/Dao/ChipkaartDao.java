package p3.Dao;

import p3.Domain.Chipkaart;
import p3.Domain.Reiziger;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ChipkaartDao {
    public ArrayList<Chipkaart> findAll() throws SQLException;
    public Chipkaart findByKaartNummer(int kaartNummer) throws SQLException;
    public ArrayList<Chipkaart> findByReiziger(Reiziger reiziger)throws SQLException;
    public Chipkaart save(Chipkaart chipkaart, Reiziger reiziger) throws SQLException;
    public Chipkaart update(Chipkaart chipkaart) throws SQLException;
    public Chipkaart delete(Chipkaart chipkaart) throws SQLException;
}
