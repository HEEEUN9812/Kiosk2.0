package BeforeFeedback;

public class Menu {

    String name;
    String description;

    public Menu(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        String builder = this.name +
                "\t" +
                " | " +
                "\t" +
                this.description;
        return builder;
    }
}
