public class Food {
    private float price;
    private String name;


    public Food(String name, float price) {
        this.price = price;
        this.name = name;

    }

    public float getPrice() {
        return price;
    }


    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
