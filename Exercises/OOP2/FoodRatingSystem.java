
package Exercises.OOP2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class FoodItem {

    public int rating;
    public String name;
    public String cuisine;
    public String firstName= "";

    public FoodItem(int rating, String name, String cuisine) {
        this.cuisine = cuisine;
        this.name = name;
        this.rating = rating;

    }
}

// this is a comment
class FoodItemComparator implements Comparator<FoodItem> {

    @Override
    public int compare(FoodItem o1, FoodItem o2) {

        if (o1.rating > o2.rating) {
            return -1;
        } else if (o1.rating < o2.rating) {
            return 1;
        } else {
            // equal
            // If there is a tie, return the item with the lexicographically smaller name.
            // Note that a string x is lexicographically smaller than string y if x comes
            // before y in dictionary order, that is, either x is a prefix of y, or if i is
            // the first position such that x[i] != y[i], then x[i] comes before y[i] in
            // alphabetic order.
            if ((int) o1.name.charAt(0) < (int) o2.name.charAt(0)) {
                return -1;
            } else if ((int) o1.name.charAt(0) > (int) o2.name.charAt(0)) {
                return 1;
            } else {
                System.out.println(String.format("O1: %s  O2: %s", o1.name, o2.name));
                return 0;
            }
        }

    }

}

class FoodRatings {

    private HashMap<String, PriorityQueue<FoodItem>> allCuisines;
    private HashMap<String, FoodItem> allFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        allCuisines = new HashMap<String, PriorityQueue<FoodItem>>();
        allFoods = new HashMap<String, FoodItem>();
        initializeCuisines(foods, cuisines, ratings);
    }

    // helpers
    private void initializeCuisines(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            FoodItem item = new FoodItem(ratings[i], foods[i], cuisines[i]);
            allFoods.putIfAbsent(item.name, item);
            if (!allCuisines.containsKey(cuisines[i])) {
                PriorityQueue<FoodItem> newQueue = new PriorityQueue<FoodItem>(new FoodItemComparator());
                newQueue.add(allFoods.get(item.name));
                allCuisines.put(cuisines[i], newQueue);
            } else {
                allCuisines.get(cuisines[i]).add(allFoods.get(item.name));
            }
        }
    }

    // actual api
    public void changeRating(String food, int newRating) {

        var keys = allCuisines.keySet().toArray();
        for (int i = 0; i < keys.length; i++) {

            if (allCuisines.get(keys[i]).contains(allFoods.get(food))) {
                FoodItem newF = allFoods.get(food);
                allCuisines.get(keys[i]).remove(allFoods.get(food));
                newF.rating = newRating;
                allFoods.put(food, newF);
                allCuisines.get(keys[i]).add(newF);
                break;
            }
        }
    }

    public String highestRated(String cuisine) {
        return allCuisines.get(cuisine).peek().name;
    }
}