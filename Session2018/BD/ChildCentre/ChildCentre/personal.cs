using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChildCentre
{
    public class Personal
    {
        public long id { get; set; }
        public string fio { get; set; }
        public DateTime dob { get; set; }
        public string qualification { get; set; }


        public Personal(long id, string fio, DateTime dob, string qualification)
        {
            this.id = id;
            this.fio = fio;
            this.dob = dob;
            this.qualification = qualification;
        }

        public Boolean AddInDB()
        {
            DB db = new DB();

            db.bind(new string[] { "par1", this.fio, "par2", Convert.ToString(this.dob), "par3", this.qualification });

            int created = db.nQuery("INSERT INTO `ChildCentre`.`personal` (`fio`, `dob`, `qualification`) VALUES (@par1, @par2, @par3)");

            if (created > 0)
            {
                return true;
            }

            return false;
        }

        public static Boolean RemoveFromID(string id)
        {
            DB db = new DB();

            int deleted = db.nQuery("DELETE FROM personal WHERE id = @id", new string[] { "id", id });

            if (deleted > 0)
            {
                return true;
            }

            return false;
        }

        public Personal()
        {

        }

        public static List<Personal> getPersonal()
        {
            List<Personal> list = new List<Personal>();

            DB db = new DB();

            DataTable items = db.query("SELECT * FROM personal");

            foreach (DataRow row in items.Rows)
            {
                object[] item = row.ItemArray;

                Personal newPersonal = new Personal();
                newPersonal.id = Convert.ToInt32(item[0]);
                newPersonal.fio = Convert.ToString(item[1]);
                newPersonal.dob = Convert.ToDateTime(item[2]);
                newPersonal.qualification = Convert.ToString(item[3]);

                list.Add(newPersonal);
            }

            return list;
        }
    }
}
