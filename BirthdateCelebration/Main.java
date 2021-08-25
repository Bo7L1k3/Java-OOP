package BirthdateCelebration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Birthable> dataList = new ArrayList<>();

        String command = scan.nextLine();

        while (!command.equals("End")){

            String [] data = command.split("\\s+");


            switch (data[0]){
                case "BirthdateCelebration.FoodShortage.Citizen":
                    String date = data[4].trim();
                    dataList.add(new Citizen(data[1], Integer.parseInt(data[2]), data[3], date));
                    break;
                case "BirthdateCelebration.Pet":
                    String petDate = data[2].trim();
                    dataList.add(new Pet(data[1], petDate));
                    break;
            }
            command = scan.nextLine();
        }
        String year = scan.nextLine();

        boolean isAnyFound = false;
        for (Birthable type : dataList) {
            if(type.getBirthDate().endsWith(year)){
                System.out.println(type.getBirthDate());
                isAnyFound = true;
            }
        }
        if(!isAnyFound){
            System.out.println("<no output>");
        }
    }
}
