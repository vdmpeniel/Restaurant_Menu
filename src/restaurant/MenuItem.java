package restaurant;

import java.util.Objects;

public class MenuItem {
    private String name;
    private float price;
    private String description;
    private Category category;
    private Boolean isNew;

    public MenuItem(){}

    public MenuItem(
            String name,
            float price,
            String description,
            Category category,
            Boolean isNew
    ){
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.isNew = isNew;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean isNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }


    // Methods
    @Override
    public String toString(){
        return "Name: " + name + "\n" +
               "Price: " + price + "\n" +
               "Category: " + category.toString() + "\n" +
               "Is New: " + isNew;
    }

    @Override
    public boolean equals(Object o){
        return this.name == ((MenuItem) o).getName() && this.price == ((MenuItem) o).getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description, category, isNew);
    }
}

enum Category {
        DESSERT,
        APPETIZER,
        MAIN_COURSE
};