using MaterialSkin;
using MaterialSkin.Controls;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;

namespace ChildCentre
{
    public partial class Admin : MaterialForm
    {
        Int32 categoryCounter = 0;
        Int32 eventCounter = 0;
        Int32 childCounter = 0;
        Int32 childInfoCounter = 0;
        Int32 classCounter = 0;
        Int32 groupCounter = 0;
        Int32 listCounter = 0;
        Int32 parentsCounter = 0;
        Int32 personalCounter = 0;
        public User user;
        

        public Admin()
        {
            InitializeComponent();

            var materialSkinManager = MaterialSkinManager.Instance;
            materialSkinManager.AddFormToManage(this);
            materialSkinManager.Theme = MaterialSkinManager.Themes.LIGHT;
            materialSkinManager.ColorScheme = new ColorScheme(Primary.BlueGrey800, Primary.BlueGrey900, Primary.BlueGrey500, Accent.LightBlue200, TextShade.WHITE);

        }

        private void tabControl1_DrawItem(object sender, DrawItemEventArgs e)
        {

        }


        private void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            TabPage tab = (sender as TabControl).SelectedTab;
            Main main = new Main();
            Console.WriteLine(tab.Name);
            if (tab.Name == "close")
            {
                this.Hide();
                user.updateLastLogout();
                main.Show();
            }
        }

        private void dataGridView3_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void Admin_Load(object sender, EventArgs e)
        {
            SetupEventTable();
            SetupCategoryTable();
            SetupChildTable();
            SetupChildInfoTable();
            SetupParentsTable();
            SetupPersonalTable();
            SetupChildTable();
            SetupClassTable();
            SetupGroupTable();
            SetupListTable();
        }         
                           
        // CATEGORY
        private void SetupCategoryTable()
        {
            this.dataGridView4.Rows.Clear();
            List<Category> categories = Category.getCategories();

            foreach (Category item in categories)
            {
                this.dataGridView4.Rows.Add(item.id, item.name, item.description, "X");
            }

            categoryCounter = 0;

        }
               
        private void saveCategory(object sender, EventArgs e)
        {
            DataGridView categoriesTable = sender as DataGridView;
            foreach (Int32 i in Enumerable.Range(1, categoryCounter))
            {
                var row = dataGridView4.Rows[dataGridView4.RowCount - i - 1].Cells;
                Category newCategory = new Category();
                if (row[0].Value != null)
                    newCategory.id = Convert.ToInt32(row[0].Value);
                if (row[1].Value != null)
                    newCategory.name = row[1].Value.ToString();
                if (row[2].Value != null)
                    newCategory.description = row[1].Value.ToString();
                newCategory.AddInDB();
            }
            SetupCategoryTable();
        }

