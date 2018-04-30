using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3zadanie
{
    class ReversService: BaseEntity
    {
        public ReversService(string customString)
        {
            CustomString = customString;
        }

        public void ReversWords()
        {
            Console.WriteLine("Start string:");
            Console.WriteLine("      {0}", CustomString);
            Console.WriteLine(" ");

            Console.WriteLine("Revers words in string.");
            var splitWord = CustomString.Split(' ');

            Console.Write("     ");

            foreach (var word in CustomString.Split(' '))
            {
                char[] reversArray = word.ToCharArray();
                Array.Reverse(reversArray);

                Console.Write(" {0}", new String(reversArray));
            }

        }
    }
}
