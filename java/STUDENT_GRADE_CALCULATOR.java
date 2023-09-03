import java.util.Scanner;
public class STUDENT_GRADE_CALCULATOR {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
       System.out.println("enter the marks of subject1");
        int a= input.nextInt();
        System.out.println("enter the marks of subject2");
        int b= input.nextInt();
        System.out.println("enter the marks of subject3");
        int c= input.nextInt();
        System.out.println("enter the marks of subject4");
        int d= input.nextInt();
        System.out.println("enter the marks of subject5");
        int e= input.nextInt();
        float total= a+b+c+d+e;
        float percentage= total/500*100;
        System.out.println("Total Marks Out of 500 is: "+total);
//        System.out.println();
        System.out.println("Percentage of student is: "+percentage+"%");
        if (percentage<33)
        {
            System.out.println("You are failed!! Better luck next time.\n");
        } else if (percentage>=33 && percentage<60) {
            System.out.println("Grade C");
        } else if (percentage>=60 && percentage<75) {
            System.out.println("Grade B");
        }else {
            System.out.println("Grade A");
        }
    }
}
