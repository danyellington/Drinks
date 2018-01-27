package models;


public class NonAlcoholic {
    private String ingredients;
    private int id;
    private int drinkId;


    public NonAlcoholic(String ingredients, int drinkId) {
        this.ingredients = ingredients;
        this.drinkId = drinkId;



    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        NonAlcoholic that = (NonAlcoholic) o;

        if (id != that.id) return false;
        if (drinkId != that.drinkId) return false;
        return ingredients != null ? ingredients.equals(that.ingredients) : that.ingredients == null;
    }

    @Override
    public int hashCode() {
        int result = ingredients != null ? ingredients.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + drinkId;
        return result;
    }
}