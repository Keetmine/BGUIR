using System;
using System.Collections.Generic;
using System.Data;


namespace ChildCentre
{
    class Category
    {
        public long id { get; set; }
        public string name { get; set; }
        public string description { get; set; }

        public Category(long id, string name, string description)
        {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        public Boolean AddInDB()
        {
            DB db = new DB();

            db.bind(new string[] { "par1", this.name, "par2", this.description });

            int created = db.nQuery("INSERT INTO `ChildCentre`.`category` (`name`, `description`) VALUES (@par1, @par2)");

            if (created > 0)
            {
                return true;
            }

            return false;
        }

        public static Boolean RemoveFromID(string id)
        {
            DB db = new DB();

            int deleted = db.nQuery("DELETE FROM category WHERE id = @id", new string[] { "id", id });

            if (deleted > 0)
            {
                return true;
            }

            return false;
        }
        public Category()
        {

        }

        public static List<Category> getCategories()
        {
            List<Category> list = new List<Category>();

            DB db = new DB();

            DataTable items = db.query("SELECT * FROM category");

            foreach (DataRow row in items.Rows)
            {
                object[] item = row.ItemArray;

                Category newCategory = new Category();
                newCategory.id = Convert.ToInt32(item[0]);
                newCategory.name = Convert.ToString(item[1]);
                newCategory.description = Convert.ToString(item[2]);


                list.Add(newCategory);
            }

            return list;
        }
    }
   
}
