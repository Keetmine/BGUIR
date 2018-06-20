using MaterialSkin;
using MaterialSkin.Controls;
using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace ChildCentre
{
    public partial class Main : MaterialForm
    {
        User user = new User();

        public Main()
        {
            InitializeComponent();

            var materialSkinManager = MaterialSkinManager.Instance;
            materialSkinManager.AddFormToManage(this);
            materialSkinManager.Theme = MaterialSkinManager.Themes.LIGHT;
            materialSkinManager.ColorScheme = new ColorScheme(Primary.BlueGrey800, Primary.BlueGrey900, Primary.BlueGrey500, Accent.LightBlue200, TextShade.WHITE);

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            

            Tables table = new Tables();
            table.Show();
            this.Hide();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Admin admin = new Admin();
            admin.Show();
            this.Hide();
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void materialRaisedButton1_Click(object sender, EventArgs e)
        {
            List<User> users = User.getUsers();
            var login = this.materialSingleLineTextField1.Text;
            var pass = this.materialSingleLineTextField2.Text;
            foreach (User item in users)
            {
                if (item.name == login && item.password == pass)
                {
                    item.updateLastSign();
                    this.user = item;
                    if (item.isAdmin == true)
                    {                       
                        Admin admin = new Admin();
                        admin.user = item;
                        admin.Show();
                        this.Hide();
                    } else
                    {
                        Tables tables = new Tables();
                        tables.user = item;
                        tables.Show();
                        this.Hide();
                    }
                    return;
                }            
            }
            MessageBox.Show("Wrong login or password");
        }

        private void materialSingleLineTextField2_Click(object sender, EventArgs e)
        {

        }
    }
}
