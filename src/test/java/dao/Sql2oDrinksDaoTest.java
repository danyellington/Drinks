package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class Sql2oDrinksDaoTest{

    private Connection conn;
    private Sql2oDrinksDao drinksDao;
    private Sql2oAlcoholicDao alcoholicDao;
    private Sql2oNonAlcoholicDao nonAlcoholicDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        drinksDao = new Sql2oDrinksDao(sql2o);
        alcoholicDao = new Sql2oAlcoholicDao(sql2o);
        nonAlcoholicDao = new Sql2oNonAlcoholicDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public Drinks setupDrinks(){
        return new Drinks("tropical");
    }


    @Test
    public void setId(){
        Drinks testDrinks = setupDrinks();
        drinksDao.add(testDrinks);
        assertEquals(1, testDrinks.getDrinkId());
    }

    @Test
    public void SetsId() throws Exception {
        Drinks drinks = setupDrinks();
        int originalDrinkId = drinks.getDrinkId();
        drinksDao.add(drinks);
        assertNotEquals(originalDrinkId, drinks.getDrinkId());
    }
//
//    @Test
//    public void drinksReturnedFromGetAll() throws Exception {
//        Drinks testDrinks = setupDrinks();
//        Drinks testDrinks2 = setupDrinks();
//        drinksDao.add(testDrinks);
//        drinksDao.add(testDrinks2);
//        assertEquals(2, drinksDao.getAll().size());
//    }

}

