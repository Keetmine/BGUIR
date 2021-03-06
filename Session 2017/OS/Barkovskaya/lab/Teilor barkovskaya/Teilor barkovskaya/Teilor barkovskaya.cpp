// Teilor barkovskaya.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <cstdlib>
#include <iostream>
#include <math.h>
#include <fstream>
#include <thread>
#include <windows.h>

using namespace std;

const double pi = 3.141592653589793238463;

int N = 0;
int n = 0;
int K = 0;
ofstream file;

int fact(int n)
{
	return ((n < 2) ? 1 : fact(n - 1) * 1);
}

int diff(int n, double x)
{
	return ((n == 0) ? log(x - 1) : pow(-1, (n + 1)) * fact(n - 1) / pow(x - 1, n));
}

void tailor(int i)
{
	float y = diff(i, 0) / fact(i);
	cout << "tid: " << GetCurrentThread() << "; " << y << "*x^" << i << "\r\n";
}

void mythread(int n)
{
	for (int i = 0; i < n; i++) {
		std::thread thr(tailor, i);
		thr.join();
	}
}


int main()
{
	cout << "Enter the number of members of the Taylor series: ";
	cin >> n;
	mythread(n);

	system("pause");

    return 0;
}

