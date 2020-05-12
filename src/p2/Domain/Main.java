package p2.Domain;

import p2.Dao.ChipkaartDao;
import p2.Dao.ChipkaartOracleDaoImpl;
import p2.Dao.ReizigerDao;
import p2.Dao.ReizigerOracleDaoImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ReizigerDao reizigerDao = new ReizigerOracleDaoImpl();
        ChipkaartDao chipkaartDao = new ChipkaartOracleDaoImpl();
//
//        Reiziger r1 = reizigerDao.findById(1);
//
//        System.out.println(r1.getVoorletters() +" "+ r1.getAchternaam());
//
//        r1.setAchternaam("Bouwer");
//
//        reizigerDao.update(r1);
//
//        r1 = reizigerDao.findById(1);
//
//        System.out.println(r1.getVoorletters() + " " + r1.getAchternaam());

        System.out.println(chipkaartDao.findAll());

    }
}
