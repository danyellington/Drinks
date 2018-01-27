package dao;


import models.Alcoholic;
import models.NonAlcoholic;

import java.util.List;

public interface AlcoholicDao {

    void add(Alcoholic alcoholic);

    Alcoholic findById(int id);

    List<Alcoholic> getAll();

    void update(String alcoholType, int id);

    void deleteById(int id);

}
