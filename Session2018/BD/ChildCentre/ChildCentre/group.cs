using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChildCentre
{
    public class Group
    {
        public long id { get; set; }
        public long id_personal { get; set; }
        public long id_list_child { get; set; }
        public long id_class { get; set; }
        public string shedule { get; set; }
        public int size { get; set; }
        public int price { get; set; }
    }
}
