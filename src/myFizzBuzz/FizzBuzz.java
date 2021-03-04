package myFizzBuzz;

public class FizzBuzz {

    public String fizzBuzz(int number){
        if(isMultiple(number,3) && isMultiple(number,5)) return "FizzBuzz";
//        return "1";
//        if(number ==3) return "Fizz";
//        if((number%3)==0) return "Fizz";
        if(isMultiple(number, 3)) return "Fizz";
//        if((number%5)==0) return "Buzz";
        if(isMultiple(number,5)) return "Buzz";
        return String.valueOf(number);
    }
    private boolean isMultiple(int number, int base){
        return ((number % base) ==0);
    }
}

