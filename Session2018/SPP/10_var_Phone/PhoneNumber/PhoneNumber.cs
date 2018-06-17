using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PhoneNumber
{
    class PhoneNumber
    {
        private string number;
        private string fio;
        private string passport;
        private string tarif;
        private int balance;

        public void setFio(string fio)
        {
            this.fio = fio;
        }

        public string getFio()
        {
            return this.fio;
        }

        public void setPassport(string passport)
        {
            this.passport = passport;
        }

        public string getPassport()
        {
            return this.passport;
        }

        public void setTarif(string tarif)
        {
            this.tarif = tarif;
        }

        public string getTarif()
        {
            return this.tarif;
        }

        public void setBalance(int balance)
        {
            this.balance = balance;
        }

        public int getBalance()
        {
            return this.balance;
        }

        public void setNumber(string number)
        {
            this.number = number;
        }

        public string getNumber()
        {
            return this.number;
        }

        public string getStringBalance()
        {
            return Convert.ToString(this.balance) + " BYN";
        }
    }
}
