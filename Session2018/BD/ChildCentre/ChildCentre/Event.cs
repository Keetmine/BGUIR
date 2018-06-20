using System;
using System.Collections.Generic;
using System.Data;

namespace ChildCentre
{
    class Event
    {
        public long id { get; set; }
        public string description { get; set; }
        public DateTime date { get; set; }
        public string note { get; set; }
        public int price { get; set; }

        public List<ChildInfo> childs { get; set; }


        public Event(long id, string description, DateTime date, string note, int price)
        {
            this.id = id;
            this.description = description;
            this.date = date;
            this.note = note;
            this.price = price;
        }


        public Boolean AddInDB()
        {
            DB db = new DB();

            db.bind(new string[] { "par1", this.description, "par2", Convert.ToString( this.date), "par3", this.note, "par4", Convert.ToString(this.price) });

            int created = db.nQuery("INSERT INTO `ChildCentre`.`events` (`description`, `date`, `note`, `price`) VALUES (@par1, @par2, @par3, @par4)");
                

            if (created > 0)
            {
                return true;
            }

            return false;
        }

        public static Boolean RemoveFromID(string id)
        {
            DB db = new DB();

            int deleted = db.nQuery("DELETE FROM events WHERE id = @id", new string[] { "id", id });

            if (deleted > 0)
            {
                return true;
            }

            return false;
        }

        public Event()
        {

        }

        public static List<Event> getEvents(string search = "")
        {
            List<Event> list = new List<Event>();
            string query = "SELECT * FROM events";
            if (search != "") query += " WHERE description LIKE '%" + search + "%' OR note LIKE '%" + search + "%'";
            DB db = new DB();

            DataTable items = db.query(query);

            foreach (DataRow row in items.Rows)
            {
                object[] item = row.ItemArray;

                Event newEvent = new Event();
                newEvent.id = Convert.ToInt32(item[0]);
                newEvent.description = Convert.ToString(item[1]);
                newEvent.date = Convert.ToDateTime( item[2]);
                newEvent.note =Convert.ToString( item[3]);
                newEvent.price =Convert.ToInt32( item[4]);
                newEvent.childs = getChildInfoFromEventId(newEvent.id);

                list.Add(newEvent);
            }

            return list;
        }

        public string getChildsName()
        {
            string names = "";

            if(this.childs.Count > 0)
            {
                foreach (ChildInfo child in this.childs)
                {
                    names += child.fio + "; ";
                }
            }

            return names;
        }

        public static List<ChildInfo> getChildInfoFromEventId(long id)
        {
            List<ChildInfo> list = new List<ChildInfo>();

            DB db = new DB();

            DataTable items = db.query("SELECT e3.* FROM `list` e1 JOIN child e2 ON e1.id_child = e2.id JOIN child_info e3 ON e2.id_child_info = e3.id JOIN `events` e4 ON e1.id_event = e4.id WHERE e1.id_event = " + id);

            foreach (DataRow row in items.Rows)
            {
                object[] item = row.ItemArray;

                ChildInfo newChild = new ChildInfo();
                newChild.id = Convert.ToInt32(item[0]);
                newChild.fio = Convert.ToString(item[1]);
                newChild.dob = Convert.ToDateTime(item[2]);
                newChild.address = Convert.ToString(item[3]);

                list.Add(newChild);
            }

            return list;
        }
    }
}
