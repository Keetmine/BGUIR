using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proj
{
    class Program
    {
        static void Main(string[] args)
        {
            // создаем два экземпляра обьекта с параметром стринг
            CustomObject a = new CustomObject("THIS IS SPARTA!");
            CustomObject b = new CustomObject("It is UIStackView!");

            // вызывает ф-цию, которая вывведет результат
            CustomClass.ChangeFirstWords(a, b);

            // что бы консоль не закрылась
            Console.ReadKey();
        }
    }
}
