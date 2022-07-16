 // Salary Estimater 
import java.util.*;
class salaryestimator{
	static  long salaryesti(long sal,int yr){

		long  fs=0 ,fs1 = 0;


		 for(int i=1;i<=yr;i++){
		 	 
		 	 fs = sal * 12;
		 	 fs1 = fs1 + fs;
		 	 sal = fs1 / 12 + fs1/100;

		 	}

		 return fs1;


	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the salary and  Its Year and its Growth :" );
		long salary = sc.nextLong();
		int year  = sc.nextInt();
		//int roi = sc.nextInt();
	    long final_salary = salaryesti(salary,year);
		System.out.println("The Final Bank Balance is :" + final_salary );
	}
}