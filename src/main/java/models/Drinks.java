package models;


public class Drinks {
    private String type;
    private int drinkId;


    public Drinks(String type){
        this.type = type;
        this.drinkId = drinkId;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
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

        Drinks drinks = (Drinks) o;

        return type != null ? type.equals(drinks.type) : drinks.type == null;
    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }
}
