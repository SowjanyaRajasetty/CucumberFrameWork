package Practice;

public class Solution {
	
	public static void transform(String S)
	{
		
		StringBuilder s1=new StringBuilder(S);
		System.out.println("Input :"+S);		
		for(int i=1;i<s1.length();i++)
		{
			System.out.println(s1.charAt(i));
		
				if(s1.charAt(i)=='A')
				{
					if((i+1)<s1.length())
					{
					if(s1.charAt(i+1)=='B')
					{
						s1.deleteCharAt(i+1);						
						System.out.println("Current :"+s1);
						s1.deleteCharAt(i);
						i--;
						System.out.println("Current poniter i:"+i);
						System.out.println("Current :"+s1);
					}
					
					else if(s1.charAt(i-1)=='B')
					{
						s1.deleteCharAt(i);						
						System.out.println("Current :"+s1);
						s1.deleteCharAt(i-1);
						i--;
						System.out.println("Current poniter i:"+i);
						System.out.println("Current :"+s1);
					}
					}
				}
				else if(s1.charAt(i)=='B')
				{
					if((i+1)<s1.length())
					{
					if( s1.charAt(i+1)=='A')
					{
						s1.deleteCharAt(i+1);
						
						System.out.println("Current :"+s1);
						s1.deleteCharAt(i);
						i--;
						System.out.println("Current poniter i:"+i);
						System.out.println("Current :"+s1);
					}
					else if(s1.charAt(i-1)=='A')
					{
						s1.deleteCharAt(i);
						System.out.println("Current :"+s1);
						s1.deleteCharAt(i-1);
						i--;
						System.out.println("Current poniter i:"+i);
						System.out.println("Current :"+s1);
					}
					}
				}
				else if(s1.charAt(i)=='C')
				{
					if((i+1)<s1.length())
					{
					if(s1.charAt(i+1)=='D')
					{
						s1.deleteCharAt(i+1);						
						System.out.println("Current :"+s1);
						s1.deleteCharAt(i);
						i--;
						System.out.println("Current poniter i:"+i);
						System.out.println("Current :"+s1);
					}
					
					else if(s1.charAt(i-1)=='D')
					{
						s1.deleteCharAt(i);						
						System.out.println("Current :"+s1);
						s1.deleteCharAt(i-1);
						i--;
						System.out.println("Current poniter i:"+i);
						System.out.println("Current :"+s1);
					}
					}
				}
				else if(s1.charAt(i)=='D')
				{
					if((i+1)<s1.length())
					{
					if(s1.charAt(i+1)=='C')
					{
						s1.deleteCharAt(i+1);
						
						System.out.println("Current :"+s1);
						s1.deleteCharAt(i);
						i--;
						System.out.println("Current poniter i:"+i);
						System.out.println("Current :"+s1);
					}
					
					else if(s1.charAt(i-1)=='C')
					{
						s1.deleteCharAt(i);						
						System.out.println("Current :"+s1);
						s1.deleteCharAt(i-1);
						i--;
						System.out.println("Current poniter i:"+i);
						System.out.println("Current :"+s1);
					}
					}
				}
			
		}
		System.out.println("Output :"+s1);
	}
	
	public static void main(String[] args) {
		
//		transform("ABABCDDCBACC");
		transform("CBACD");
		transform("CABABD");
//		transform("ACBDACBD");
	}
	}


