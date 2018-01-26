package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;


public class Sql2oNonAlcoholicDaoTest {

    private Connection conn;
    private Sql2oAlcoholicDao alcoholicDao;
    private Sql2oNonAlcoholicDao nonAlcoholicDao;
    private Sql2oDrinksDao drinksDao;

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

    public NonAlcoholic setupNonAlcoholic(){
        return new NonAlcoholic("juice", 1);
    }


    @Test
    public void setId(){
        NonAlcoholic testNonAlcoholic = setupNonAlcoholic();
        nonAlcoholicDao.add(testNonAlcoholic);
        assertEquals(1, testNonAlcoholic.getNaId());
    }

//    @Test
//    public void nonAlcoholicDrinksReturnedFromGetAll() throws Exception {
//        NonAlcoholic testNonAlcoholic = setupNonAlcoholic();
//        NonAlcoholicDao.add(testNonAlcoholic);
//        assertEquals(1, nonAlcoholicDao.getAll().size());
//    }

    @Test
    public void returnId() throws Exception {
        NonAlcoholic nonAlcoholic = setupNonAlcoholic();
        int naId = nonAlcoholic.getDrinkId();
        nonAlcoholicDao.add(nonAlcoholic);
        assertEquals(naId, nonAlcoholicDao.findById(nonAlcoholic.getNaId()).getDrinkId());
    }


}