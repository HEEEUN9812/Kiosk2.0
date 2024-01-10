package BeforeFeedback;

public class Item extends Menu{

    Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String builder = this.name +
                "\t" +
                " | " +
                "\t" +
                "W " +
                this.price +
                "\t" +
                " | " +
                "\t" +
                this.description;
        return builder;
    }

    public Item(String name, String description, Double price) {
        super(name, description);
        this.price = price;




    }
}
