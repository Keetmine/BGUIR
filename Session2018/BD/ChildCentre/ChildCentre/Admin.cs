using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;

namespace ChildCentre
{
    public partial class Admin : Form
    {

        Int32 eventCounter = 0;
        Int32 childCounter = 0;
        Int32 childInfoCounter = 0;
        Int32 classCounter = 0;
        Int32 groupCounter = 0;
        Int32 listCounter = 0;
        Int32 parentsCounter = 0;
        Int32 personalCounter = 0;

        public Admin()
        {
            InitializeComponent();
        }

        private void tabControl1_DrawItem(object sender, DrawItemEventArgs e)
        {
            Graphics g = e.Graphics;
            Brush _textBrush;
            
            // Get the item from the collection.
            TabPage _tabPage = tabControl1.TabPages[e.Index];

            // Get the real bounds for the tab rectangle.
            Rectangle _tabBounds = tabControl1.GetTabRect(e.Index);

            if (e.State == DrawItemState.Selected)
            {
                // Draw a different background color, and don't paint a focus rectangle.
                _textBrush = new SolidBrush(Color.Black);
                g.FillRectangle(Brushes.LightGray, e.Bounds);
            }
            else
            {
                _textBrush = new System.Drawing.SolidBrush(e.ForeColor);
                e.DrawBackground();
            }

            // Use our own font.
            Font _tabFont = new Font("Arial", (float)10.0, FontStyle.Bold, GraphicsUnit.Pixel);

            // Draw string. Center the text.
            StringFormat _stringFlags = new StringFormat();
            _stringFlags.Alignment = StringAlignment.Center;
            _stringFlags.LineAlignment = StringAlignment.Center;
            g.DrawString(_tabPage.Text, _tabFont, _textBrush, _tabBounds, new StringFormat(_stringFlags));
        }


        private void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            TabPage tab = (sender as TabControl).SelectedTab;
            Main main = new Main();
            Console.WriteLine(tab.Name);
            if (tab.Name == "close")
            {
                this.Hide();
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

        private void SetupEventTable()
        {
            List<Event> events = Event.getEvents();

            foreach (Event item in events)
            {
                this.dataGridView3.Rows.Add(item.id, item.description, item.date, item.note, item.price, "X");
            }

            eventCounter = 0;
        }

        private void SetupCategoryTable()
        {
            List<Category> categories = Category.getCategories();

            foreach (Category item in categories)
            {
                this.dataGridView4.Rows.Add(item.id, item.name, item.description, "X");
            }
        
        }
            
        private void SetupChildInfoTable()
        {
            List<ChildInfo> childInfos = ChildInfo.getChildInfos();

            foreach (ChildInfo item in childInfos)
            {
                this.dataGridView5.Rows.Add(item.id, item.fio, item.dob, item.address, "X");
            }

        }

        private void SetupParentsTable()
        {
            List<Parents> parents = Parents.getParents();

            foreach (Parents item in parents)
            {
                this.dataGridView8.Rows.Add(item.id, item.mother_fio, item.mother_dob, item.father_fio, item.father_dob, "X");
            }

        }

        private void SetupPersonalTable()
        {
            List<Personal> personals = Personal.getPersonal();

            foreach (Personal item in personals)
            {
                this.dataGridView9.Rows.Add(item.id, item.fio, item.dob, item.qualification, "X");
            }

        }

        private void SetupChildTable()
        {
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
        }

        private void SetupClassTable()
        {
            List<Class> classes = Class.getClass();

            foreach (Class item in classes)
            {
                this.dataGridView6.Rows.Add(item.id, item.name, item.description, item.note, item.category_id, "X");
            }

        }

        private void SetupGroupTable()
        {
            List<Group> groups = Group.getGroups();

            foreach (Group item in groups)
            {
                this.dataGridView1.Rows.Add(item.id, item.id_personal,item.id_class, item.shedule, item.size, item.price, "X");
            }

        }

        private void SetupListTable()
        {
            List<List> lists = List.getLists();

            foreach (List item in lists)
            {
                this.dataGridView7.Rows.Add(item.id, item.id_child, item.id_group, item.id_event, "X");
            }

        }
        private void dataGridView3_RowsAdded(object sender, DataGridViewRowsAddedEventArgs e)
        {
            eventCounter++;    
        }

        private void dataGridView3_RowValidated(object sender, DataGridViewCellEventArgs e)
        {
          

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
        }


        private void dataGridView3_CellClick(object sender, DataGridViewCellEventArgs e)
        {           
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

        private void dataGridView4_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dataGridView4_CellClick(object sender, DataGridViewCellEventArgs e)
        {
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

        }

        private void dataGridView2_CellClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dataGridView2_RowsAdded(object sender, DataGridViewRowsAddedEventArgs e)
        {
            childCounter++;
        }
    }
}
