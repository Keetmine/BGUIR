using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChildCentre
{
    public class User
    {
        public long id { get; set; }
        public string name { get; set; }
        public string password { get; set; }
        public bool isAdmin { get; set; }

        public User(long id, string name, string password, bool isAdmin)
        {
            this.id = id;
            this.name = name;
            this.password = password;
            this.isAdmin = isAdmin;
        }

        public Boolean AddInDB()
        {
            DB db = new DB();

            db.bind(new string[] { "par1", this.name, "par2", this.password, "par3", Convert.ToString(this.isAdmin) });

            int created = db.nQuery("INSERT INTO `ChildCentre`.`user` (`name`, `password`, `password`) VALUES (@par1, @par2, @par3)");

            if (created > 0)
            {
                return true;
            }

            return false;
        }

        public static Boolean RemoveFromID(string id)
        {
            DB db = new DB();

            int deleted = db.nQuery("DELETE FROM user WHERE id = @id", new string[] { "id", id });

            if (deleted > 0)
            {
                return true;
            }

            return false;
        }

        public User()
        {

        }

        public static List<User> getUsers()
        {
            List<User> list = new List<User>();

            DB db = new DB();

            DataTable items = db.query("SELECT * FROM user");

            foreach (DataRow row in items.Rows)
            {
                object[] item = row.ItemArray;

                User newUser = new User();
                newUser.id = Convert.ToInt32(item[0]);
                newUser.name = Convert.ToString(item[1]);
                newUser.password = Convert.ToString(item[2]);
                newUser.isAdmin = Convert.ToBoolean(item[3]);

                list.Add(newUser);
            }

            return list;
        }

        public void updateLastSign()
        {
            DB db = new DB();

            DataTable items = db.query("CALL updateUserSign(" + this.id + ");");
        }
        public void updateLastLogout()
        {
            DB db = new DB();

            DataTable items = db.query("CALL updateLastLogout(" + this.id + ");");
        }
    }
}
