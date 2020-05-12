package P1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReizigerOracleDaoImpl implements ReizigerDao {
    private List<Reiziger> alleReizigers = new ArrayList<>();

    public List<Reiziger> findAll() {
        return alleReizigers;
    }

    public List<Reiziger> findByGBdatum(String GBdatum) {
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        try {
            date = dateFormat.parse(GBdatum);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        ArrayList<Reiziger> result = new ArrayList();
        for (Reiziger r : alleReizigers) {
            if (r.getGeboortedatum().equals(date)) {
                result.add(r);
            }
        }
        return result;
    }

    public Reiziger save(Reiziger reiziger) {
        alleReizigers.add(reiziger);
        return reiziger;
    }

    public Reiziger update(Reiziger reiziger) {
        Reiziger persoon = null;
        for (Reiziger r : alleReizigers) {
            if (r.getReizigerID() == reiziger.getReizigerID()) {
                r.setVoorletters(reiziger.getVoorletters());
                r.setAchternaam(reiziger.getAchternaam());
                r.setTussenvoegsel(reiziger.getTussenvoegsel());
                r.setGeboortedatum(reiziger.getGeboortedatum());

                persoon = r;
            }
        }
        return persoon;
    }

    public boolean delete(Reiziger reiziger) {
        boolean deleted = false;
        for (Reiziger r : alleReizigers) {
            if (r.equals(reiziger)) {
                alleReizigers.remove(r);
                deleted = true;
            }
        }
        return deleted;
    }

}
