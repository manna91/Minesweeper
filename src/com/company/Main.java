package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner;
        PlayingField field;
        int n, number;
        int numCol, numRow;
        boolean flag = false;


        try {
                System.out.println("What size should be the playing cells?");
                scanner = new Scanner(System.in);
                do {
                    System.out.println("Enter a number greater than two!");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Enter a number greater than two!");
                        scanner.next();
                    }
                    number = scanner.nextInt();
                } while (number < 3 && number > 100);

                n = number;
                field=new PlayingField(n);
                field.upload();
                Mine.insertMine(field);
                field.show();



                do {
                System.out.println("Enter the line number where you want to shoot!");
                scanner=new Scanner(System.in);
                do {
                    System.out.println("The number must be between 1 and " +  n + "!");
                    while (!scanner.hasNextInt()) {
                        System.out.println("You should enter a number!");
                        scanner.next();
                    }
                    numRow = scanner.nextInt();
                }while (numRow<0 || numRow>n);
                int row = numRow;

                System.out.println("Enter the column number where you want to shoot!");
                scanner=new Scanner(System.in);
                do {
                    System.out.println("The number must be between 1 and " +  n + "!");
                    while (!scanner.hasNextInt()) {
                        System.out.println("You should enter a number!");
                        scanner.next();
                    }
                    numCol = scanner.nextInt();
                }while (numCol<0 || numCol>n);

                int column = numCol;
                field.showCovered(row-1, column-1);
                if(field.shotCount ==n*n-n){
                    System.out.println("You win!");
                    System.exit(0);
                }
            }
            while (field.win);

            System.out.println("Game over!");
            System.exit(0);

        }
        catch (Exception e){
            System.out.println("Error: " + e.toString());
        }


    }
}
