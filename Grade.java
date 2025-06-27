package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total subjects : ");
        int a = sc.nextInt();
        float total = 0;
        for(int i = 0;i<a;i++){
            float b = 0;
            System.out.println("Enter the marks obtained in Subject " + (i+1));
            b = sc.nextFloat();
            total = total+b;
        }
        float percentage  = total/a;
        String c ;
        if(percentage >= 95){
             c = "A+";
        }
        else if(percentage > 90){
            c = "A";
        }
        else if(percentage > 80){
            c = "B+";
        }
        else if(percentage > 70){
            c = "B";
        }
        else if(percentage >60){
            c = "C";
        }
        else if(percentage > 50){
            c = "D";
        }
        else if(percentage > 40){
            c = "E";
        }
        else {
            c = "F";
        }
        System.out.println("Total marks obtained : " + total);
        System.out.println("Total percentage obtained : " + percentage);
        System.out.println("Grade obtained : " + c);
    }
}