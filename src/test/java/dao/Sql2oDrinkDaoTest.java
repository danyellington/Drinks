package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class Sql2oDrinkDaoTest {

    private Connection conn;
    private Sql2oDrinkDao drinkDao;
    private Sql2oAlcoholicDao alcoholicDao;
    private Sql2oNonAlcoholicDao nonAlcoholicDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        drinkDao = new Sql2oDrinkDao(sql2o);
        alcoholicDao = new Sql2oAlcoholicDao(sql2o);
        nonAlcoholicDao = new Sql2oNonAlcoholicDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public Drink setupDrinks(){
        return new Drink("tropical");
    }


    @Test
    public void setId(){
        Drink testDrinks = setupDrinks();
        drinkDao.add(testDrinks);
        assertEquals(1, testDrinks.getDrinkId());
    }

    @Test
    public void SetsId() throws Exception {
        Drink drink = setupDrinks();
        int originalDrinkId = drink.getDrinkId();
        drinkDao.add(drink);
        assertNotEquals(originalDrinkId, drink.getDrinkId());
    }

    @Test
    public void drinksReturnedFromGetAll() throws Exception {
        Drink testDrinks = setupDrinks();
        Drink testDrinks2 = setupDrinks();
        drinkDao.add(testDrinks);
        drinkDao.add(testDrinks2);
        assertEquals(2, drinkDao.getAll().size());
    }

}

