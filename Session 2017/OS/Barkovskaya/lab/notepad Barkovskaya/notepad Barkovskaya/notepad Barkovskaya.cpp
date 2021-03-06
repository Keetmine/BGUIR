// notepad Barkovskaya.cpp : Defines the entry point for the console application.

#include "stdafx.h"
#include <windows.h> 
#include <iostream> 

using namespace std;

int main()
{
	STARTUPINFO si;
	PROCESS_INFORMATION pi;
	// заполняем значения структуры STARTUPINFO по умолчанию
	ZeroMemory(&si, sizeof(STARTUPINFO));
	si.cb = sizeof(STARTUPINFO);
	// запускаем процесс Notepad
	if (!CreateProcess(
		NULL, // имя не задаем 
		L"Notepad.exe", // командная строка, первая лексема указывает имя программы 
		NULL, // атрибуты защиты процесса устанавливаем по умолчанию 
		NULL, // атрибуты защиты первичного потока по умолчанию 
		FALSE, // дескрипторы текущего процесса не наследуются новым процессом 
		0, // по умолчанию NORMAL_PRIORITY_CLASS 
		NULL, // используем среду окружения вызывающего процесса
		NULL, // текущий диск и каталог, как и в вызывающем процессе 
		&si, // вид главного окна - по умолчанию 
		&pi // здесь будут дескрипторы и идентификаторы 
			// нового процесса и его первичного потока 
		)
	)

	Sleep(1000); // немного подождем и закончим свою работу 
	// закроем дескрипторы запущенного процесса в текущем процессе 
	CloseHandle(pi.hThread);
	CloseHandle(pi.hProcess);
	return 0;
}