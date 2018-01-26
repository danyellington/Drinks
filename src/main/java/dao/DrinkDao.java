package dao;
import models.*;

import java.util.List;

public interface DrinkDao {


    void add(Drink drinks);

    List<Drink> getAll();
    List<NonAlcoholic> getAllNonAlcoholicDrinks(int drinkId);

    Drink findById(int id);
//
//
//    static void add(NonAlcoholic testNonAlcoholic) {
//    }


}
