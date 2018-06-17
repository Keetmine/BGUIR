using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PhoneNumber
{
    public partial class Form1 : Form
    {
        private List<PhoneNumber> abonents = new List<PhoneNumber>();

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void setDefaultNumbers()
        {
            PhoneNumber abon1 = new PhoneNumber();
            abon1.setNumber("+375 29 319 43 00");
            abon1.setBalance(100);
            abon1.setFio("Иванов Кирилл Евгеньевич");
            abon1.setPassport("КВ8903390А3");
            abon1.setTarif("Семейный");

            PhoneNumber abon2 = new PhoneNumber();
            abon2.setNumber("+375 29 319 43 00");
            abon2.setBalance(100);
            abon2.setFio("Иванов Кирилл Евгеньевич");
            abon2.setPassport("КВ8903390А3");
            abon2.setTarif("Семейный");

            PhoneNumber abon3 = new PhoneNumber();
            abon3.setNumber("+375 29 319 43 00");
            abon3.setBalance(100);
            abon3.setFio("Иванов Кирилл Евгеньевич");
            abon3.setPassport("КВ8903390А3");
            abon3.setTarif("Семейный");

            PhoneNumber abon4 = new PhoneNumber();
            abon4.setNumber("+375 29 319 43 00");
            abon4.setBalance(100);
            abon4.setFio("Иванов Кирилл Евгеньевич");
            abon4.setPassport("КВ8903390А3");
            abon4.setTarif("Семейный");

            PhoneNumber abon5 = new PhoneNumber();
            abon5.setNumber("+375 29 319 43 00");
            abon5.setBalance(100);
            abon5.setFio("Иванов Кирилл Евгеньевич");
            abon5.setPassport("КВ8903390А3");
            abon5.setTarif("Семейный");

            PhoneNumber abon6 = new PhoneNumber();
            abon6.setNumber("+375 29 319 43 00");
            abon6.setBalance(100);
            abon6.setFio("Иванов Кирилл Евгеньевич");
            abon6.setPassport("КВ8903390А3");
            abon6.setTarif("Семейный");

            PhoneNumber abon7 = new PhoneNumber();
            abon7.setNumber("+375 29 319 43 00");
            abon7.setBalance(100);
            abon7.setFio("Иванов Кирилл Евгеньевич");
            abon7.setPassport("КВ8903390А3");
            abon7.setTarif("Семейный");


            this.abonents = new List<PhoneNumber>()
            {
                abon1, abon2, abon3, abon4, abon5, abon6, abon7
            };
        }
    }
}
