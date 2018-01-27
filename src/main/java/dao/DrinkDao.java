package dao;
import models.*;

import java.util.List;

public interface DrinkDao {


    void add(Drink drink);

    List<Drink> getAll();

    Drink findById(int id);

    void update(int id, String type);

    void deleteById(int id);


}
