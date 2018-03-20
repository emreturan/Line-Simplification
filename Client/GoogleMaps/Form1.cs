using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Web.Script.Serialization;
using System.Windows.Forms;

namespace GoogleMaps
{
    [ComVisibleAttribute(true)]
    public partial class Form1 : Form
    {
        List<double> rawData;
        List<double> simplifiedData;
        Writer writer;
        Reader reader;
        string ip;
        double epsilonFactor = 0.05;

        public Form1()
        {
            InitializeComponent();
            this.rawDataBrowser.ObjectForScripting = this;
            this.resultBrowser.ObjectForScripting = this;
            this.Text = "Trajectory";

            reader = new Reader();
            writer = new Writer();

            string JSString = reader.readJS("raw.js");
            string resultString = reader.readJS("result.js");
            rawDataBrowser.DocumentText = JSString;
            resultBrowser.DocumentText = resultString;
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.Filter = "PLT Files|*.plt";
            openFileDialog1.Title = "Select Trajectory File";

            if (openFileDialog1.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                rawData = reader.readRawData(openFileDialog1.FileName);

                writer.writeToJSFile(rawData, "raw.js");
                string JSString = reader.readJS("raw.js");

                rawDataBrowser.DocumentText = JSString;
            }
        }

        public void querySimplifiedData(double NElat, double NElng, double SWlat, double SWlng, int zoom)
        {
            Client client = new Client();

            Data data = new Data(simplifiedData.ToArray(), NElat, NElng, SWlat, SWlng);

            string json = client.sendData(data, ip, 19985);
            Data resultData = new JavaScriptSerializer().Deserialize<Data>(json);

            List<double> selectedPoints = resultData.arrayToList(resultData.points);
            writer.writeCircles(selectedPoints, zoom, "result.js");
            string JSString = reader.readJS("result.js");

            queryValue.Text = resultData.calculationTime.ToString() + " ms";

            resultBrowser.DocumentText = JSString;
        }

        public void queryRawData(double NElat, double NElng, double SWlat, double SWlng, int zoom)
        {
            Client client = new Client();

            Data data = new Data(rawData.ToArray(), NElat, NElng, SWlat, SWlng);

            string json = client.sendData(data, ip, 19985);
            Data resultData = new JavaScriptSerializer().Deserialize<Data>(json);

            List<double> selectedPoints = resultData.arrayToList(resultData.points);
            writer.writeCircles(selectedPoints, zoom, "raw.js");
            string JSString = reader.readJS("raw.js");

            queryValue.Text = resultData.calculationTime.ToString() + " ms";

            rawDataBrowser.DocumentText = JSString;
        }

        private void simplifyButton_Click(object sender, EventArgs e)
        {
            epsilonFactor = Convert.ToDouble(epsilonBox.Value);

            Client client = new Client();
            Data data = new Data(rawData.ToArray(), epsilonFactor);
            string json = client.sendData(data, ip, 19984);

            Data resultData = new JavaScriptSerializer().Deserialize<Data>(json);

            rateValue.Text = "%" + resultData.compressionRate.ToString();
            timeValue.Text = resultData.calculationTime.ToString() + " ms";

            simplifiedData = resultData.arrayToList(resultData.points);

            writer.writeToJSFile(resultData.arrayToList(resultData.points), "result.js");
            string resultJS = reader.readJS("result.js");
            resultBrowser.DocumentText = resultJS;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            ip = ipBox.Text;
        }
    }
}
