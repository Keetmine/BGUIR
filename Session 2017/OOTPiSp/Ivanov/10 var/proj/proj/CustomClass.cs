using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proj
{
    class CustomClass // тут выводится результат //При реализации задания 1 функцию вывода содержимого объекта реали-зовать как внешнюю по отношению к классу
    {
        public static void ChangeFirstWords(CustomObject a, CustomObject b) // принимает два обьекта, выводит их начальное значение, вызывает ф-ции замены первых слов и выводит окончательный вариант
        {
            Console.WriteLine("In start strings:");
            Console.WriteLine(" ");
            Console.WriteLine("           A string: {0}", a.GetValue());
            Console.WriteLine("           B string: {0}", b.GetValue());
            Console.WriteLine(" ");
            Console.WriteLine("Change first words in strings");
            Console.WriteLine(" ");
            //делаем копии обьектов, используя конструктор копирования
            CustomObject modA = new CustomObject(a); 
            CustomObject modB = new CustomObject(b);

            modA.SetFirstWord(b);
            modB.SetFirstWord(a);

            Console.WriteLine("After change strings:");
            Console.WriteLine(" ");
            Console.WriteLine("           A string: {0}", modA.GetValue());
            Console.WriteLine("           B string: {0}", modB.GetValue());
        }

    }
}
