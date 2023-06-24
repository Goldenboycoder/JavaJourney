package Exercises.OOP1;

class Sports{
    String getName(){
        return "Generic Sports";
    }
    void getNumberOfTeamMembers(){
        System.out.println( "Each team has n players in " + getName() );
    }
}

class Soccer extends Sports{
    @Override
    String getName(){
        return "Soccer Class";
    }

    @Override
    void getNumberOfTeamMembers(){
        System.out.println("Each team has 11 players in "+this.getName());
    }
}

class Solution{

    public static void main(String[] args) {
        Sports sports = new Sports();
        System.out.println(sports.getName());
        sports.getNumberOfTeamMembers();
        Soccer soccer = new Soccer();
        System.out.println(soccer.getName());
        soccer.getNumberOfTeamMembers();
    }
}