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
    public partial class Tables : Form
    {
        public Tables()
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

                _textBrush = new SolidBrush(Color.Red);

                g.FillRectangle(Brushes.Gray, e.Bounds);

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
                main.Show();
            }
        }
    }
}
