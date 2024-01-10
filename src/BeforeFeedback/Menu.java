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
        StringBuilder builder = new StringBuilder();
        builder.append(this.name);
        builder.append("\t");
        builder.append(" | ");
        builder.append("\t");
        builder.append(this.description);
        return builder.toString();
    }
}
