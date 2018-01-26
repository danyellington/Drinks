package dao;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;


public class Sql2oAlcoholicDao implements AlcoholicDao {

    private final Sql2o sql2o;

    public Sql2oAlcoholicDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Alcoholic alcoholic) {
        String sql = "INSERT INTO Alcoholic (alcoholType) Values (:alcoholType)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(alcoholic)
                    .executeUpdate()
                    .getKey();
            alcoholic.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Alcoholic> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM alcoholic")
                    .executeAndFetch(Alcoholic.class);
        }
    }

    @Override
    public Alcoholic findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM alcoholic WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Alcoholic.class);
        }


    }
}
