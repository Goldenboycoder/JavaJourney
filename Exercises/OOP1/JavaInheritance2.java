package Exercises.OOP1;

class Arithmetic{

    public int add(int a,int b){
        return a+b;
    }
}

class Adder extends Arithmetic{}

class Solution{

    public static void main(String[] args) {
        Adder adder = new Adder();
        System.out.println(String.format("My superclass is: %s", Adder.class.getSuperclass().getSimpleName()));
        System.out.print(String.format("%d %d %d",adder.add(10, 32),adder.add(12, 1),adder.add(19, 1)));
    }
}
