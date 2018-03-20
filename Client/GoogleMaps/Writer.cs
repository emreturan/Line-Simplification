using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GoogleMaps
{
    class Writer
    {
        public void writeToJSFile(List<double> latLongData, string filePath)
        {
            string startTag = "//Lat-Long data start";
            string endTag = "//Lat-Long data end";

            string centerLocation = "//Center Location";

            List<string> lines = File.ReadAllLines(filePath).ToList();

            lines.RemoveAt(lines.IndexOf(centerLocation) + 1);

            string centerLat = latLongData.ElementAt(0).ToString();
            centerLat = centerLat.Replace(',', '.');

            string centerLng = latLongData.ElementAt(1).ToString();
            centerLng = centerLng.Replace(',', '.');

            string centerLine = String.Format("center: {{ lat: {0}, lng: {1}}},", centerLat, centerLng);
            lines.Insert(lines.IndexOf(centerLocation) + 1, centerLine);

            lines.RemoveRange(lines.IndexOf(startTag) + 1, lines.IndexOf(endTag) - (lines.IndexOf(startTag) + 1));

            for (int i = 0; i < latLongData.Count; i += 2)
            {
                string lat = latLongData.ElementAt(i).ToString();
                lat = lat.Replace(',', '.');

                string lng = latLongData.ElementAt(i + 1).ToString();
                lng = lng.Replace(',', '.');

                string lineToAdd = String.Format("          {{lat: {0}, lng: {1}}},", lat, lng);
                lines.Insert(lines.IndexOf(endTag), lineToAdd);
            }

            File.WriteAllLines(filePath, lines);

        }

        public void writeCircles(List<double> circles, int zoom, string filePath)
        {
            string startTag = "//Circles start";
            string endTag = "//Circles end";

            string zoomTag = "//Zoom";

            List<string> lines = File.ReadAllLines(filePath).ToList();

            lines.RemoveAt(lines.IndexOf(zoomTag) + 1);
            string zoomLine = String.Format("zoom: {0}", zoom.ToString());
            lines.Insert(lines.IndexOf(zoomTag) + 1, zoomLine);

            lines.RemoveRange(lines.IndexOf(startTag) + 1, lines.IndexOf(endTag) - (lines.IndexOf(startTag) + 1));

            for (int i = 0; i < circles.Count; i += 2)
            {
                string lat = circles.ElementAt(i).ToString();
                lat = lat.Replace(',', '.');

                string lng = circles.ElementAt(i + 1).ToString();
                lng = lng.Replace(',', '.');

                string lineToAdd = String.Format("          {{lat: {0}, lng: {1}}},", lat, lng);
                lines.Insert(lines.IndexOf(endTag), lineToAdd);
            }

            File.WriteAllLines(filePath, lines);
        }

        public void writeRectBounds(double minLat, double maxLat, double minLng, double maxLng, string filePath)
        {
            //string startTag = "//Bounds Start";
            //string endTag = "//Bounds End";


            //List<string> lines = File.ReadAllLines(filePath).ToList();
            //lines.RemoveRange(lines.IndexOf(startTag) + 1, lines.IndexOf(endTag) - (lines.IndexOf(startTag) + 1));

            //string minLatString = minLat.ToString();
            //minLatString = minLatString.Replace(',', '.');

            //string maxLatString = maxLat.ToString();
            //maxLatString = maxLatString.Replace(',', '.');

            //string minLngString = minLng.ToString();
            //minLngString = minLngString.Replace(',', '.');

            //string maxLngString = maxLng.ToString();
            //maxLngString = maxLngString.Replace(',', '.');

            //string north = String.Format("north: {0},", maxLatString);
            //string south = String.Format("south: {0},", minLatString);

            //string east = String.Format("east: {0},", maxLngString);
            //string west = String.Format("west: {0}", minLngString);

            //lines.Insert(lines.IndexOf(endTag), north);
            //lines.Insert(lines.IndexOf(endTag), south);
            //lines.Insert(lines.IndexOf(endTag), east);
            //lines.Insert(lines.IndexOf(endTag), west);

            //File.WriteAllLines(filePath, lines);
        }
    }
}
