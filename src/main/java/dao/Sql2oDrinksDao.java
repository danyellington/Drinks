package dao;


import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class Sql2oDrinksDao implements DrinksDao{

    private final Sql2o sql2o;

    public Sql2oDrinksDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Drinks drinks) {
        String sql = "INSERT INTO Drinks (type) Values (:type)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(drinks)
                    .executeUpdate()
                    .getKey();
            drinks.setDrinkId(id);
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
