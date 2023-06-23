package coreJava;
import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int randomNumber = (int)(Math.random()*100)+1;
		boolean won=false;
		System.out.println("System have one genereated one number between 1 to 100");
		System.out.println("Will you try to guess it ");
		
		Scanner sc =new Scanner(System.in);
		
for(int i=10;i>0;i--) {
	
	System.out.println("You have only " + i + " turn to guess  ");
	
	int guess = sc.nextInt();
	if(randomNumber<guess) {
		System.out.println("Number is smaller then :" + guess);
	}
	
	else if(randomNumber>guess) {
		System.out.println("Number is greater then : " + guess);
	
	}
	
	else {
		won=true;
		break;
	
	
	}
	}


if(won) {
	System.out.println("congrulations .... You won !!!");
	System.out.println("You Guess the number");
}
else {
	System.out.println(" Try Again !");
	System.out.println("The Number was : " + randomNumber );
}

}
}
