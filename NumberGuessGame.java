import java.util.Scanner;
import java.util.Random;
public class NumberGuessGame{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
Random rand = new Random();
int numToGuess = rand.nextInt(100)+1;
int guess;
int attempts = 0;
System.out.println("Welcome to the Number Guessing Game:");
System.out.println("Guess a number between 1 and 100:");
do{
guess=sc.nextInt();
attempts++;
if(guess < numToGuess){
System.out.println("Too low! Try again:");
}
else if(guess > numToGuess){
System.out.println("Too high! Try again:");
}
else{
System.out.println("Congratulation! You guessed it correctly in "+attempts +" attempts.");
}
}
while(guess!=numToGuess);
sc.close();
}
}