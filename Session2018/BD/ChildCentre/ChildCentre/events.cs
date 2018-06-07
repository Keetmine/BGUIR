using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChildCentre
{
    public class Events
    {
        public long id { get; set; }
        public string description { get; set; }
        public DateTime date { get; set; }
        public string note { get; set; }
        public int price { get; set; }

        Events(long id, long id_list_child, string description, DateTime date, string note, int price)
        {
            this.id = id;
            this.id_list_child = id_list_child;
            this.description = description;
            this.date = date;
            this.note = note;
            this.price = price;
        }

        public static List<Events> getEvents() {

            List<Events> list = new List<Events>();

            var dbCon = DBConnection.Instance();

            if (dbCon.IsConnect())
            {
                string query = "SELECT * FROM events";
                var cmd = new MySqlCommand(query, dbCon.Connection);
                var reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    Events newEvent = new Events();
                    newEvent.id = reader.getLong(0);
                    newEvent.id_list_child = reader.getLong(1);
                    newEvent.


                    //string someStringFromColumnZero = reader.GetString(0);
                    //string someStringFromColumnOne = reader.GetString(1);
                    Console.WriteLine(someStringFromColumnZero + "," + someStringFromColumnOne);
                }
                dbCon.Close();
            }

            return list;
        }
    }
}
