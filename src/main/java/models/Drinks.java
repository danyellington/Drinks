package models;


public class Drinks {
    private String type;
    private int drinkId;


    public Drinks(String type, int drinkId){
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

        if (drinkId != drinks.drinkId) return false;
        return type != null ? type.equals(drinks.type) : drinks.type == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + drinkId;
        return result;
    }
}