        private void dataGridView4_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex == -1 || e.ColumnIndex == -1) return;
            var cell = dataGridView4.Rows[e.RowIndex].Cells[e.ColumnIndex];
            if (cell.Value != null)
            {
                if (cell.Value.ToString() == "X")
                {
                    var id = dataGridView4.Rows[e.RowIndex].Cells[0].Value.ToString();
                    Category.RemoveFromID(id);
                }
            }
          
        }
              
        private void dataGridView4_RowsAdded(object sender, DataGridViewRowsAddedEventArgs e)
        {
            categoryCounter++;
        }

        // CHILD
        private void SetupChildTable()
        {
            this.dataGridView2.Rows.Clear();
            List<Child> childs = Child.getChild();

            foreach (Child item in childs)
            {
                this.dataGridView2.Rows.Add(item.id, item.id_child_info, item.id_parents, "X");
            }

            childCounter = 0;

        }
        private void saveChild(object sender, EventArgs e)
        {
            DataGridView childsTable = sender as DataGridView;
            foreach (Int32 i in Enumerable.Range(1, childCounter))
            {
                var row = dataGridView2.Rows[dataGridView2.RowCount - i - 1].Cells;
                Child newChild = new Child();
                if (row[0].Value != null)
                    newChild.id = Convert.ToInt32(row[0].Value);
                if (row[1].Value != null)
                    newChild.id_child_info = Convert.ToInt32(row[1].Value);
                if (row[2].Value != null)
                    newChild.id_parents = Convert.ToInt32(row[2].Value);
                newChild.AddInDB();
            }
            SetupChildTable();
        }

        private void dataGridView2_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex == -1 || e.ColumnIndex == -1) return;
            var cell = dataGridView2.Rows[e.RowIndex].Cells[e.ColumnIndex];
            if (cell.Value != null)
            {
                if (cell.Value.ToString() == "X")
                {
                    var id = dataGridView2.Rows[e.RowIndex].Cells[0].Value.ToString();
                    Child.RemoveFromID(id);
                }
            }
        }

        private void dataGridView2_RowsAdded(object sender, DataGridViewRowsAddedEventArgs e)
        {
            childCounter++;
        }

        // CHILD INFO
        private void SetupChildInfoTable()
        {
            this.dataGridView5.Rows.Clear();
            List<ChildInfo> childInfos = ChildInfo.getChildInfos();

            foreach (ChildInfo item in childInfos)
            {
                this.dataGridView5.Rows.Add(item.id, item.fio, item.dob, item.address, "X");
            }

            childInfoCounter = 0;
        }

        private void saveChildInfo(object sender, EventArgs e)
        {
            DataGridView childsInfoTable = sender as DataGridView;
            foreach (Int32 i in Enumerable.Range(1, childInfoCounter))
            {
                var row = dataGridView5.Rows[dataGridView5.RowCount - i - 1].Cells;
                ChildInfo newChildInfo = new ChildInfo();
                if (row[0].Value != null)
                    newChildInfo.id = Convert.ToInt32(row[0].Value);
                if (row[1].Value != null)
                    newChildInfo.fio = row[1].Value.ToString();
                if (row[2].Value != null)
                    newChildInfo.dob = Convert.ToDateTime(row[2].Value);
                if (row[3].Value != null)
                    newChildInfo.address = row[3].Value.ToString();
                newChildInfo.AddInDB();
            }
            SetupChildInfoTable();
        }

        private void dataGridView5_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
          
        }

        private void dataGridView5_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex == -1 || e.ColumnIndex == -1) return;
            var cell = dataGridView5.Rows[e.RowIndex].Cells[e.ColumnIndex];
            if (cell.Value != null)
            {
                if (cell.Value.ToString() == "X")
                {
                    var id = dataGridView5.Rows[e.RowIndex].Cells[0].Value.ToString();
                    ChildInfo.RemoveFromID(id);
                }
            }
        }

        private void dataGridView5_RowsAdded(object sender, DataGridViewRowsAddedEventArgs e)
        {
            childInfoCounter++;
        }

        // EVENT      
        private void SetupEventTable()
        {
            this.dataGridView3.Rows.Clear();
            List<Event> events = Event.getEvents();

            foreach (Event item in events)
            {
                this.dataGridView3.Rows.Add(item.id, item.description, item.date, item.note, item.price, "X");
            }

            eventCounter = 0;
        }

        private void saveEvent(object sender, EventArgs e)
        {
            DataGridView eventsTable = sender as DataGridView;
            foreach (Int32 i in Enumerable.Range(1, eventCounter))
            {
                var row = dataGridView3.Rows[dataGridView3.RowCount - i - 1].Cells;
                Event newEvent = new Event();
                if (row[0].Value != null)
                    newEvent.id = Convert.ToInt32(row[0].Value);
                if (row[1].Value != null)
                    newEvent.description = row[1].Value.ToString();
                if (row[2].Value != null)
                    newEvent.date = Convert.ToDateTime(row[2].Value);
                if (row[3].Value != null)
                    newEvent.note = row[3].Value.ToString();
                if (row[4].Value != null)
                    newEvent.price = Convert.ToInt32(row[4].Value);
                newEvent.AddInDB();
            }
            SetupEventTable();
        }

        private void dataGridView3_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex == -1 || e.ColumnIndex == -1) return;
            var cell = dataGridView3.Rows[e.RowIndex].Cells[e.ColumnIndex];
            if (cell.Value != null)
            {
                if (cell.Value.ToString() == "X")
                {
                    var id = dataGridView4.Rows[e.RowIndex].Cells[0].Value.ToString();
                    Event.RemoveFromID(id);
                }
            }

        }

        private void dataGridView3_RowsAdded(object sender, DataGridViewRowsAddedEventArgs e)
        {
            eventCounter++;
        }

        // GROUP 
        private void SetupGroupTable()
        {
            this.dataGridView1.Rows.Clear();
            List<Group> groups = Group.getGroups();

            foreach (Group item in groups)
            {
                this.dataGridView1.Rows.Add(item.id, item.id_personal, item.id_class, item.shedule, item.size, item.price, "X");
            }

            groupCounter = 0;
        }

        private void saveGroup(object sender, EventArgs e)
        {
            DataGridView groupsTable = sender as DataGridView;
            foreach (Int32 i in Enumerable.Range(1, groupCounter))
            {
                var row = dataGridView1.Rows[dataGridView1.RowCount - i - 1].Cells;
                Group newGroup = new Group();
                if (row[0].Value != null)
                    newGroup.id = Convert.ToInt32(row[0].Value);
                if (row[1].Value != null)
                    newGroup.id_personal = Convert.ToInt32(row[1].Value);
                if (row[2].Value != null)
                    newGroup.id_class = Convert.ToInt32(row[2].Value);
                if (row[3].Value != null)
                    newGroup.shedule = row[3].Value.ToString();
                if (row[4].Value != null)
                    newGroup.size = Convert.ToInt32(row[4].Value);
                if (row[5].Value != null)
                    newGroup.price = Convert.ToInt32(row[5].Value);
                newGroup.AddInDB();
            }
            SetupGroupTable();
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex == -1 || e.ColumnIndex == -1) return;
            var cell = dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex];
            if (cell.Value != null)
            {
                if (cell.Value.ToString() == "X")
                {
                    var id = dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString();
                    Group.RemoveFromID(id);
                }
            }
        }
        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dataGridView1_RowsAdded(object sender, DataGridViewRowsAddedEventArgs e)
        {
            groupCounter++;
        }

        // CLASS
        private void SetupClassTable()
        {
            this.dataGridView6.Rows.Clear();
            List<Class> classes = Class.getClass();

            foreach (Class item in classes)
            {
                this.dataGridView6.Rows.Add(item.id, item.name, item.description, item.note, item.category_id, "X");
            }

            classCounter = 0;

        }

        private void saveClass(object sender, EventArgs e)
        {
            DataGridView classesTable = sender as DataGridView;
            foreach (Int32 i in Enumerable.Range(1, classCounter))
            {
                var row = dataGridView6.Rows[dataGridView6.RowCount - i - 1].Cells;
                Class newClass = new Class();
                if (row[0].Value != null)
                    newClass.id = Convert.ToInt32(row[0].Value);
                if (row[1].Value != null)
                    newClass.name = row[1].Value.ToString();
                if (row[2].Value != null)
                    newClass.description = row[2].Value.ToString();
                if (row[3].Value != null)
                    newClass.note = row[3].Value.ToString();
                if (row[4].Value != null)
                    newClass.category_id = row[4].Value.ToString();             
                newClass.AddInDB();
            }
            SetupClassTable();
        }

        private void dataGridView6_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex == -1 || e.ColumnIndex == -1) return;
            var cell = dataGridView6.Rows[e.RowIndex].Cells[e.ColumnIndex];
            if (cell.Value != null)
            {
                if (cell.Value.ToString() == "X")
                {
                    var id = dataGridView6.Rows[e.RowIndex].Cells[0].Value.ToString();
                    Class.RemoveFromID(id);
                }
            }
        }

        private void dataGridView6_RowsAdded(object sender, DataGridViewRowsAddedEventArgs e)
        {
            classCounter++;
        }

        // LIST
        private void SetupListTable()
        {
            this.dataGridView7.Rows.Clear();
            List<List> lists = List.getLists();

            foreach (List item in lists)
            {
                this.dataGridView7.Rows.Add(item.id, item.id_child, item.id_group, item.id_event, "X");
            }

            listCounter = 0;

        }

        private void saveList(object sender, EventArgs e)
        {
            DataGridView listTable = sender as DataGridView;
            foreach (Int32 i in Enumerable.Range(1, listCounter))
            {
                var row = dataGridView7.Rows[dataGridView7.RowCount - i - 1].Cells;
                List newList = new List();
                if (row[0].Value != null)
                    newList.id = Convert.ToInt32(row[0].Value);
                if (row[1].Value != null)
                    newList.id_child = Convert.ToInt32(row[1].Value);
                if (row[2].Value != null)
                    newList.id_group = Convert.ToInt32(row[2].Value);
                if (row[3].Value != null)
                    newList.id_event = Convert.ToInt32(row[3].Value);               
                newList.AddInDB();
            }
            SetupListTable();
        }

        private void dataGridView7_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex == -1 || e.ColumnIndex == -1) return;
            var cell = dataGridView7.Rows[e.RowIndex].Cells[e.ColumnIndex];
            if (cell.Value != null)
            {
                if (cell.Value.ToString() == "X")
                {
                    var id = dataGridView7.Rows[e.RowIndex].Cells[0].Value.ToString();
                    List.RemoveFromID(id);
                }
            }
        }
        
        private void dataGridView7_RowsAdded(object sender, DataGridViewRowsAddedEventArgs e)
        {
            listCounter++;
        }

        // PARENTS
        private void SetupParentsTable()
        {
            this.dataGridView8.Rows.Clear();
            List<Parents> parents = Parents.getParents();

            foreach (Parents item in parents)
            {
                this.dataGridView8.Rows.Add(item.id, item.mother_fio, item.mother_dob, item.father_fio, item.father_dob, "X");
            }

            parentsCounter = 0;
        }

        private void saveParents(object sender, EventArgs e)
        {
            DataGridView ParentsTable = sender as DataGridView;
            foreach (Int32 i in Enumerable.Range(1, parentsCounter))
            {
                var row = dataGridView8.Rows[dataGridView8.RowCount - i - 1].Cells;
                Parents newParents = new Parents();
                if (row[0].Value != null)
                    newParents.id = Convert.ToInt32(row[0].Value);
                if (row[1].Value != null)
                    newParents.mother_fio = row[1].Value.ToString();
                if (row[2].Value != null)
                    newParents.mother_dob = Convert.ToDateTime(row[2].Value);
                if (row[3].Value != null)
                    newParents.father_fio = row[3].Value.ToString();
                if (row[4].Value != null)
                    newParents.father_dob = Convert.ToDateTime(row[4].Value);
                newParents.AddInDB();
            }
            SetupParentsTable();
        }

        private void dataGridView8_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex == -1 || e.ColumnIndex == -1) return;
            var cell = dataGridView8.Rows[e.RowIndex].Cells[e.ColumnIndex];
            if (cell.Value != null)
            {
                if (cell.Value.ToString() == "X")
                {
                    var id = dataGridView8.Rows[e.RowIndex].Cells[0].Value.ToString();
                    Parents.RemoveFromID(id);
                }
            }
        }

        private void dataGridView8_RowsAdded(object sender, DataGridViewRowsAddedEventArgs e)
        {
            parentsCounter++;
        }

        // PERSONAL
        private void SetupPersonalTable()
        {
            this.dataGridView9.Rows.Clear();
            List<Personal> personals = Personal.getPersonal();

            foreach (Personal item in personals)
            {
                this.dataGridView9.Rows.Add(item.id, item.fio, item.dob, item.qualification, "X");
            }

            personalCounter = 0;
        }

        private void savePersonal(object sender, EventArgs e)
        {
            DataGridView PersonalTable = sender as DataGridView;
            foreach (Int32 i in Enumerable.Range(1, parentsCounter))
            {
                var row = dataGridView9.Rows[dataGridView9.RowCount - i - 1].Cells;
                Personal newPersonal = new Personal();
                if (row[0].Value != null)
                    newPersonal.id = Convert.ToInt32(row[0].Value);
                if (row[1].Value != null)
                    newPersonal.fio = row[1].Value.ToString();
                if (row[2].Value != null)
                    newPersonal.dob = Convert.ToDateTime(row[2].Value);
                if (row[3].Value != null)
                    newPersonal.qualification = row[3].Value.ToString();

                newPersonal.AddInDB();
            }
            SetupPersonalTable();
        }

        private void dataGridView9_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex == -1 || e.ColumnIndex == -1) return;
            var cell = dataGridView9.Rows[e.RowIndex].Cells[e.ColumnIndex];
            if (cell.Value != null)
            {
                if (cell.Value.ToString() == "X")
                {
                    var id = dataGridView9.Rows[e.RowIndex].Cells[0].Value.ToString();
                    Personal.RemoveFromID(id);
                }
            }
        }

        private void dataGridView9_RowsAdded(object sender, DataGridViewRowsAddedEventArgs e)
        {
            personalCounter++;
        }





        private void dataGridView3_RowValidated(object sender, DataGridViewCellEventArgs e)
        {
        }

        private void materialListView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
        private void dataGridView4_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

    }
}
