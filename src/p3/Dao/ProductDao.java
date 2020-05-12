package p3.Dao;

import p3.Domain.Chipkaart;
import p3.Domain.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDao {
    public ArrayList<Product> findAll() throws SQLException;
    public Product findByProductNummer(int productNummer) throws SQLException;
    public ArrayList<Product> findByChipkaart(Chipkaart chipkaart) throws SQLException;
    public Product save(Product product) throws SQLException;
    public Product update(Product product) throws SQLException;
    public Product delete(Product product) throws SQLException;
}
