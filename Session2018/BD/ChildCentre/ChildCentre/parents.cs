using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChildCentre
{
    public class Parents
    {
        public long id { get; set; }
        public string mother_fio { get; set; }
        public DateTime mother_dob { get; set; }
        public string father_fio { get; set; }
        public DateTime father_dob { get; set; }

        public Parents(long id, string mother_fio, DateTime mother_dob, string father_fio, DateTime father_dob)
        {
            this.id = id;
            this.mother_fio = mother_fio;
            this.mother_dob = mother_dob;
            this.father_fio = father_fio;
            this.father_dob = father_dob;
        }

        public Boolean AddInDB()
        {
            DB db = new DB();

            db.bind(new string[] { "par1", this.mother_fio, "par2", Convert.ToString(this.mother_dob), "par3", this.father_fio, "par4", Convert.ToString(this.father_dob) });

            int created = db.nQuery("INSERT INTO `ChildCentre`.`parents` (`mother_fio`, `mother_dob`, `father_fio`, `father_dob`) VALUES (@par1, @par2, @par3, @par4)");

            if (created > 0)
            {
                return true;
            }

            return false;
        }

        public static Boolean RemoveFromID(string id)
        {
            DB db = new DB();

            int deleted = db.nQuery("DELETE FROM parents WHERE id = @id", new string[] { "id", id });

            if (deleted > 0)
            {
                return true;
            }

            return false;
        }

        public Parents()
        {

        }

        public static List<Parents> getParents()
        {
            List<Parents> list = new List<Parents>();

            DB db = new DB();

            DataTable items = db.query("SELECT * FROM parents");

            foreach (DataRow row in items.Rows)
            {
                object[] item = row.ItemArray;

                Parents newParents = new Parents();
                newParents.id = Convert.ToInt32(item[0]);
                newParents.mother_fio = Convert.ToString(item[1]);
                newParents.mother_dob = Convert.ToDateTime(item[2]);
                newParents.father_fio = Convert.ToString(item[3]);
                newParents.father_dob = Convert.ToDateTime(item[4]);

                list.Add(newParents);
            }

            return list;
        }

    }
}
