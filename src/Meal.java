public class Meal extends Food {
    private String category;
    public Meal (String name, float price){
        super(name,price);
        this.category = "Meal:";

    }

    public String getCategory() {
        return category;
    }
}
