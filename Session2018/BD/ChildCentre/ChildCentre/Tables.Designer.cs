namespace ChildCentre
{
    partial class Tables
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.close = new System.Windows.Forms.TabPage();
            this.events = new System.Windows.Forms.TabPage();
            this.dataGridView3 = new System.Windows.Forms.DataGridView();
            this.ID_EVENTS = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.CHILDS_EVENT = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.DESCRIPTION = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.DATE = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.NOTE = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.PRICE_EVENT = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.child = new System.Windows.Forms.TabPage();
            this.dataGridView2 = new System.Windows.Forms.DataGridView();
            this.ID_CHILD = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.FIO = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.DOB = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ADDRESS = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.MOTHER_FIO = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.MOTHER_DOB = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.FATHER_FIO = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.FATHER_DOB = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.group = new System.Windows.Forms.TabPage();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.ID = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.TEACHER = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.CHILDS = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.CLASS = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.SIZE = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.SHEDULE = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.events.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView3)).BeginInit();
            this.child.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).BeginInit();
            this.group.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.tabControl1.SuspendLayout();
            this.SuspendLayout();
            // 
            // close
            // 
            this.close.Location = new System.Drawing.Point(154, 4);
            this.close.Margin = new System.Windows.Forms.Padding(3, 50, 3, 3);
            this.close.Name = "close";
            this.close.Size = new System.Drawing.Size(664, 501);
            this.close.TabIndex = 3;
            this.close.Text = "CLOSE";
            this.close.UseVisualStyleBackColor = true;
            // 
            // events
            // 
            this.events.Controls.Add(this.dataGridView3);
            this.events.Location = new System.Drawing.Point(154, 4);
            this.events.Name = "events";
            this.events.Padding = new System.Windows.Forms.Padding(3);
            this.events.Size = new System.Drawing.Size(664, 501);
            this.events.TabIndex = 2;
            this.events.Text = "EVENTS";
            this.events.UseVisualStyleBackColor = true;
            // 
            // dataGridView3
            // 
            this.dataGridView3.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView3.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.ID_EVENTS,
            this.CHILDS_EVENT,
            this.DESCRIPTION,
            this.DATE,
            this.NOTE,
            this.PRICE_EVENT});
            this.dataGridView3.Location = new System.Drawing.Point(0, 0);
            this.dataGridView3.Name = "dataGridView3";
            this.dataGridView3.Size = new System.Drawing.Size(664, 498);
            this.dataGridView3.TabIndex = 0;
            // 
            // ID_EVENTS
            // 
            this.ID_EVENTS.HeaderText = "ID";
            this.ID_EVENTS.Name = "ID_EVENTS";
            this.ID_EVENTS.ReadOnly = true;
            // 
            // CHILDS_EVENT
            // 
            this.CHILDS_EVENT.HeaderText = "CHILDS";
            this.CHILDS_EVENT.Name = "CHILDS_EVENT";
            this.CHILDS_EVENT.ReadOnly = true;
            // 
            // DESCRIPTION
            // 
            this.DESCRIPTION.HeaderText = "DESCRIPTION";
            this.DESCRIPTION.Name = "DESCRIPTION";
            this.DESCRIPTION.ReadOnly = true;
            // 
            // DATE
            // 
            this.DATE.HeaderText = "DATE";
            this.DATE.Name = "DATE";
            this.DATE.ReadOnly = true;
            // 
            // NOTE
            // 
            this.NOTE.HeaderText = "NOTE";
            this.NOTE.Name = "NOTE";
            this.NOTE.ReadOnly = true;
            // 
            // PRICE_EVENT
            // 
            this.PRICE_EVENT.HeaderText = "PRICE-EVENT";
            this.PRICE_EVENT.Name = "PRICE_EVENT";
            this.PRICE_EVENT.ReadOnly = true;
            // 
            // child
            // 
            this.child.Controls.Add(this.dataGridView2);
            this.child.Location = new System.Drawing.Point(154, 4);
            this.child.Name = "child";
            this.child.Padding = new System.Windows.Forms.Padding(3);
            this.child.Size = new System.Drawing.Size(664, 501);
            this.child.TabIndex = 1;
            this.child.Text = "CHILD";
            this.child.UseVisualStyleBackColor = true;
            // 
            // dataGridView2
            // 
            this.dataGridView2.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView2.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.ID_CHILD,
            this.FIO,
            this.DOB,
            this.ADDRESS,
            this.MOTHER_FIO,
            this.MOTHER_DOB,
            this.FATHER_FIO,
            this.FATHER_DOB});
            this.dataGridView2.Location = new System.Drawing.Point(0, 0);
            this.dataGridView2.Name = "dataGridView2";
            this.dataGridView2.Size = new System.Drawing.Size(664, 495);
            this.dataGridView2.TabIndex = 0;
            this.dataGridView2.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView2_CellContentClick);
            // 
            // ID_CHILD
            // 
            this.ID_CHILD.HeaderText = "ID";
            this.ID_CHILD.Name = "ID_CHILD";
            // 
            // FIO
            // 
            this.FIO.HeaderText = "FIO";
            this.FIO.Name = "FIO";
            this.FIO.ReadOnly = true;
            // 
            // DOB
            // 
            this.DOB.HeaderText = "DOB";
            this.DOB.Name = "DOB";
            this.DOB.ReadOnly = true;
            // 
            // ADDRESS
            // 
            this.ADDRESS.HeaderText = "ADDRESS";
            this.ADDRESS.Name = "ADDRESS";
            this.ADDRESS.ReadOnly = true;
            // 
            // MOTHER_FIO
            // 
            this.MOTHER_FIO.HeaderText = "MOTHER FIO";
            this.MOTHER_FIO.Name = "MOTHER_FIO";
            this.MOTHER_FIO.ReadOnly = true;
            // 
            // MOTHER_DOB
            // 
            this.MOTHER_DOB.HeaderText = "MOTHER DOB";
            this.MOTHER_DOB.Name = "MOTHER_DOB";
            this.MOTHER_DOB.ReadOnly = true;
            // 
            // FATHER_FIO
            // 
            this.FATHER_FIO.HeaderText = "FATHER FIO";
            this.FATHER_FIO.Name = "FATHER_FIO";
            this.FATHER_FIO.ReadOnly = true;
            // 
            // FATHER_DOB
            // 
            this.FATHER_DOB.HeaderText = "FATHER DOB";
            this.FATHER_DOB.Name = "FATHER_DOB";
            this.FATHER_DOB.ReadOnly = true;
            // 
            // group
            // 
            this.group.Controls.Add(this.dataGridView1);
            this.group.Location = new System.Drawing.Point(154, 4);
            this.group.Name = "group";
            this.group.Padding = new System.Windows.Forms.Padding(3);
            this.group.Size = new System.Drawing.Size(664, 501);
            this.group.TabIndex = 0;
            this.group.Text = "GROUP";
            this.group.UseVisualStyleBackColor = true;
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.ID,
            this.TEACHER,
            this.CHILDS,
            this.CLASS,
            this.SIZE,
            this.SHEDULE});
            this.dataGridView1.Location = new System.Drawing.Point(0, -4);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(664, 505);
            this.dataGridView1.TabIndex = 0;
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 
            // ID
            // 
            this.ID.HeaderText = "ID";
            this.ID.Name = "ID";
            this.ID.ReadOnly = true;
            // 
            // TEACHER
            // 
            this.TEACHER.HeaderText = "TEACHER";
            this.TEACHER.Name = "TEACHER";
            this.TEACHER.ReadOnly = true;
            // 
            // CHILDS
            // 
            this.CHILDS.HeaderText = "CHILDS";
            this.CHILDS.Name = "CHILDS";
            this.CHILDS.ReadOnly = true;
            // 
            // CLASS
            // 
            this.CLASS.HeaderText = "CLASS";
            this.CLASS.Name = "CLASS";
            this.CLASS.ReadOnly = true;
            // 
            // SIZE
            // 
            this.SIZE.HeaderText = "SIZE";
            this.SIZE.Name = "SIZE";
            this.SIZE.ReadOnly = true;
            // 
            // SHEDULE
            // 
            this.SHEDULE.HeaderText = "SHEDULE";
            this.SHEDULE.Name = "SHEDULE";
            this.SHEDULE.ReadOnly = true;
            // 
            // tabControl1
            // 
            this.tabControl1.Alignment = System.Windows.Forms.TabAlignment.Left;
            this.tabControl1.Controls.Add(this.group);
            this.tabControl1.Controls.Add(this.child);
            this.tabControl1.Controls.Add(this.events);
            this.tabControl1.Controls.Add(this.close);
            this.tabControl1.DrawMode = System.Windows.Forms.TabDrawMode.OwnerDrawFixed;
            this.tabControl1.ItemSize = new System.Drawing.Size(25, 150);
            this.tabControl1.Location = new System.Drawing.Point(1, 0);
            this.tabControl1.Multiline = true;
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(822, 509);
            this.tabControl1.SizeMode = System.Windows.Forms.TabSizeMode.Fixed;
            this.tabControl1.TabIndex = 0;
            this.tabControl1.DrawItem += new System.Windows.Forms.DrawItemEventHandler(this.tabControl1_DrawItem);
            this.tabControl1.SelectedIndexChanged += new System.EventHandler(this.tabControl1_SelectedIndexChanged);
            // 
            // Tables
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(824, 511);
            this.Controls.Add(this.tabControl1);
            this.Name = "Tables";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "CHILD CENTRE - TABLES";
            this.Load += new System.EventHandler(this.Tables_Load);
            this.events.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView3)).EndInit();
            this.child.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).EndInit();
            this.group.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.tabControl1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabPage close;
        private System.Windows.Forms.TabPage events;
        private System.Windows.Forms.DataGridView dataGridView3;
        private System.Windows.Forms.DataGridViewTextBoxColumn ID_EVENTS;
        private System.Windows.Forms.DataGridViewTextBoxColumn CHILDS_EVENT;
        private System.Windows.Forms.DataGridViewTextBoxColumn DESCRIPTION;
        private System.Windows.Forms.DataGridViewTextBoxColumn DATE;
        private System.Windows.Forms.DataGridViewTextBoxColumn NOTE;
        private System.Windows.Forms.DataGridViewTextBoxColumn PRICE_EVENT;
        private System.Windows.Forms.TabPage child;
        private System.Windows.Forms.DataGridView dataGridView2;
        private System.Windows.Forms.DataGridViewTextBoxColumn ID_CHILD;
        private System.Windows.Forms.DataGridViewTextBoxColumn FIO;
        private System.Windows.Forms.DataGridViewTextBoxColumn DOB;
        private System.Windows.Forms.DataGridViewTextBoxColumn ADDRESS;
        private System.Windows.Forms.DataGridViewTextBoxColumn MOTHER_FIO;
        private System.Windows.Forms.DataGridViewTextBoxColumn MOTHER_DOB;
        private System.Windows.Forms.DataGridViewTextBoxColumn FATHER_FIO;
        private System.Windows.Forms.DataGridViewTextBoxColumn FATHER_DOB;
        private System.Windows.Forms.TabPage group;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn ID;
        private System.Windows.Forms.DataGridViewTextBoxColumn TEACHER;
        private System.Windows.Forms.DataGridViewTextBoxColumn CHILDS;
        private System.Windows.Forms.DataGridViewTextBoxColumn CLASS;
        private System.Windows.Forms.DataGridViewTextBoxColumn SIZE;
        private System.Windows.Forms.DataGridViewTextBoxColumn SHEDULE;
        private System.Windows.Forms.TabControl tabControl1;
    }
}