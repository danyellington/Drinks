package dao;
import models.*;

import java.util.List;

public interface DrinkDao {


    void add(Drink drink);

    List<Drink> getAll();
    //List<NonAlcoholic> getAllNonAlcoholicDrink(int drinkId);

    Drink findById(int id);
//
//
//    static void add(NonAlcoholic testNonAlcoholic) {
//    }


}
