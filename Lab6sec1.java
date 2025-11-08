
import java.util.Random;
public class Main {

    //Scenario 1:
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }


    public static int[] resize(int[] oldroster,int newsize){
        int[] newroster=new int[newsize];
        for(int i=0;i<oldroster.length;i++){
            newroster[i]=oldroster[i];
        }
        return newroster;
    }
    //Scenario 2:
    public static int[] rotatedRight(int arr[]){
        int[] rotated= new int[arr.length];
        rotated[0]= arr[arr.length-1];
        for(int i=0;i<arr.length-1;i++){
            rotated[i+1]=arr[i];
        }
        return rotated;
    }


    public static void main(String[] args){
        //Scenario 0:
        int[] myArr = {4, 8, 15, 16, 23, 42};
        //a. What is the length of myArr? 6
        //b. What is the value of the first element? 1
        //c. What is the index value of the last element? 5
        //d. What is the value of the third element? 15
        //e. What is the value of myArr[3]? 16
        //f. If we try to access myArr[10], what happens? ArrayIndex out of bounds error

        //2
        System.out.println( "myArr length is: "+myArr.length);
        System.out.println("Value of the first element is "+myArr[0]);
        System.out.println("İndex of the last element is 5");
        System.out.println("Value of the third element is : "+myArr[2]);
        System.out.println("Value of myArr[3] : "+myArr[3]);
        /* f. Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 6
        	at Main.main(Main.java:17)     because array is not include index 10. */

        //Scenario 1:
        int oldSize = 20;
        int[] oldroster = new int[oldSize];
        for (int i = 0; i < oldroster.length; i++) {
            oldroster[i] = 1000 + i;
        }


        System.out.print("Old roster is: ");
        printArray(oldroster);

        int newsize = 42;
        int[] newroster = resize(oldroster, newsize);

        System.out.print("New roster is: ");
        printArray(newroster);

        //Scenario 2:
        Random rand=new Random(System.currentTimeMillis());
        int size=rand.nextInt(11)+10;
        int[] numbers=new int[size];
        for(int i=0;i<numbers.length;i++){
            numbers[i]=rand.nextInt(100);
        }
        System.out.println("Orginal array:");
        printArray(numbers);

        System.out.println("Rotated array");
        int[] rotated=rotatedRight(numbers);
        printArray(rotated);

        //Scenario 3:
         long tottaldays=1000000;
         String[] weathertypes={"Sunny", "Cloudy", "Rainy", "Stormy"};
         String[] probability=new String[100];
         int index=0;
         for(int i=0;i<40;i++){
             probability[index++]="Sunny";
         }
         for(int i=0;i<30;i++){
             probability[index++]="Cloudy";
         }
         for(int i=0;i<20;i++){
             probability[index++]="Rainy";
         }
         for (int i=0;i<10;i++){
             probability[index++]="Stormy";
         }
         int sunnycount=0;
         int cloudycount=0;
         int rainycount=0;
         int stormycount=0;
         for (int i=0;i<tottaldays;i++){
             int r=rand.nextInt(100);
             String today=probability[r];

             switch (today){
                 case "Sunny":
                     sunnycount+=1;
                     break;
                 case "Cloudy":
                     cloudycount+=1;
                     break;
                 case "Rainy":
                     rainycount+=1;
                     break;
                 case "Stormy":
                     stormycount+=1;
                     break;


             }
         }
        System.out.println("Simulation results after " + tottaldays + " days:");

        double sunnyPct = sunnycount * 100.0 / tottaldays;
        double cloudyPct = cloudycount * 100.0 / tottaldays;
        double rainyPct = rainycount * 100.0 / tottaldays;
        double stormyPct = stormycount * 100.0 / tottaldays;

        System.out.printf("Sunny : %7d times (%5.2f%%)\n", sunnycount, sunnyPct);
        System.out.printf("Cloudy: %7d times (%5.2f%%)\n", cloudycount, cloudyPct);
        System.out.printf("Rainy : %7d times (%5.2f%%)\n", rainycount, rainyPct);
        System.out.printf("Stormy: %7d times (%5.2f%%)\n", stormycount, stormyPct);

        //Scenario 4:
        int sizes=30;
        int[] array4= new int[sizes];
        for(int i=0;i<sizes;i++){
            array4[i]=rand.nextInt(101);
        }
        printArray(array4);

        int peakcount=0;
        int tallestpeak=0;
        for(int i=1;i<sizes-1;i++){
            if(array4[i]>array4[i+1] && array4[i]>array4[i-1]){
                System.out.print(array4[i]+" ");
                peakcount+=1;
                if(array4[i]>tallestpeak){
                    tallestpeak=array4[i];
                }

            }
        }
        System.out.println();
        System.out.println("Total number of peaks: " + peakcount);
        System.out.println("Tallest peak: "+tallestpeak);

        //BONUS!!!
        int students=5;
        int quizes=4;
        int[][] scores=new int[students][quizes];
        for(int i=0;i<students;i++){
            for (int j=0;j<quizes;j++){
                scores[i][j]=rand.nextInt(101);
            }
        }//Create Table
        System.out.println("Scores Table:");
        for(int i=0;i<students;i++){
            for (int j=0;j<quizes;j++){
                System.out.printf("%4d",scores[i][j]);
            }
            System.out.println();
        }
        System.out.println("Student Averages:");
        for(int i=0;i<students;i++){
            int sum=0;
            for (int j=0;j<quizes;j++){
                sum+=scores[i][j];
            }
            double avg=sum/(double)quizes;
            System.out.printf("Student %d: %.2f\n",i,avg);
        }
        System.out.println("Quiz Averages");
        for (int j=0;j<quizes;j++){
            int sumj=0;
            for (int i=0;i<students;i++){
                sumj+=scores[i][j];
            }
            double average=sumj/(double)students;
            System.out.printf("Quiz %d: %.2f\n",j,average);

        }
        //higher score
        int maxScore=0;
        int maxStudent=0;
        int maxQuiz=0;
        for(int i=0;i<students;i++){
            for (int j=0;j<quizes;j++){
                if(scores[i][j]>maxScore){
                    maxScore=scores[i][j];
                    maxStudent=i;
                    maxQuiz=j;
                }

            }
        }
        System.out.println("Highest Score:");
        System.out.println("Score: " + maxScore + " at (Student " + maxStudent + ", Quiz " + maxQuiz + ")");















    }

}