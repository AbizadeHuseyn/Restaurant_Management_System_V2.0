public class Drink extends Food {
    private String category;
    public Drink (String name, float price){
        super(name,price);
        this.category = "Drink:";

    }

    public String getCategory() {
        return category;
    }
}
