package com.greatlearning.problem2;

import java.util.Scanner;

public class Denominaiton {

	public static void mergeSort(int array[], int f, int l) {
		// f = first; l = last;
		if (f < l) {

			int mid = (f + l) / 2;
			mergeSort(array, f, mid);
			mergeSort(array, mid + 1, l);
			merge(array, f, mid, l);
		}
	}

	private static void merge(int[] array, int f, int mid, int l) {
		int n1 = mid - f + 1;
		int n2 = l - mid;
		int L[] = new int[n1]; // left Array
		int R[] = new int[n2]; // Right Array

		for (int i = 0; i < n1; i++) {
			L[i] = array[f + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = array[mid + 1 + i];
		}

		int i = 0, j = 0, k = f;

		while (i < n1 && j < n2) {
			if (L[i] >= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of denominations :");
		int NoOfDen = scanner.nextInt();
		int[] denArray = new int[NoOfDen];
		System.out.println("Enter the Denominations value");
		for (int i = 0; i < NoOfDen; i++) {
			denArray[i] = scanner.nextInt();
		}
		mergeSort(denArray, 0, denArray.length - 1);
		for (int i = 0; i < denArray.length; i++)
			System.out.println(denArray[i]);
		System.out.println("Enter the amount you want to pay: ");
		int amount = scanner.nextInt();

		for (int i = 0; i < denArray.length; i++) {
			if (amount >= denArray[i]) {
				int notes = amount / denArray[i];
				System.out.println(denArray[i] + " : " + notes);
				amount = amount % denArray[i];
			}
		}
		if (amount > 0)
			System.out.println("Remaining Amount: " + amount);

		scanner.close();
	}
}
