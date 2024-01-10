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
        StringBuilder builder = new StringBuilder();
        builder.append(this.name);
        builder.append("\t");
        builder.append(" | ");
        builder.append("\t");
        builder.append(this.description);
        builder.append("\t");
        builder.append(" | ");
        builder.append("\t");
        builder.append(this.price);
        return builder.toString();
    }

    public Item(String name, String description, Double price) {
        super(name, description);
        this.price = price;




    }
}
