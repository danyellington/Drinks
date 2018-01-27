package models;


public class Drink {
    private String type;
    private int id;


    public Drink(String type) {
        this.type = type;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drink drink = (Drink) o;

        if (id != drink.id) return false;
        return type != null ? type.equals(drink.type) : drink.type == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}