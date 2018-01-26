package dao;

import models.Alcoholic;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;


public class Sql2oAlcoholicDaoTest {

    private Connection conn;
    private Sql2oAlcoholicDao alcoholicDao;
    private Sql2oNonAlcoholicDao nonAlcoholicDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        alcoholicDao = new Sql2oAlcoholicDao(sql2o);
        nonAlcoholicDao = new Sql2oNonAlcoholicDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public Alcoholic setupAlcoholic(){
        return new Alcoholic("this", 1, 2,"rum");
    }


    @Test
    public void setId(){
        Alcoholic testAlcoholic = setupAlcoholic();
        alcoholicDao.add(testAlcoholic);
        assertEquals(1, testAlcoholic.getId());
    }

}