package p3.Dao;

import p3.Domain.Chipkaart;
import p3.Domain.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductOracleDaoImpl extends OracleBaseDao implements ProductDao {

    public ProductOracleDaoImpl() throws SQLException{
        super();
    }

    public ArrayList<Product> findAll() throws SQLException{
        String query = "SELECT * FROM product";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        ResultSet result = pstmt.executeQuery();

        ArrayList<Product> products = new ArrayList<Product>();
        while(result.next()){
            Product p = new Product();
            p.setProductNummer(result.getInt("productnummer"));
            p.setNaam(result.getString("productnaam"));
            p.setBeschrijving(result.getString("beschrijving"));
            p.setPrijs(result.getDouble("prijs"));
            products.add(p);
        }
        result.close();
        pstmt.close();
        return products;
    }

    public Product findByProductNummer(int productNummer) throws SQLException {
        String query = "SELECT * FROM PRODUCT WHERE productnummer = ?";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setInt(1,productNummer);
        ResultSet result = pstmt.executeQuery();

        Product p = new Product();
        while(result.next()){
            p.setProductNummer(result.getInt("productnummer"));
            p.setNaam(result.getString("productnaam"));
            p.setBeschrijving(result.getString("beschrijving"));
            p.setPrijs(result.getDouble("prijs"));
        }
        result.close();
        pstmt.close();
        return p;
    }

    public ArrayList<Product> findByChipkaart(Chipkaart chipkaart) throws SQLException {
        String query = "SELECT * FROM ov_chipkaart_product WHERE  kaartnummer = ?";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setInt(1,chipkaart.getKaartNummer());
        ResultSet result = pstmt.executeQuery();

        ArrayList<Product> products = new ArrayList<Product>();
        while(result.next()){
            Product p = new Product();
            p = this.findByProductNummer(result.getInt("productnummer"));
            products.add(p);
        }
        result.close();
        pstmt.close();
        return products;
    }

    public Product save(Product product) throws SQLException{
        String query = "INSERT INTO product (productnummer, productnaam, beschrijving, prijs) VALUES (?,?,?,?)";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setInt(1,product.getProductNummer());
        pstmt.setString(2,product.getNaam());
        pstmt.setString(3,product.getBeschrijving());
        pstmt.setDouble(4,product.getPrijs());
        ResultSet result = pstmt.executeQuery();

        result.close();
        pstmt.close();
        return product;
    }

    public Product update(Product product) throws SQLException {
        String query = "UPDATE product SET productnummer = ?, productnaam = ?, beschrijving = ?, prijs = ? WHERE productnummer = ?";
        PreparedStatement pstmt = getConn().prepareStatement(query);

        pstmt.setInt(1,product.getProductNummer());
        pstmt.setString(2,product.getNaam());
        pstmt.setString(3,product.getBeschrijving());
        pstmt.setDouble(4,product.getPrijs());
        pstmt.setInt(5,product.getProductNummer());

        ResultSet result = pstmt.executeQuery();

        result.close();
        pstmt.close();
        return product;
    }

    public Product delete(Product product) throws SQLException {
        String query = "DELETE product WHERE productnummer = ?";
        PreparedStatement pstmt = getConn().prepareStatement(query);
        pstmt.setInt(1,product.getProductNummer());
        ResultSet result = pstmt.executeQuery();

        result.close();
        pstmt.close();
        return product;
    }
}
