package com.company;

public class PlayingField {

    public int size;
    public Cell[][] cells;
    public boolean win =true;
    int shotCount =0;

    public PlayingField(int size){
        this.size=size;
        this.cells =new Cell[size][size];
    }


    public void upload(){
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j]=new Cell();
            }
        }
    }

    public void showReal(){
        System.out.println("MINESWEEPER");
        for (int k = 0; k < size; k++) {
            System.out.print(" ---");
        }
        System.out.println();
        for (int i = 0; i < size ; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                if(cells[i][j].mine ==false){
                    if(cells[i][j].number ==0){
                        System.out.print('-' + " | ");
                    }
                    else {
                        System.out.print((cells[i][j]).number + " | ");
                    }
                }
                else {
                    System.out.print('x'+" | ");
                }
            }
            System.out.println();
            for (int k = 0; k < size; k++) {
                System.out.print(" ---");
            }
            System.out.println();
        }
    }


    public void show(){
        System.out.println("MINESWEEPER");
        for (int k = 0; k < size; k++) {
            System.out.print(" ---");
        }
        System.out.println();
        for (int i = 0; i < size ; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(' ' + " | ");
            }
            System.out.println();
            for (int k = 0; k < size; k++) {
                System.out.print(" ---");
            }
            System.out.println();
        }
    }


    public void showCovered(int row, int column){

        exploreEmpties(row, column, cells);
        System.out.println("MINESWEEPER");
        for (int k = 0; k < size; k++) {
            System.out.print(" ---");
        }
        System.out.println();
        for (int i = 0; i < size ; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                if(cells[i][j].mine ==false){
                    if(cells[i][j].number ==0){

                        if(cells[i][j].visible ==true){
                            System.out.print("-" + " | ");
                        }
                        else {
                            System.out.print(' ' + " | ");
                        }
                    }
                    else {

                        if(cells[i][j].visible ==true){
                            System.out.print((cells[i][j]).number + " | ");
                        }
                        else {
                            System.out.print(' ' + " | ");
                        }

                    }
                }
                else {
                    if(cells[row][column].mine == cells[i][j].mine){
                        System.out.print('x'+" | ");
                        win =false;
                    }
                    else {
                        System.out.print(' '+" | ");
                    }
                }
            }
            System.out.println();
            for (int k = 0; k < size; k++) {
                System.out.print(" ---");
            }
            System.out.println();
                }

    }

    private void exploreEmpties(int row, int col, Cell[][] table) {
        if(row>=size || col>=size){
            return;
        }
        if(row<0 || col<0){
            return;
        }
        if(table[row][col].visible ==true){
            return;
        }

        table[row][col].visible =true;
        shotCount +=1;

        if(table[row][col].number !=0){
            return;
        }

        if(table[row][col].mine ==true){
            return;
        }


        exploreEmpties(row-1, col-1, table);
        exploreEmpties(row-1, col, table);
        exploreEmpties(row-1, col+1, table);
        exploreEmpties(row, col-1, table);
        exploreEmpties(row, col+1, table);
        exploreEmpties(row+1, col-1, table);
        exploreEmpties(row+1, col, table);
        exploreEmpties(row+1, col+1, table);
    }


}






