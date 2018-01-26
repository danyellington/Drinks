package models;


public class Alcoholic extends NonAlcoholic {
    private String alcoholType;


    public Alcoholic(String ingredients, String alcoholType) {
        super(ingredients);
        this.alcoholType = alcoholType;
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

        return alcoholType != null ? alcoholType.equals(alcoholic.alcoholType) : alcoholic.alcoholType == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (alcoholType != null ? alcoholType.hashCode() : 0);
        return result;
    }
}
