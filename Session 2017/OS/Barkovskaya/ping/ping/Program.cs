using System;
using System.Diagnostics;
using System.IO;
using System.IO.Pipes;
using System.Net.NetworkInformation;

namespace ping
{
    class Program
    {
        static void Main()
        {
            Process pipeClient = new Process();

            pipeClient.StartInfo.FileName = "D:\\Session 2017\\OS\\Barkovskaya\\ping\\ping2\\bin\\Debug\\ping2.exe";

            using (AnonymousPipeServerStream pipeServer =
                new AnonymousPipeServerStream(PipeDirection.Out,
                HandleInheritability.Inheritable))
            {
                // Show that anonymous pipes do not support Message mode.
                try
                {
                    pipeServer.ReadMode = PipeTransmissionMode.Message;
                }
                catch (NotSupportedException e)
                {
                    Console.WriteLine("[SERVER] Exception:\n    {0}", e.Message);
                }

                // Pass the client process a handle to the server.
                pipeClient.StartInfo.Arguments = pipeServer.GetClientHandleAsString();
                pipeClient.StartInfo.UseShellExecute = false;
                pipeClient.Start();      
                pipeServer.DisposeLocalCopyOfClientHandle();

                try
                {
                    // Read user input and send that to the client process.
                    using (StreamWriter sw = new StreamWriter(pipeServer))
                    {
                        sw.AutoFlush = true;
                        // Send a 'sync message' and wait for client to receive it.
                        sw.WriteLine("SYNC");
                        pipeServer.WaitForPipeDrain();
                        // Send the console input to the client process.
                        // Console.Write("[SERVER] Enter text: ");
                        Ping p = new Ping();
                        string s = "google.com";
                        PingReply r = p.Send(s);
                        var results = "";
                        if (r.Status == IPStatus.Success)
                        {
                            results = "Ping to " + s.ToString() + "[" + r.Address.ToString() + "]" + " Successful"
                               + " Response delay = " + r.RoundtripTime.ToString() + " ms" + "\n";
                        }
                        else
                        {
                            results = "ERROR PING " + s;
                        }
                        sw.WriteLine(results);
                    }
                }
                // Catch the IOException that is raised if the pipe is broken
                // or disconnected.
                catch (IOException e)
                {
                    Console.WriteLine("[SERVER] Error: {0}", e.Message);
                }
            }

            pipeClient.WaitForExit();
            pipeClient.Close();
            Console.ReadKey();
        }
    }
}
