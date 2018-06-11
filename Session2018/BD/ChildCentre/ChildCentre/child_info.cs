using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChildCentre
{
    class ChildInfo
    {
        public long id { get; set; }
        public string fio { get; set; }
        public DateTime dob { get; set; }
        public string address { get; set; }

        public ChildInfo(long id, string fio, DateTime dob, string address)
        {
            this.id = id;
            this.fio = fio;
            this.dob = dob;
            this.address = address;
        }

        public Boolean AddInDB()
        {
            DB db = new DB();

            db.bind(new string[] { "par1", this.fio, "par2", Convert.ToString(this.dob), "par3", this.address });

            int created = db.nQuery("INSERT INTO `ChildCentre`.`child_info` (`fio`, `dob`, `address`) VALUES (@par1, @par2, @par3)");

            if (created > 0)
            {
                return true;
            }

            return false;
        }

        public static Boolean RemoveFromID(string id)
        {
            DB db = new DB();

            int deleted = db.nQuery("DELETE FROM child_info WHERE id = @id", new string[] { "id", id });

            if (deleted > 0)
            {
                return true;
            }

            return false;
        }

        public ChildInfo()
        {

        }

        public static List<ChildInfo> getChildInfos()
        {
            List<ChildInfo> list = new List<ChildInfo>();

            DB db = new DB();

            DataTable items = db.query("SELECT * FROM child_info");

            foreach (DataRow row in items.Rows)
            {
                object[] item = row.ItemArray;

                ChildInfo newChildInfo = new ChildInfo();
                newChildInfo.id = Convert.ToInt32(item[0]);
                newChildInfo.fio = Convert.ToString(item[1]);
                newChildInfo.dob = Convert.ToDateTime(item[2]);
                newChildInfo.address = Convert.ToString(item[3]);
                        
                list.Add(newChildInfo);
            }

            return list;
        }
    }
}
