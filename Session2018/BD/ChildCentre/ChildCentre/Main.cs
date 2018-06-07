using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChildCentre
{
    public partial class Main : Form
    {
        public Main()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        //private DBConnection dbconnect;
        //public DBConnection DBConnect(
        //{
        //    get
        //    {
        //        dbconnect = DBConnection.Instance();
        //        dbconnect.DatabaseName = "ChildCentre";
        //        return dbconnect;
        //    }
        //}

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
    }
}
