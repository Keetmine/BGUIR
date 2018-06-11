using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChildCentre
{
    public class Group
    {
        public long id { get; set; }
        public long id_personal { get; set; }
        public long id_class { get; set; }
        public string shedule { get; set; }
        public int size { get; set; }
        public int price { get; set; }

        public Group(long id, long id_personal, long id_class, string shedule, int size, int price)
        {
            this.id = id;
            this.id_personal = id_personal;
            this.id_class = id_class;
            this.shedule = shedule;
            this.size = size;
            this.price = price;
        }


        public Boolean AddInDB()
        {
            DB db = new DB();

            db.bind(new string[] { "par1", Convert.ToString(this.id_personal), "par2", Convert.ToString(this.id_class), "par3", this.shedule, "par4", Convert.ToString(this.size), "par5", Convert.ToString(this.price) });

            int created = db.nQuery("INSERT INTO `ChildCentre`.`group` (`id_personal`, `id_class`, `shedule`, `size` , `price`) VALUES (@par1, @par2, @par3, @par4, @par5)");


            if (created > 0)
            {
                return true;
            }

            return false;
        }

        public static Boolean RemoveFromID(string id)
        {
            DB db = new DB();

            int deleted = db.nQuery("DELETE FROM group WHERE id = @id", new string[] { "id", id });

            if (deleted > 0)
            {
                return true;
            }

            return false;
        }

        public Group()
        {

        }

        public static List<Group> getGroups()
        {
            List<Group> list = new List<Group>();

            DB db = new DB();

            DataTable items = db.query("SELECT * FROM `group`");

            foreach (DataRow row in items.Rows)
            {
                object[] item = row.ItemArray;

                Group newGroup = new Group();
                newGroup.id = Convert.ToInt32(item[0]);
                newGroup.id_personal = Convert.ToInt32(item[1]);
                newGroup.id_class = Convert.ToInt32(item[2]);
                newGroup.shedule = Convert.ToString(item[3]);
                newGroup.size = Convert.ToInt32(item[4]);
                newGroup.price = Convert.ToInt32(item[5]);

                list.Add(newGroup);
            }

            return list;
        }
    }
}
