package com.company;

import java.util.Random;

public class Mine extends Cell {

    public Mine(){
        mine =true;
    }

    public static void insertMine(PlayingField field){
        Random rnd=new Random();
        for (int i = 0; i <field.size;) {
            int ni=rnd.nextInt(field.size);
            int nj=rnd.nextInt(field.size);
            if(field.cells[ni][nj].mine ==false){
                field.cells[ni][nj]=new Mine();

                fieldCounting(ni, nj, field);

                i++;
            }
        }
    }

    public static void fieldCounting(int ni, int nj, PlayingField field){
        if(ni==0){
            if(nj==0){
                //ni és nj 0
                field.cells[ni][nj+1].number +=1;
                field.cells[ni+1][nj+1].number +=1;
                field.cells[ni+1][nj].number +=1;
            }
            else if(nj==field.size-1)
            {
                //ni 0 és nj size
                field.cells[ni][nj-1].number +=1;
                field.cells[ni+1][nj-1].number +=1;
                field.cells[ni+1][nj].number +=1;
            }
            else  {
                //ni 0
                field.cells[ni][nj+1].number +=1;
                field.cells[ni][nj-1].number +=1;
                field.cells[ni+1][nj-1].number +=1;
                field.cells[ni+1][nj].number +=1;
                field.cells[ni+1][nj+1].number +=1;
            }

        }
        else if(ni==field.size-1){
            if(nj==0){
                //ni size nj 0
                field.cells[ni-1][nj].number +=1;
                field.cells[ni-1][nj+1].number +=1;
                field.cells[ni][nj+1].number +=1;
            }
            else if(nj==field.size-1)
            {
                //ni és nj size
                field.cells[ni][nj-1].number +=1;
                field.cells[ni-1][nj-1].number +=1;
                field.cells[ni-1][nj].number +=1;
            }
            else {
                //ni size
                field.cells[ni][nj-1].number +=1;
                field.cells[ni-1][nj-1].number +=1;
                field.cells[ni-1][nj].number +=1;
                field.cells[ni-1][nj+1].number +=1;
                field.cells[ni][nj+1].number +=1;
            }

        }
        else {
            if(nj==0){
                //nj 0
                field.cells[ni-1][nj].number +=1;
                field.cells[ni-1][nj+1].number +=1;
                field.cells[ni][nj+1].number +=1;
                field.cells[ni+1][nj].number +=1;
                field.cells[ni+1][nj+1].number +=1;
            }
            else if(nj==field.size-1)
            {
                // nj size
                field.cells[ni-1][nj-1].number +=1;
                field.cells[ni-1][nj].number +=1;
                field.cells[ni][nj-1].number +=1;
                field.cells[ni+1][nj-1].number +=1;
                field.cells[ni+1][nj].number +=1;
            }
            else {
                //nincs a szélén
                field.cells[ni-1][nj-1].number +=1;
                field.cells[ni-1][nj].number +=1;
                field.cells[ni-1][nj+1].number +=1;
                field.cells[ni][nj-1].number +=1;
                field.cells[ni][nj+1].number +=1;
                field.cells[ni+1][nj-1].number +=1;
                field.cells[ni+1][nj].number +=1;
                field.cells[ni+1][nj+1].number +=1;
            }
        }
    }

}
