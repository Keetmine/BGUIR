using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2zadanie
{
    class CustomObject
    {

        private string _stroka;
        protected string Stroka
        {
            get { return _stroka; }
            set { _stroka = value; }
        }

        //дефолтный конструктор
        public CustomObject()
        {
            Stroka = "This is My default string.";
        }

        //конструктор с параметром
        public CustomObject(string stroka)
        {
            Stroka = stroka;
        }
        //конструктор копирования
        public CustomObject(CustomObject Stroka)
        {
            this.Stroka = Stroka.GetValue();
        }

        ~CustomObject()
        {
            this.Stroka = null;
            Console.WriteLine("was destroy");
        }

        //получение значение обьекта с доступностью public
        public string GetValue()
        {
            return this.Stroka;
        }

        public static string operator +(CustomObject a, CustomObject b)
        {
            return String.Join(" ", a.GetValue(), b.GetValue());
        }
    }
}
