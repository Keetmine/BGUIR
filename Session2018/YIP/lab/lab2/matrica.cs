using System;

public class Matrica
{
    int x = 0;
    int y = 0;
    int[,] a = new int[0, 0];

    public Matrica()
    {

    }

    public void setSize()
    {
        Console.Write("Введите X матрицы: ");
        x = int.Parse(Console.ReadLine());

        Console.Write("Введите Y матрицы: ");

        y = int.Parse(Console.ReadLine());

        this.a = new int[x, y];
        generateMatrica();
    }    

    public void generateMatrica()
    {
        Random rand = new Random();

        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                a[i, j] = rand.Next(-1, +9);              
            }
                
        }
        drawMatrica();
    }

    public void drawMatrica()
    {
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
                Console.Write(String.Format("{0,3}", a[i, j]));
            Console.WriteLine();
        }
    }

 }
