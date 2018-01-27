package models;


public class Drink {
    private String type;
    private int drinkId;


    public Drink(String type) {
        this.type = type;


    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drink drink = (Drink) o;

        if (drinkId != drink.drinkId) return false;
        return type != null ? type.equals(drink.type) : drink.type == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + drinkId;
        return result;
    }
}