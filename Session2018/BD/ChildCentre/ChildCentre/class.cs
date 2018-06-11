using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChildCentre
{
    public class Class
        {

            public long id { get; set; }
            public string name { get; set; }
            public string description { get; set; }
            public string note { get; set; }
            public string category_id { get; set; }

        public Class(long id,string name, string description, string note, string category_id)
        {
            this.id = id;
            this.description = description;
            this.name = name;
            this.note = note;
            this.category_id = category_id;
        }


        public Boolean AddInDB()
        {
            DB db = new DB();

            db.bind(new string[] { "par1", this.name, "par2", this.description, "par3", this.note, "par4", Convert.ToString(this.category_id) });

            int created = db.nQuery("INSERT INTO `ChildCentre`.`class` (`name`, `description`, `note`, `category_id`) VALUES (@par1, @par2, @par3, @par4)");


            if (created > 0)
            {
                return true;
            }

            return false;
        }

        public static Boolean RemoveFromID(string id)
        {
            DB db = new DB();

            int deleted = db.nQuery("DELETE FROM class WHERE id = @id", new string[] { "id", id });

            if (deleted > 0)
            {
                return true;
            }

            return false;
        }

        public Class()
        {

        }

        public static List<Class> getClass()
        {
            List<Class> list = new List<Class>();

            DB db = new DB();

            DataTable items = db.query("SELECT * FROM class");

            foreach (DataRow row in items.Rows)
            {
                object[] item = row.ItemArray;

                Class newClass = new Class();
                newClass.id = Convert.ToInt32(item[0]);
                newClass.name = Convert.ToString(item[1]);
                newClass.description = Convert.ToString(item[2]);
                newClass.note = Convert.ToString(item[3]);
                newClass.category_id = Convert.ToString(item[4]);

                list.Add(newClass);
            }

            return list;
        }
    }
}
