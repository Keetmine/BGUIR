using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3zadanie
{
    class BaseEntity
    {
        protected BaseEntity()
        {

        }

        public BaseEntity(string customString)
        {
            CustomString = customString;
        }

        private string _customString;

        protected string CustomString
        {
            get { return _customString; }
            set { _customString = value; }
        }

        ~BaseEntity()
        {
            Console.WriteLine("was destroy");
        }
    }
}
