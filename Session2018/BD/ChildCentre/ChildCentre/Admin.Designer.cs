namespace ChildCentre
{
    partial class Admin
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
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.categoty = new System.Windows.Forms.TabPage();
            this.child = new System.Windows.Forms.TabPage();
            this.dataGridView2 = new System.Windows.Forms.DataGridView();
            this.child_info = new System.Windows.Forms.TabPage();
            this.events = new System.Windows.Forms.TabPage();
            this.dataGridView3 = new System.Windows.Forms.DataGridView();
            this.group = new System.Windows.Forms.TabPage();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.group_class = new System.Windows.Forms.TabPage();
            this.list = new System.Windows.Forms.TabPage();
            this.parents = new System.Windows.Forms.TabPage();
            this.personal = new System.Windows.Forms.TabPage();
            this.personal_info = new System.Windows.Forms.TabPage();
            this.close = new System.Windows.Forms.TabPage();
            this.dataGridView4 = new System.Windows.Forms.DataGridView();
            this.ID_CHILD = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.id_child_info = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.id_parents = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.id_category = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.categoty_description = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridView5 = new System.Windows.Forms.DataGridView();
            this.idChildInfo = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.fio = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dob = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.address = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ID_EVENTS = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.DESCRIPTION = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.DATE = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.NOTE = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.PRICE_EVENT = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.ID = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.TEACHER = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.CHILDS = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.CLASS = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.SIZE = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.SHEDULE = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.price = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridView6 = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.class_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.class_description = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.category_id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.category_note = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridView7 = new System.Windows.Forms.DataGridView();
            this.id_list = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.child_id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.id_group = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.id_event = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.tabControl1.SuspendLayout();
            this.categoty.SuspendLayout();
            this.child.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).BeginInit();
            this.child_info.SuspendLayout();
            this.events.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView3)).BeginInit();
            this.group.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.group_class.SuspendLayout();
            this.list.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView5)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView6)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView7)).BeginInit();
            this.SuspendLayout();
            // 
            // tabControl1
            // 
            this.tabControl1.Alignment = System.Windows.Forms.TabAlignment.Left;
            this.tabControl1.Controls.Add(this.categoty);
            this.tabControl1.Controls.Add(this.child);
            this.tabControl1.Controls.Add(this.child_info);
            this.tabControl1.Controls.Add(this.events);
            this.tabControl1.Controls.Add(this.group);
            this.tabControl1.Controls.Add(this.group_class);
            this.tabControl1.Controls.Add(this.list);
            this.tabControl1.Controls.Add(this.parents);
            this.tabControl1.Controls.Add(this.personal);
            this.tabControl1.Controls.Add(this.personal_info);
            this.tabControl1.Controls.Add(this.close);
            this.tabControl1.DrawMode = System.Windows.Forms.TabDrawMode.OwnerDrawFixed;
            this.tabControl1.ItemSize = new System.Drawing.Size(25, 150);
            this.tabControl1.Location = new System.Drawing.Point(1, 1);
            this.tabControl1.Multiline = true;
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(822, 509);
            this.tabControl1.SizeMode = System.Windows.Forms.TabSizeMode.Fixed;
            this.tabControl1.TabIndex = 1;
            this.tabControl1.DrawItem += new System.Windows.Forms.DrawItemEventHandler(this.tabControl1_DrawItem);
            this.tabControl1.SelectedIndexChanged += new System.EventHandler(this.tabControl1_SelectedIndexChanged);
            // 
            // categoty
            // 
            this.categoty.Controls.Add(this.dataGridView4);
            this.categoty.Location = new System.Drawing.Point(154, 4);
            this.categoty.Name = "categoty";
            this.categoty.Size = new System.Drawing.Size(664, 501);
            this.categoty.TabIndex = 4;
            this.categoty.Text = "CATEGORY";
            this.categoty.UseVisualStyleBackColor = true;
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
            this.id_child_info,
            this.id_parents});
            this.dataGridView2.Location = new System.Drawing.Point(0, 0);
            this.dataGridView2.Name = "dataGridView2";
            this.dataGridView2.Size = new System.Drawing.Size(664, 495);
            this.dataGridView2.TabIndex = 0;
            // 
            // child_info
            // 
            this.child_info.Controls.Add(this.dataGridView5);
            this.child_info.Location = new System.Drawing.Point(154, 4);
            this.child_info.Name = "child_info";
            this.child_info.Size = new System.Drawing.Size(664, 501);
            this.child_info.TabIndex = 5;
            this.child_info.Text = "CHILD INFORMATION";
            this.child_info.UseVisualStyleBackColor = true;
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
            this.DESCRIPTION,
            this.DATE,
            this.NOTE,
            this.PRICE_EVENT});
            this.dataGridView3.Location = new System.Drawing.Point(0, 0);
            this.dataGridView3.Name = "dataGridView3";
            this.dataGridView3.Size = new System.Drawing.Size(664, 498);
            this.dataGridView3.TabIndex = 0;
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
            this.SHEDULE,
            this.price});
            this.dataGridView1.Location = new System.Drawing.Point(0, -4);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(664, 505);
            this.dataGridView1.TabIndex = 0;
            // 
            // group_class
            // 
            this.group_class.Controls.Add(this.dataGridView6);
            this.group_class.Location = new System.Drawing.Point(154, 4);
            this.group_class.Name = "group_class";
            this.group_class.Size = new System.Drawing.Size(664, 501);
            this.group_class.TabIndex = 6;
            this.group_class.Text = "CLASS";
            this.group_class.UseVisualStyleBackColor = true;
            // 
            // list
            // 
            this.list.Controls.Add(this.dataGridView7);
            this.list.Location = new System.Drawing.Point(154, 4);
            this.list.Name = "list";
            this.list.Size = new System.Drawing.Size(664, 501);
            this.list.TabIndex = 7;
            this.list.Text = "LiST";
            this.list.UseVisualStyleBackColor = true;
            // 
            // parents
            // 
            this.parents.Location = new System.Drawing.Point(154, 4);
            this.parents.Name = "parents";
            this.parents.Size = new System.Drawing.Size(664, 501);
            this.parents.TabIndex = 8;
            this.parents.Text = "PARENTS";
            this.parents.UseVisualStyleBackColor = true;
            // 
            // personal
            // 
            this.personal.Location = new System.Drawing.Point(154, 4);
            this.personal.Name = "personal";
            this.personal.Size = new System.Drawing.Size(664, 501);
            this.personal.TabIndex = 9;
            this.personal.Text = "PERSONAL";
            this.personal.UseVisualStyleBackColor = true;
            // 
            // personal_info
            // 
            this.personal_info.Location = new System.Drawing.Point(154, 4);
            this.personal_info.Name = "personal_info";
            this.personal_info.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.personal_info.Size = new System.Drawing.Size(664, 501);
            this.personal_info.TabIndex = 10;
            this.personal_info.Text = "PERSONAL INFORMATION";
            this.personal_info.UseVisualStyleBackColor = true;
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
            // dataGridView4
            // 
            this.dataGridView4.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView4.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.id_category,
            this.name,
            this.categoty_description});
            this.dataGridView4.Location = new System.Drawing.Point(0, 3);
            this.dataGridView4.Name = "dataGridView4";
            this.dataGridView4.Size = new System.Drawing.Size(664, 495);
            this.dataGridView4.TabIndex = 1;
            // 
            // ID_CHILD
            // 
            this.ID_CHILD.HeaderText = "ID";
            this.ID_CHILD.Name = "ID_CHILD";
            // 
            // id_child_info
            // 
            this.id_child_info.HeaderText = "ID CHILD INFORMATION";
            this.id_child_info.Name = "id_child_info";
            // 
            // id_parents
            // 
            this.id_parents.HeaderText = "ID PARENTS";
            this.id_parents.Name = "id_parents";
            // 
            // id_category
            // 
            this.id_category.HeaderText = "ID";
            this.id_category.Name = "id_category";
            // 
            // name
            // 
            this.name.HeaderText = "NAME";
            this.name.Name = "name";
            // 
            // categoty_description
            // 
            this.categoty_description.HeaderText = "DESCRIPTION";
            this.categoty_description.Name = "categoty_description";
            // 
            // dataGridView5
            // 
            this.dataGridView5.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView5.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idChildInfo,
            this.fio,
            this.dob,
            this.address});
            this.dataGridView5.Location = new System.Drawing.Point(0, 3);
            this.dataGridView5.Name = "dataGridView5";
            this.dataGridView5.Size = new System.Drawing.Size(664, 495);
            this.dataGridView5.TabIndex = 1;
            // 
            // idChildInfo
            // 
            this.idChildInfo.HeaderText = "ID";
            this.idChildInfo.Name = "idChildInfo";
            // 
            // fio
            // 
            this.fio.HeaderText = "FIO";
            this.fio.Name = "fio";
            // 
            // dob
            // 
            this.dob.HeaderText = "DOB";
            this.dob.Name = "dob";
            // 
            // address
            // 
            this.address.HeaderText = "ADDRESS";
            this.address.Name = "address";
            // 
            // ID_EVENTS
            // 
            this.ID_EVENTS.HeaderText = "ID";
            this.ID_EVENTS.Name = "ID_EVENTS";
            this.ID_EVENTS.ReadOnly = true;
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
            this.PRICE_EVENT.HeaderText = "PRICE EVENT";
            this.PRICE_EVENT.Name = "PRICE_EVENT";
            this.PRICE_EVENT.ReadOnly = true;
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
            // price
            // 
            this.price.HeaderText = "PRICE";
            this.price.Name = "price";
            // 
            // dataGridView6
            // 
            this.dataGridView6.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView6.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn1,
            this.class_name,
            this.class_description,
            this.category_id,
            this.category_note});
            this.dataGridView6.Location = new System.Drawing.Point(0, 1);
            this.dataGridView6.Name = "dataGridView6";
            this.dataGridView6.Size = new System.Drawing.Size(664, 498);
            this.dataGridView6.TabIndex = 1;
            // 
            // dataGridViewTextBoxColumn1
            // 
            this.dataGridViewTextBoxColumn1.HeaderText = "ID";
            this.dataGridViewTextBoxColumn1.Name = "dataGridViewTextBoxColumn1";
            this.dataGridViewTextBoxColumn1.ReadOnly = true;
            // 
            // class_name
            // 
            this.class_name.HeaderText = "NAME";
            this.class_name.Name = "class_name";
            // 
            // class_description
            // 
            this.class_description.HeaderText = "DESCRIPTION";
            this.class_description.Name = "class_description";
            this.class_description.ReadOnly = true;
            // 
            // category_id
            // 
            this.category_id.HeaderText = "CATEGORY";
            this.category_id.Name = "category_id";
            this.category_id.ReadOnly = true;
            // 
            // category_note
            // 
            this.category_note.HeaderText = "NOTE";
            this.category_note.Name = "category_note";
            // 
            // dataGridView7
            // 
            this.dataGridView7.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView7.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.id_list,
            this.child_id,
            this.id_group,
            this.id_event});
            this.dataGridView7.Location = new System.Drawing.Point(0, 1);
            this.dataGridView7.Name = "dataGridView7";
            this.dataGridView7.Size = new System.Drawing.Size(664, 498);
            this.dataGridView7.TabIndex = 2;
            // 
            // id_list
            // 
            this.id_list.HeaderText = "ID";
            this.id_list.Name = "id_list";
            this.id_list.ReadOnly = true;
            // 
            // child_id
            // 
            this.child_id.HeaderText = "CHILD";
            this.child_id.Name = "child_id";
            // 
            // id_group
            // 
            this.id_group.HeaderText = "GROUP";
            this.id_group.Name = "id_group";
            this.id_group.ReadOnly = true;
            // 
            // id_event
            // 
            this.id_event.HeaderText = "EVENT";
            this.id_event.Name = "id_event";
            this.id_event.ReadOnly = true;
            // 
            // Admin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(824, 511);
            this.Controls.Add(this.tabControl1);
            this.Name = "Admin";
            this.Text = "CHILD CENTRE - ADMINISTRATION";
            this.tabControl1.ResumeLayout(false);
            this.categoty.ResumeLayout(false);
            this.child.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).EndInit();
            this.child_info.ResumeLayout(false);
            this.events.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView3)).EndInit();
            this.group.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.group_class.ResumeLayout(false);
            this.list.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView5)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView6)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView7)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage categoty;
        private System.Windows.Forms.TabPage child;
        private System.Windows.Forms.DataGridView dataGridView2;
        private System.Windows.Forms.TabPage child_info;
        private System.Windows.Forms.TabPage events;
        private System.Windows.Forms.DataGridView dataGridView3;
        private System.Windows.Forms.TabPage group;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.TabPage group_class;
        private System.Windows.Forms.TabPage list;
        private System.Windows.Forms.TabPage parents;
        private System.Windows.Forms.TabPage personal;
        private System.Windows.Forms.TabPage personal_info;
        private System.Windows.Forms.TabPage close;
        private System.Windows.Forms.DataGridView dataGridView4;
        private System.Windows.Forms.DataGridViewTextBoxColumn id_category;
        private System.Windows.Forms.DataGridViewTextBoxColumn name;
        private System.Windows.Forms.DataGridViewTextBoxColumn categoty_description;
        private System.Windows.Forms.DataGridViewTextBoxColumn ID_CHILD;
        private System.Windows.Forms.DataGridViewTextBoxColumn id_child_info;
        private System.Windows.Forms.DataGridViewTextBoxColumn id_parents;
        private System.Windows.Forms.DataGridView dataGridView5;
        private System.Windows.Forms.DataGridViewTextBoxColumn idChildInfo;
        private System.Windows.Forms.DataGridViewTextBoxColumn fio;
        private System.Windows.Forms.DataGridViewTextBoxColumn dob;
        private System.Windows.Forms.DataGridViewTextBoxColumn address;
        private System.Windows.Forms.DataGridViewTextBoxColumn ID_EVENTS;
        private System.Windows.Forms.DataGridViewTextBoxColumn DESCRIPTION;
        private System.Windows.Forms.DataGridViewTextBoxColumn DATE;
        private System.Windows.Forms.DataGridViewTextBoxColumn NOTE;
        private System.Windows.Forms.DataGridViewTextBoxColumn PRICE_EVENT;
        private System.Windows.Forms.DataGridViewTextBoxColumn ID;
        private System.Windows.Forms.DataGridViewTextBoxColumn TEACHER;
        private System.Windows.Forms.DataGridViewTextBoxColumn CHILDS;
        private System.Windows.Forms.DataGridViewTextBoxColumn CLASS;
        private System.Windows.Forms.DataGridViewTextBoxColumn SIZE;
        private System.Windows.Forms.DataGridViewTextBoxColumn SHEDULE;
        private System.Windows.Forms.DataGridViewTextBoxColumn price;
        private System.Windows.Forms.DataGridView dataGridView6;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn class_name;
        private System.Windows.Forms.DataGridViewTextBoxColumn class_description;
        private System.Windows.Forms.DataGridViewTextBoxColumn category_id;
        private System.Windows.Forms.DataGridViewTextBoxColumn category_note;
        private System.Windows.Forms.DataGridView dataGridView7;
        private System.Windows.Forms.DataGridViewTextBoxColumn id_list;
        private System.Windows.Forms.DataGridViewTextBoxColumn child_id;
        private System.Windows.Forms.DataGridViewTextBoxColumn id_group;
        private System.Windows.Forms.DataGridViewTextBoxColumn id_event;
    }
}