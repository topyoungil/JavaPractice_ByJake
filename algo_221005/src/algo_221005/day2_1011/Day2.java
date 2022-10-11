package algo_221005.day2_1011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
	
	// 7. 두 배열 합치기
	public ArrayList<Integer> solution07_01 (int n, int m, int[] a, int[] b)
	{
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int p1 = 0, p2 = 0;
		
		while (p1 < n && p2 > m)
		{
			if (a[p1] < b[p2])
				answer.add(a[p1++]);
			else
				answer.add(b[p2++]);
		}
		
		while (p1 < n)
			answer.add(a[p1++]);
		
		while (p2 < m)
			answer.add(b[p2++]);
		
		return answer;
	}
	
	// 8. 공통 원소 구하기
	public ArrayList<Integer> solution08_01 (int n, int m, int[] a, int[] b)
	{
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int p1 = 0, p2 = 0;
		
		while (p1 < n && p2 < m)
		{
			if (a[p1] == b[p2])
			{
				answer.add(a[p1++]);
				p2++;
			}
			else if (a[p1] < b[p2])
				p1++;
			else
				p2++;
		}
		
		return answer;
	}
	
	// 9. 최대 매출
	public int solution10_01 (int n, int k, int[] arr)
	{

		int answer, sum = 0;
		
		for (int i = 0; i < k; i++)
			sum += arr[i];
		
		answer = sum;    
						 // 1 2 3 4 5 6 7          7
						 // 5 6 7 8         	   4 
		
		for (int i = k; i < n; i++)
		{
			sum += (arr[i] - arr[i-k]); // 0 (4-4), (5)6 - 2 (5-4) ,(6)7 - 5 (6-4) 0 4 2 6
			answer = Math.max(answer, sum);
		}

		return answer;
	}

	public static void main(String[] args)
	{
		Day2 d2 = new Day2();
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		System.out.print(d2.solution10_01(n, k, arr));
	}

}
