#include<stdio.h>
int main()
{
	int n;
	printf("enter the number");
	scanf("%d",&n);
	fib();
	
	
}

int fib(int n)
{
	if(n<=1)
		return n;
	else
		return fib(n-2)+fib(n-1);
	
}