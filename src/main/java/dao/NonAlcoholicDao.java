package dao;


import models.NonAlcoholic;

import java.util.List;

public interface NonAlcoholicDao {

    void add(NonAlcoholic nonAlcoholic);

    List<NonAlcoholic> getAll();

    NonAlcoholic findById(int id);

    void update(int id, int drinkId, String ingredients);

    void deleteById(int id);
}
