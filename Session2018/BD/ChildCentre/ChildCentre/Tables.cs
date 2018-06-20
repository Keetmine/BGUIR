using MaterialSkin;
using MaterialSkin.Controls;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;

namespace ChildCentre
{
    public partial class Tables : MaterialForm
    {
        public User user;
        public Tables()
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

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dataGridView2_CellContentClick(object sender, DataGridViewCellEventArgs e)
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
                this.user.updateLastLogout();
                main.Show();
            }
        }

        private void Tables_Load(object sender, EventArgs e)
        {
            SetupEventTable();
            SetupRemovedEventsTable();
        }



        private void SetupEventTable(string search="")
        {
            List<Event> events =  Event.getEvents(search);
            this.dataGridView3.Rows.Clear();
            foreach (Event item in events)
            {
                this.dataGridView3.Rows.Add(item.id, item.getChildsName(), item.description, item.date, item.note, item.price);
            }
        }

        private void SetupRemovedEventsTable()
        {
            List<Removed_events> events = Removed_events.getEvents();

            foreach (Removed_events item in events)
            {
                this.dataGridView4.Rows.Add(item.id, item.getChildsName(), item.description, item.date, item.note, item.price);
            }
        }

        private void tabPage1_Click(object sender, EventArgs e)
        {

        }

        private void dataGridView4_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dataGridView5_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void materialRaisedButton1_Click(object sender, EventArgs e)
        {
            string search = materialSingleLineTextField1.Text.ToString();
            if (search != "") SetupEventTable(search);
      
        }

        private void materialRaisedButton2_Click(object sender, EventArgs e)
        {
            SetupEventTable();
            materialSingleLineTextField1.Text = "";
        }
    }
}
