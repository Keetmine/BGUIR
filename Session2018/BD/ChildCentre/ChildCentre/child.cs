using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChildCentre
{
    public class Child
    {
        public long id { get; set; }
        public long id_child_info { get; set; }
        public long id_parents { get; set; }
        //public ChildInfo info { get; set; }
        //public Parents parents { get; set; }

        public Child (long id, long id_child_info, long id_parents)
        {
            this.id = id;
            this.id_child_info = id_child_info;
            this.id_parents = id_parents;
        }

        public Boolean AddInDB()
        {
            DB db = new DB();

            db.bind(new string[] { "par1", Convert.ToString(this.id_child_info), "par2", Convert.ToString(this.id_parents) });

            int created = db.nQuery("INSERT INTO `ChildCentre`.`child` (`id_child_info`, `id_parents`) VALUES (@par1, @par2)");

            if (created > 0)
            {
                return true;
            }

            return false;
        }

        public static Boolean RemoveFromID(string id)
        {
            DB db = new DB();

            int deleted = db.nQuery("DELETE FROM child WHERE id = @id", new string[] { "id", id });

            if (deleted > 0)
            {
                return true;
            }

            return false;
        }

        public Child()
        {

        }

        public static List<Child> getChild()
        {
            List<Child> list = new List<Child>();

            DB db = new DB();

            DataTable items = db.query("SELECT * FROM child");

            foreach (DataRow row in items.Rows)
            {
                object[] item = row.ItemArray;

                Child newChild = new Child();
                newChild.id = Convert.ToInt32(item[0]);
                newChild.id_child_info = Convert.ToInt32(item[1]);
                newChild.id_parents = Convert.ToInt32(item[2]);
             
                list.Add(newChild);
            }

            return list;
        }
    }
}
