import com.google.gson.Gson;
import dao.Sql2oAlcoholicDao;
import dao.Sql2oDrinkDao;
import dao.Sql2oNonAlcoholicDao;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        Sql2oDrinkDao drinkDao;
        Sql2oNonAlcoholicDao nonAlcoholicDao;
        Sql2oAlcoholicDao alcoholicDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        drinkDao = new Sql2oDrinkDao(sql2o);
        nonAlcoholicDao = new Sql2oNonAlcoholicDao(sql2o);
        alcoholicDao = new Sql2oAlcoholicDao(sql2o);
        conn = sql2o.open();


    }
}
