using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie1
{
    class Program
    {
        static void Main(string[] args)
        {

            List<Process> list = new List<Process>();

            Console.WriteLine("1. Open notepad");
            Console.WriteLine("2. Close last process notepad");
            Console.WriteLine("3. Close all process");

            Console.Write("Enter: ");

            string select = Console.ReadLine();

            while (true)
            {
                switch (select)
                {
                    case "1":
                        ProcessStartInfo startInfo = new ProcessStartInfo();
                        startInfo.FileName = "notepad.exe";

                        Process newProcess = new Process();
                        newProcess.StartInfo = startInfo;
                        newProcess.Start();

                        list.Add(newProcess);

                        break;

                    case "2":
                        if (list.Count > 0)
                        {
                            Process lastProcess = list.Last<Process>();

                            lastProcess.Kill();

                            list.Remove(lastProcess);
                        }
                        break;

                    case "3":
                        if (list.Count > 0)
                        {
                            foreach(Process proc in list)
                            {
                                proc.Kill();
                            }

                            list = new List<Process>();
                           
                        }
                        break;
                }

                select = Console.ReadLine();
            }
        }
    }
}
