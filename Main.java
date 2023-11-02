package org.example;

import java.util.Scanner;

import java.util.Arrays;

public class Main {
    public static void selectionSort(int[] arr, int size){
        for (int i = 0; i < size; i++) {
            int index = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[index]){
                    index = j; //Searches for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
    public static void insertionSort(int[] arr, int size){
        int length = size;
        for (int j = 1; j < length; j++) {
            int temp = arr[j];
            int i = j-1;
            while ( (i > -1) && ( arr [i] > temp ) ) {
                arr [i+1] = arr [i];
                i--;
            }
            arr[i+1] = temp;
        }
    }
    public static void arrayInput(int[] arr, int size){
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the number on index " + i + ": ");
            arr[i] = input.nextInt(); //Get user input for each index
        }

        int[] newArr = Arrays.copyOf(arr, size);

        System.out.println("Original array:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void algoSelection(int[] arr, int size){
        Scanner input = new Scanner(System.in);

        System.out.print("\nWhat sorting algorithm do you want to choose? (0 - quit, 1 - selection, 2 - insertion): ");
        switch (input.nextInt()){
            case 1:
                selectionSort(arr, size);
                break;
            case 2:
                insertionSort(arr, size);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Please enter a correct number");

        }

        System.out.print("\nAfter sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean retry = true;
        System.out.print("\nEnter the length of the array: ");
        int size = input.nextInt(); //Get user input for size
        int[] arr = new int[size];

        arrayInput(arr, size);
        algoSelection(arr, size);

        do{
            System.out.print("\nWhat do you want to do next? (0 - quit, 1 - algorithm selection, 2 - input next array indexes): ");
            switch (input.nextInt()){
                case 1:
                    algoSelection(arr, size);
                    break;
                case 2:
                    System.out.print("\nEnter the length of the array: ");
                    size = input.nextInt(); //Get user input for size
                    System.out.println(size);
                    arrayInput(arr, size);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Please enter a correct number");
            }

        } while (retry = true);

    }
}