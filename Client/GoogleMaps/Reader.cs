using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GoogleMaps
{
    class Reader
    {
        public string readJS(string path)
        {
            return File.ReadAllText(path);
        }

        public List<double> readRawData(string filePath)
        {
            List<double> rawDataList = new List<double>();

            string[] lines = File.ReadAllLines(filePath);

            for(int i = 6; i < lines.Length; i++)
            {
                string[] variables = lines[i].Split(',');
                double latData = double.Parse(variables[0], System.Globalization.CultureInfo.InvariantCulture);
                double longData = double.Parse(variables[1], System.Globalization.CultureInfo.InvariantCulture);

                rawDataList.Add(latData);
                rawDataList.Add(longData);
            }

            return rawDataList;
        }
    }
}
