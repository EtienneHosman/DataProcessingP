package p3.Domain;

import p3.Dao.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ReizigerDao reizigerDao = new ReizigerOracleDaoImpl();
        ChipkaartDao chipkaartDao = new ChipkaartOracleDaoImpl();
        ProductDao productDao = new ProductOracleDaoImpl();
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

        Product p1 = productDao.findByProductNummer(1);
        System.out.println(p1.getNaam() + " " + p1.getBeschrijving());


        System.out.println(productDao.findByChipkaart(chipkaartDao.findByKaartNummer(90537)));
    }
}
