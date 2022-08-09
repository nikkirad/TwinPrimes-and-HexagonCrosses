//think of this as the application
package application;

public class TwinPrimes {
    
    public static Boolean isTwinPrimes(int num1, int num2) {
    	//first we must check if both numbers are prime
        if ((Prime.isPrime(num1)) && (Prime.isPrime(num2))) {
        	//if they are, then we must check that the difference between the two numbers is 2
            if ((num2 - num1) == 2) {
            	//if both hold true, then the numbers are twin primes
                return true;
            }
        }
        //if both numbers are not prime and/or do not have a difference of 2, then they are not twin primes
        return false;
    }
    
}
