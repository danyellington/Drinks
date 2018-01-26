package models;


public class NonAlcoholic {
    private String ingredients;
    private int id;


    public NonAlcoholic(String ingredients, int id){
        this.ingredients = ingredients;
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NonAlcoholic that = (NonAlcoholic) o;

        if (id != that.id) return false;
        return ingredients != null ? ingredients.equals(that.ingredients) : that.ingredients == null;
    }

    @Override
    public int hashCode() {
        int result = ingredients != null ? ingredients.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}
