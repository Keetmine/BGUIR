using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChildCentre
{
    public class List
    {
        public long id { get; set; }
        public long id_child { get; set; }
        public long id_group { get; set; }
        public long id_event { get; set; }

        public List(long id, long id_child, long id_group, long id_event)
        {
            this.id = id;
            this.id_child = id_child;
            this.id_group = id_group;
            this.id_event = id_event;
        }


        public Boolean AddInDB()
        {
            DB db = new DB();

            db.bind(new string[] { "par1", Convert.ToString(this.id_child), "par2", Convert.ToString(this.id_group), "par3", Convert.ToString(this.id_event) });

            int created = db.nQuery("INSERT INTO `ChildCentre`.`list` (`id_child`, `id_group`, `id_event`) VALUES (@par1, @par2, @par3)");


            if (created > 0)
            {
                return true;
            }

            return false;
        }

        public static Boolean RemoveFromID(string id)
        {
            DB db = new DB();

            int deleted = db.nQuery("DELETE FROM list WHERE id = @id", new string[] { "id", id });

            if (deleted > 0)
            {
                return true;
            }

            return false;
        }

        public List()
        {

        }

        public static List<List> getLists()
        {
            List<List> list = new List<List>();

            DB db = new DB();

            DataTable items = db.query("SELECT * FROM `list`");

            foreach (DataRow row in items.Rows)
            {
                object[] item = row.ItemArray;

                List newList = new List();
                newList.id = Convert.ToInt32(item[0]);
                newList.id_child = Convert.ToInt32(item[1]);
                newList.id_group = Convert.ToInt32(item[2]);
                newList.id_event = Convert.ToInt32(item[3]);
             
                list.Add(newList);
            }

            return list;
        }
    }
}
