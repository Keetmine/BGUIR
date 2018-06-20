using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChildCentre
{
    public class Removed_group
    {
        public long id { get; set; }
        public long id_personal { get; set; }
        public long id_class { get; set; }
        public string shedule { get; set; }
        public int size { get; set; }
        public int price { get; set; }

        public Removed_group(long id, long id_personal, long id_class, string shedule, int size, int price)
        {
            this.id = id;
            this.id_personal = id_personal;
            this.id_class = id_class;
            this.shedule = shedule;
            this.size = size;
            this.price = price;
        }              

        public Removed_group()
        {

        }

        public static List<Removed_group> getRemoveGroups()
        {
            List<Removed_group> list = new List<Removed_group>();

            DB db = new DB();

            DataTable items = db.query("SELECT * FROM `group`");

            foreach (DataRow row in items.Rows)
            {
                object[] item = row.ItemArray;

                Removed_group newRemovedGroup = new Removed_group();
                newRemovedGroup.id = Convert.ToInt32(item[0]);
                newRemovedGroup.id_personal = Convert.ToInt32(item[1]);
                newRemovedGroup.id_class = Convert.ToInt32(item[2]);
                newRemovedGroup.shedule = Convert.ToString(item[3]);
                newRemovedGroup.size = Convert.ToInt32(item[4]);
                newRemovedGroup.price = Convert.ToInt32(item[5]);

                list.Add(newRemovedGroup);
            }

            return list;
        }
    }
}
