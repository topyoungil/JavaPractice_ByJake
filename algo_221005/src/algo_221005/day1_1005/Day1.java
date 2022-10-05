package algo_221005.day1_1005;

import java.util.ArrayList;
import java.util.Scanner;

public class Day1 
{
	
	// 1. 큰 수 출력하기
	public ArrayList<Integer> solution01(int n, int[] arr) 
	{

		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		answer.add(arr[0]);
		
		for (int i = 1; i < n; i++)
			if (arr[i] > arr[i-1])
				answer.add(arr[i]);
		
		return answer;
	}
	
	// 2. 보이는 학생
	public int solution02 (int n, int[] arr) 
	{
		int answer = 1, max = arr[0];
		
		for (int i = 1; i < n; i++)
		{
			if (arr[i] > max)
			{
				max = arr[i];
				answer++;
			}
		}
		return answer;
	}
	
	// 3. 가위 바위 보
	public String solution03 (int n, int[] a, int[] b)
	{
		String answer = "";
		
		for (int i=0; i < n; i++)
		{
			if (a[i] == b[i])
				answer += "D";
			else if (a[i] == 1 && b[i] == 3)
				answer += "A";
			else if (a[i] == 2 && b[i] == 1)
				answer += "A";
			else if (a[i] == 3 && b[i] == 2)
				answer += "A";
			else answer += "B";
		}
		
		return answer;
	}
	
	// 4. 피보나치 수열 - 1
	public int[] solution04 (int n)
	{
		int[] answer = new int[n];
		
		answer[0] = 1;
		answer[1] = 1;
		
		for (int i = 2; i < n; i++)
			answer[i] = answer[i-2] + answer[i-1];
		
		return answer;
	}
	
	// 4. 피보나치 수열 - 2
	public void solution05 (int n)
	{
		int a = 1, b = 1, c;
		
		System.out.print(a + " " + b + " ");
		
		for (int i = 2; i < n; i++)
		{
			c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
	}
	
	// 5. 소수 (에라토스테네스 체)
	public int solution06(int n) {
		
		int cnt = 0;
		
		int[] ch = new int[n+1];
		
		for (int i = 2; i <= n; i++)
		{
			if (ch[i] == 0)
			{
				cnt++;
				for (int j = i; j <= n; j=j+i)
					ch[j] = 1;
			}
		}
		
		return cnt;
	}
	
	// 6. 뒤집은 소수
	public boolean isPrime(int num)
	{
		if (num == 1)
			return false;
		
		for (int i = 2; i < num; i++)
			if (num % i ==0)
				return false;
		
		return true;
	}
	
	public ArrayList<Integer> solution07(int n, int[] arr)
	{
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++)
		{
			int tmp = arr[i];
			int res = 0;
			
			while (tmp > 0)
			{
				int t = tmp % 10;
				res = res * 10 + t;
				tmp = tmp / 10;
			}
			if (isPrime(res))
				answer.add(res);
		}
		return answer;
	}
	
	public static void main(String[] args) 
	{
		Day1 d1 = new Day1();
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		for (int x : d1.solution07(n, arr))
			System.out.println(x + " ");
	}
}