public class Table {

    private float bill;
    private String status;
    private String meals;
    private int number;

    public Table(int number) {
        this.bill = 0;
        this.status = "Empty";
        this.meals = "";
        this.number = number;
    }


    public void deleteOrder(Table table) {
        setBill(0);
        setMeals("");
        setStatus("Empty");
    }


    public float getBill() {
        return bill;
    }

    public void setBill(float bill) {
        this.bill = bill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public int getNumber() {
        return number;
    }
}
