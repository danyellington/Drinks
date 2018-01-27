package dao;


import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDrinkDao implements DrinkDao {

    private final Sql2o sql2o;

    public Sql2oDrinkDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Drink drink) {
        String sql = "INSERT INTO Drinks (type) Values (:type)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(drink)
                    .executeUpdate()
                    .getKey();
            drink.setDrinkId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Drink> getAll() {
        String sql = "SELECT * FROM drinks";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Drink.class);
        }
    }


    @Override
    public Drink findById(int drinkId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM drinks WHERE id = :id")
                    .addParameter("id", drinkId)
                    .executeAndFetchFirst(Drink.class);
        }

    }
}
