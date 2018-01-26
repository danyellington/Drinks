package models;


public class Alcoholic extends NonAlcoholic {
    private String alcoholType;
    private int id;


    public Alcoholic(String ingredients, String alcoholType, int id) {
        super(ingredients, id);
        this.alcoholType = alcoholType;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getAlcoholType() {
        return alcoholType;
    }

    public void setAlcoholType(String alcoholType) {
        this.alcoholType = alcoholType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Alcoholic alcoholic = (Alcoholic) o;

        if (id != alcoholic.id) return false;
        return alcoholType != null ? alcoholType.equals(alcoholic.alcoholType) : alcoholic.alcoholType == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (alcoholType != null ? alcoholType.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
