//used in TwinPrimes.java
package application;

public class Prime {
    
	//boolean method that checks whether the number given is prime or not
    public static Boolean isPrime(int num) {
        for (int i = 2; i<num/2; i++) {
        	//if the number is divisible by any number between 2 and half of the number, then it is not prime
            if (num%i == 0) {
                return false;
            }
        }
        //if it is not divisible by any number between 2 and half of the number, then it is prime
        return true;
    }
}
