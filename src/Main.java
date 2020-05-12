import P1.Reiziger;
import P1.ReizigerDao;
import P1.ReizigerOracleDaoImpl;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws SQLException {
        ReizigerDao dao = new ReizigerOracleDaoImpl();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

        try {
            Reiziger r1 = new Reiziger(1, "E", "", "Hosman", dateFormat.parse("15-03-1998"));
            Reiziger r2 = new Reiziger(2, "E", " ", "Geerman", dateFormat.parse("15-03-1998"));
            System.out.println(r1.getVoorletters() + " " + r1.getAchternaam());

            System.out.println(dao.save(r1));
            System.out.println(dao.save(r2));
            System.out.println(dao.findAll());
            System.out.println(dao.findByGBdatum("15-03-1998"));
            System.out.println(dao.update(r2));
            System.out.println(dao.findAll());
            System.out.println(dao.delete(r2));
            System.out.println(dao.findAll());
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        ;


    }
}
