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
            drink.setId(id);
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
    public Drink findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM drinks WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Drink.class);
        }

    }

    @Override
    public void update(int id, String type){
        String sql = "UPDATE drinks SET type = :type, id = :id WHERE id=:id"; //raw sql
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("type", type)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from drinks WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
