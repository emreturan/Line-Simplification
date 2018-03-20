using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;
using System.Web.Script.Serialization;

namespace GoogleMaps
{
    class Client
    {
        public string sendData(Data data, string ip, int port)
        {
            var json = new JavaScriptSerializer().Serialize(data);
            string resultJson = "";

            using (TcpClient tcpClient =
                  new TcpClient(ip, port))
            using (NetworkStream networkStream =
                    tcpClient.GetStream())
            {

                using (StreamWriter writer = new StreamWriter(networkStream))
                {
                    writer.WriteLine(json);
                    writer.Flush();


                    using (StreamReader reader = new StreamReader(networkStream))
                    {
                        resultJson = reader.ReadLine();
                    }
                }
            }

            return resultJson;
        }
    }
}
