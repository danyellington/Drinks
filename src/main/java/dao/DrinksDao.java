package dao;
import models.*;

import java.util.List;

public interface DrinksDao {


    void add (Drinks drinks);
    List<Drinks> getAll();

    Drinks findById(int drinkId);




}
