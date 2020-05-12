package p2.Dao;

import p2.Domain.Reiziger;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ReizigerDao {
   public ArrayList<Reiziger> findAll() throws SQLException;
   public Reiziger findById(int id) throws SQLException;
   public ArrayList<Reiziger> findByGeboorteDatum(Date geboortedatum) throws SQLException;
   public Reiziger save(Reiziger reiziger) throws SQLException;
   public Reiziger update(Reiziger reiziger) throws SQLException;
   public Reiziger delete(Reiziger reiziger) throws SQLException;
}
