package dao;


import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNonAlcoholicDao implements NonAlcoholicDao {

    private final Sql2o sql2o;

    public Sql2oNonAlcoholicDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(NonAlcoholic NonAlcoholic) {
        String sql = "INSERT INTO NonAlcoholic (ingredients) Values (:ingredients)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(NonAlcoholic)
                    .executeUpdate()
                    .getKey();
            NonAlcoholic.setNaId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<NonAlcoholic> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM nonAlcoholic")
                    .executeAndFetch(NonAlcoholic.class);
        }
    }

    @Override
    public NonAlcoholic findById(int id) {
        String sql = "SELECT * FROM nonAlcoholic WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(NonAlcoholic.class);
        }
    }
}
