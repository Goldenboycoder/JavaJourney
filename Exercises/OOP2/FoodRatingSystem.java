package Exercises.OOP2;

/*
 * Second solution using nested hashmap exceeded time limit 
 * This is mostly due to the need to search and compare each time highestRating is called
 * first approach was better hashmap with priorityqueue as value. HashMap<cuisine,PriorityQueue<FoodItem>>
 * we could explore the TreeSet approach too instead of priority queue
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
//import java.util.PriorityQueue;
//import java.util.stream.Collectors;
import java.util.Map.Entry;





class FoodItem{

    public int rating;
    public String name;
    public String cuisine;

    public FoodItem(int rating, String name, String cuisine){
        this.cuisine = cuisine;
        this.name = name;
        this.rating = rating;
    }
}
/*
class FoodItemComparator implements Comparator<FoodItem>{

    @Override
    public int compare(FoodItem o1, FoodItem o2) {

        if(o1.rating > o2.rating){
            return -1;
        }
        else if(o1.rating < o2.rating){
            return 1;
        }
        else{
            // equal
            // If there is a tie, return the item with the lexicographically smaller name.
            //Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
            if((int)o1.name.charAt(0) < (int)o2.name.charAt(0)){
                return -1;
            }
            else if((int)o1.name.charAt(0) > (int)o2.name.charAt(0)){
                return 1;
            }
            else{
                System.out.println(String.format("O1: %s  O2: %s",o1.name , o2.name));
                return 0;
            }
        }
        
    }
    
}
*/

class FoodItemComparator implements Comparator<Map.Entry<String,Integer>>{

    @Override
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        // TODO Auto-generated method stub
        if(o1.getValue() > o2.getValue()){
            return 1;
        }
        else if(o1.getValue() < o2.getValue()){
            return -1;
        }
        else{
            if((int)(o1.getKey()).charAt(0) < (int)(o2.getKey()).charAt(0)){
                return 1;
            }
            else if((int)(o1.getKey()).charAt(0) > (int)(o2.getKey()).charAt(0)){
                return -1;
            }
            else{
                System.out.println(String.format("O1: %s  O2: %s",o1.getKey() , o2.getKey()));
                return 0;
            }
        }
    }
    
}

class FoodRatings {

    //private HashMap<String,PriorityQueue<FoodItem>> allCuisines;
    private HashMap<String,HashMap<String,Integer>> allCuisines;
    //private HashMap<String,TreeSet<FoodItem>> allCuisines;
    //private HashMap<String,FoodItem> allFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        allCuisines = new HashMap<String,HashMap<String,Integer>>();
        //allFoods = new HashMap<String,FoodItem>();
        //allCuisines = new HashMap<String,TreeSet<FoodItem>>();
        initializeCuisines(foods, cuisines, ratings);
    }

    // helpers
    private void initializeCuisines(String[] foods, String[] cuisines, int[] ratings){
        for(int i =0;i<foods.length; i++){
            FoodItem item =  new FoodItem(ratings[i], foods[i],cuisines[i]);
            //allFoods.putIfAbsent(item.name, item);
            if(!allCuisines.containsKey(cuisines[i])){
                //PriorityQueue<FoodItem> newQueue = new PriorityQueue<FoodItem>(new FoodItemComparator());
                HashMap<String,Integer> newMap = new HashMap<String,Integer>();
                //newQueue.add(allFoods.get(item.name));
                newMap.put(item.name, item.rating);
                allCuisines.put(cuisines[i], newMap);
            }
            else{
                //allCuisines.get(cuisines[i]).add(allFoods.get(item.name));
                allCuisines.get(cuisines[i]).put(item.name,item.rating);
            }
        }
    }
    
    // actual api
    public void changeRating(String food, int newRating) {

        var keys = allCuisines.keySet().toArray();
        for(int i=0;i< keys.length; i++){
            
            if(allCuisines.get(keys[i]).containsKey(food)){
                /*FoodItem newF = allFoods.get(food);
                allCuisines.get(keys[i]).remove(allFoods.get(food));
                newF.rating = newRating;
                allFoods.put(food,newF);
                allCuisines.get(keys[i]).add(newF);*/
                allCuisines.get(keys[i]).put(food, newRating);
                break;
            }
        }
    }
    
   

    public String highestRated(String cuisine) {
        return allCuisines.get(cuisine).entrySet().stream().max(new FoodItemComparator()).get().getKey();
        
    }
}

class Solution2{
    public static void main(String args[]){
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(foodRatings.highestRated("korean")); // return "kimchi"
                                            // "kimchi" is the highest rated korean food with a rating of 9.
        System.out.println(foodRatings.highestRated("japanese")); // return "ramen"
                                            // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        System.out.println(foodRatings.highestRated("japanese")); // return "sushi"
                                            // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        System.out.println(foodRatings.highestRated("japanese")); // return "ramen"
                                            // Both "sushi" and "ramen" have a rating of 16.
                                            // However, "ramen" is lexicographically smaller than "sushi".
    }
}