/**
 * Name: Patrick Espino
 * ID: 014254979
 * Lab: 3
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class kthElement {
	public static void main(String[] args)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();

		System.out.println("Enter a positive integer");
		Scanner read = new Scanner(System.in);
		Random random = new Random();
		int n = read.nextInt();
		
		for(int i=0; i<n; i++)
		{
			arr.add(random.nextInt(100 + 1 + 100) - 100);
		}
		
		for(int i = 0; i < arr.size(); i++)
		{
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
		Median(arr,0,arr.size()-1);
		System.out.println("Enter a number between 1 and the size of the array(" + arr.size() + ") as the kth element");
		int kth = read.nextInt();
		ans = findKth(arr,kth-1	,0,arr.size());
		System.out.println("Your " + kth + " least element is: " + ans);

		
		//prints out sorted array for easier checking
//		Collections.sort(arr);
//		for(int i = 0; i < arr.size(); i++)
//		{
//			System.out.print(arr.get(i) + " ");
//		}
//		
	}
	
	public static ArrayList<Integer> findKth(ArrayList<Integer> arr, int k,int start, int end)
	{
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		ArrayList<Integer> pivot = new ArrayList<Integer>();

		//looks through the array 
		for(int i = 0;i < arr.size()-1; i++)
		{
			//if its bigger than the pivot add it to the right array
			if(arr.get(i) >= arr.get(arr.size() - 1))
			{
				right.add(arr.get(i));
			}
			//else if its smaller add it to the left array
			else if (arr.get(i) < arr.get(arr.size()-1))
			{
				left.add(arr.get(i));
			}
		}
		
		//the kth element is either the pivot or the right array
		if(k >= left.size())
		{
			//if k is the same as the left size then return the pivot
			if(k == left.size())
			{
				pivot.add(arr.get(arr.size() - 1));
				return pivot;
			}
			//else search for kth element in the right array list
			else
			{
				return findKth(right,k-left.size()-1,0,right.size()-1);
			}
		}
		//the kth element is in the left array
		else if(k < left.size())
		{
			return findKth(left,k,0,left.size()-1);
		}
		return null;
	}
	
	public static int Median(ArrayList<Integer> arr, int left, int right)
	{
		//initializes the first, the middle, and last element in the array
		int first = left;
		int middle = (right + left) / 2;
		int last = right;
		
		//puts those elements into a separate arraylist
		ArrayList<Integer> med = new ArrayList<Integer>();
		med.add(arr.get(left));
		med.add(arr.get(middle));
		med.add(arr.get(right));
		
		//sorts the 3 elements in the list
		Collections.sort(med);

		//if the middle element in the array list = the first element in the original array
		//swap the first and last element
		if(med.get(1) == arr.get(0))
		{
			Collections.swap(arr,first,last);
		}
		//if the middle element in the array list = middle element in the original array
		//swap the middle and last element
		if(med.get(1) == arr.get(arr.size() / 2))
		{
			Collections.swap(arr,middle,last);
		}
		
		return med.get(1);
		
	}
}
