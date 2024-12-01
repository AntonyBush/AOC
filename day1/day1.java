import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Day1 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        try {
            File file = new File("day.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] numbers = line.trim().split("\\s+");
                if(numbers.length == 2){
                    list1.add(Integer.parseInt(numbers[0]));
                    list2.add(Integer.parseInt(numbers[1]));
                }
            }

            sc.close();
            Collections.sort(list1);
            Collections.sort(list2);
            int totalDist=0;
            for(int i=0;i<list1.size();i++){
                // Part 1
                // totalDist+=Math.abs(list1.get(i)-list2.get(i));

                // Part 2
                int num = list1.get(i);
                int counter = 0;
                for(int j=0; j<list2.size(); j++){
                    if (num==list2.get(j)) counter++;
                }
                totalDist+=(num*counter);
            }
            System.out.println("Total distance is "+ totalDist);
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("FILE NOT FOUND");
        }
    }
}