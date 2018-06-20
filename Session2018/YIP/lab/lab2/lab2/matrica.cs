using System;

public class Matrica
{
    int x = 0;
    int y = 0;

    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    int[,] a = new int[0, 0];

    public Matrica()
    {

    }

    public void setSize()
    {
        Console.Write("Vvedite X: ");
        x = int.Parse(Console.ReadLine());

        Console.Write("Vvedite Y: ");

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

    public void drawPodMatrica()
    {
        Console.Write("Vvedite X1: ");
        x1 = int.Parse(Console.ReadLine());
        Console.Write("Vvedite x2: ");
        x2 = int.Parse(Console.ReadLine());
        Console.Write("Vvedite Y1: ");
        y1 = int.Parse(Console.ReadLine());
        Console.Write("Vvedite Y2: ");
        y2 = int.Parse(Console.ReadLine());

        for (int i = x1; i <= x2; i++)
        {
            for (int j = y1; j <= y2; j++)
            {
                Console.Write(String.Format("{0,3}", a[i, j]));

            }
            Console.WriteLine();
        }
       
    }

}
