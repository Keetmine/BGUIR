using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChildCentre
{
    public class Child
    {
        public long id { get; set; }
        public long id_child_info { get; set; }
        public long id_parents { get; set; }
        public child_info info { get; set; }
        public parents parents { get; set; }
    }
}
