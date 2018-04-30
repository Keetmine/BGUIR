using System;
using System.IO;
using System.IO.Pipes;
using System.Windows.Forms;

namespace ping2
{
    class Program
    {
        static void Main(string[] args)
        {
            if (args.Length > 0)
            {
                using (PipeStream pipeClient =
                    new AnonymousPipeClientStream(PipeDirection.In, args[0]))
                {
                    // Show that anonymous Pipes do not support Message mode.
                    try
                    {
                        pipeClient.ReadMode = PipeTransmissionMode.Message;
                    }
                    catch (NotSupportedException e)
                    {
                        Console.WriteLine("[CLIENT] Execption:\n    {0}", e.Message);
                    }

                    using (StreamReader sr = new StreamReader(pipeClient))
                    {
                        // Display the read text to the console
                        string temp;

                        // Wait for 'sync message' from the server.
                        do
                        {
                            temp = sr.ReadLine();
                        }
                        while (!temp.StartsWith("SYNC"));

                        // Read the server data and echo to the console.
                        while ((temp = sr.ReadLine()) != null && !String.IsNullOrEmpty(temp))
                        {
                            MessageBox.Show(temp);
                        }
                    }
                }
            }
            Console.Write("[CLIENT] Press Enter to continue...");
            Console.ReadLine();
        }
    }
}
