package models;


public class Alcoholic extends NonAlcoholic {
    private String alcoholType;
    private int id;
    private int drinkId;


    public Alcoholic(String ingredients, int id, int drinkId, String alcoholType) {
        super(ingredients, id);
        this.alcoholType = alcoholType;
        this.drinkId = drinkId;


    }

    public String getAlcoholType() {
        return alcoholType;
    }

    public void setAlcoholType(String alcoholType) {
        this.alcoholType = alcoholType;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getDrinkId() {
        return drinkId;
    }

    @Override
    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Alcoholic alcoholic = (Alcoholic) o;

        if (id != alcoholic.id) return false;
        if (drinkId != alcoholic.drinkId) return false;
        return alcoholType != null ? alcoholType.equals(alcoholic.alcoholType) : alcoholic.alcoholType == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (alcoholType != null ? alcoholType.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + drinkId;
        return result;
    }
}