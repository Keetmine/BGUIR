using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2zadanie
{
    class CustomClass // тут выводится результат //При реализации задания 1 функцию вывода содержимого объекта реали-зовать как внешнюю по отношению к классу
    {
        public static void Join(CustomObject a, CustomObject b) // принимает два обьекта, выводит их начальное значение, вызывает перегруженную ф-цию + и выводит окончательный вариант
        {
            Console.WriteLine("In start strings:");
            Console.WriteLine(" ");
            Console.WriteLine("           A string: {0}", a.GetValue());
            Console.WriteLine("           B string: {0}", b.GetValue());
            Console.WriteLine(" ");
            Console.WriteLine("C = A + B = {0}", a + b);

        }

    }
}
