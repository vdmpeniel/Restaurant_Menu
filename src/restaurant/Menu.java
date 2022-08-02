package restaurant;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    private ArrayList<MenuItem> itemList = new ArrayList<>();
    private ZonedDateTime lastUpdated;

    public Menu(){}
    public Menu(ArrayList<MenuItem> itemList){
        this.itemList = itemList;
        lastUpdated = ZonedDateTime.now();
    }

    public List<MenuItem> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<MenuItem> itemList) {
        lastUpdated = ZonedDateTime.now();
        this.itemList = itemList;
    }

    public void addMenuItem(MenuItem newItem){
        if(itemList.contains(newItem)) { return; }
        itemList.add(newItem);
        updateModificationTime();
    }

    public void removeMenuItem_old(String itemName){
        ArrayList<MenuItem> resultingList = new ArrayList<>();
        for(MenuItem item : itemList){
            if(!item.getName().equals(itemName)){
                resultingList.add(item);
            }
        }
        itemList = resultingList;

        updateModificationTime();
    }

    public void removeMenuItem(String itemName){
        itemList = new ArrayList<>(
                itemList
                .stream()
                .filter(item -> !item.getName().equals(itemName))
                .collect(Collectors.toList())
        );
        updateModificationTime();
    }

    public Boolean isNew(String name){
        MenuItem foundItem = null;
        for(MenuItem item : itemList){
            if(item.getName().equals(name)) foundItem = item;
        }
        return (foundItem != null)? foundItem.isNew() : false;
    }

    public ZonedDateTime getLastUpdateDate(){
        return lastUpdated;
    }

    private void updateModificationTime(){
        lastUpdated = ZonedDateTime.now();
    }

    public void printAllItems(){
        itemList.forEach(item -> System.out.println(item));
    }

    public void printSingleItem(Integer index){
        System.out.println(itemList.get(index));
    }

    public boolean areItemsEqual(int indexA, int indexB){
        return itemList.get(indexA).equals(itemList.get(indexB));
    }


    public static void main(String[] args) {
        MenuItem bigMac = new MenuItem(
                "Big Mac",
                10,
                "Horrible for your health.",
                Category.MAIN_COURSE,
                false
        );

        MenuItem strawberryShake = new MenuItem(
                "Big Mac",
                10,
                "Horrible for your health.",
                Category.MAIN_COURSE,
                false
        );

        MenuItem[] items = {bigMac, strawberryShake};
        Menu myMenu = new Menu( new ArrayList<MenuItem>(Arrays.asList(items)) );
        System.out.println("First item:" + myMenu.getItemList().get(0).getName());

        MenuItem frenchFries = new MenuItem(
                "Fries",
                10,
                "Meh",
                Category.DESSERT,
                true
        );
        myMenu.addMenuItem(frenchFries);

        MenuItem frenchFries1 = new MenuItem(
                "Fries",
                10,
                "Meh",
                Category.DESSERT,
                true
        );
        myMenu.addMenuItem(frenchFries1);

        System.out.println("-------------------------------");
        System.out.println("*** Menu ***");
        myMenu.printAllItems();

        myMenu.removeMenuItem("Fries");
        System.out.println("-------------------------------");
        System.out.println("*** Menu ***");
        myMenu.printAllItems();

        System.out.println("-------------------------------");
        System.out.println("Is the Big Mac new: " + myMenu.isNew("Big Mac"));

        System.out.println("-------------------------------");
        System.out.println("Are items 0 and 1 equal?: " + myMenu.areItemsEqual(0, 1));
        System.out.println("-------------------------------");
    }
}
