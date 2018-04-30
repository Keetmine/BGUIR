using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proj
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

        // устанавливает новое первое слово в значении, принимает на вход обьект, передает дальше его стринг
        public void SetFirstWord(CustomObject b)
        {
            SetFirstWord(b.GetFirstWord());
        }

        // устанавливает новое первое слово в значении, принимает стринг
        public void SetFirstWord(string word)
        {
            int idx = Stroka.IndexOf(GetFirstWord());
            Stroka = Stroka.Remove(idx, GetFirstWord().Length).Insert(idx, word);
        }

        // отдает первое слово предложения, используя ф-цию split
        public string GetFirstWord()
        {
            return Stroka.Split(' ')[0];
        }
    }
}
