using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2zadanie
{
    class Program
    {
        static void Main(string[] args)
        {
            // создаем два экземпляра обьекта с параметром стринг
            CustomObject a = new CustomObject("THIS IS SPARTA?");
            CustomObject b = new CustomObject("NO! THIS IS PATRIK!");

            // вызывает ф-цию, которая вывведет результат
            CustomClass.Join(a, b);

            // что бы консоль не закрылась
            Console.ReadKey();
        }
    }
}
