package Exercises.OOP1;


abstract class Arithmetic{


    abstract int add(int a,int b);
}

class Adder extends Arithmetic{

    public Adder(){

    }

    public int add(int a,int b){
        return a+b;
    }
}

class Solution{
    
    public static void main(String[] args) {
        Adder adder = new Adder();
        System.out.print(adder.add(1, 1));
    }
}
