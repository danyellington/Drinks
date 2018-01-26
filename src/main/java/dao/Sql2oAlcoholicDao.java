package dao;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;


public class Sql2oAlcoholicDao implements AlcoholicDao {

    private final Sql2o sql2o;

    public Sql2oAlcoholicDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Alcoholic alcoholic) {

    }

    @Override
    public Alcoholic findById(int id) {
        return null;
    }



}
