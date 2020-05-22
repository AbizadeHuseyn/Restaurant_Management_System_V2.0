public class Salad extends Food {
    private String category;
    public Salad (String name, float price){
        super(name,price);
        this.category = "Drink";

    }

    public String getCategory() {
        return category;
    }
}
