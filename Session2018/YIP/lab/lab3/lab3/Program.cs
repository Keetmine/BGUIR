using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab3
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Int32> a = new List<Int32>();
            
            Console.Write("Vvedite koll elementov = ");
            var s = Console.ReadLine();
            Console.WriteLine(Convert.ToInt32(s));
            for (var i=0; i < Convert.ToInt32(s); i++)
            {
                Console.Write(i + " el = ");
                var a0 = Console.ReadLine();
                if (Convert.ToInt32(a0) == i)
                {                   
                    a.Add(Convert.ToInt32(a0));
                };
              
            }

            if (a.Count > 0)
            {
                for (var i = 0; i < a.Count; i++)
                {
                    Console.WriteLine(a[i]);
                };
            } else
            {          
               Console.WriteLine("Element not found");                
            }
           
            Console.ReadLine();
        }
    }
}
