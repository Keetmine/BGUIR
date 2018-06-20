using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab2
{
    class Program
    {
        static void Main(string[] args)
        {
            Matrica newMatrica = new Matrica();
            newMatrica.setSize();
            newMatrica.drawMatrica();
            Console.ReadLine();

            newMatrica.drawPodMatrica();
        }

    }
}
