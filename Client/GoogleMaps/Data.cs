using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GoogleMaps
{
    class Data
    {
        public long calculationTime;
        public double compressionRate;
        public double epsilonFactor;
        public double[][] points;

        public double neLat;
        public double neLng;
        public double swLat;
        public double swLng;

        public Data()
        {

        }

        public Data(double[] points, double epsilonFactor)
        {
            this.points = to2DArray(points);
            this.epsilonFactor = epsilonFactor;
            epsilonFactor = 0.05;
        }

        public Data(double[] points, double neLat, double neLng, double swLat, double swLng)
        {
            this.points = to2DArray(points);
            this.neLat = neLat;
            this.neLng = neLng;
            this.swLat = swLat;
            this.swLng = swLng;
        }

        public double[][] to2DArray(double[] points)
        {
            double[][] pointArray = new double[points.Length / 2][];

            for (int i = 0; i < points.Length /2; i++)
            {
                pointArray[i] = new double[2];
                pointArray[i][0] = points[i * 2];
                pointArray[i][1] = points[(i * 2) + 1];
            }

            return pointArray;
        }

        public List<double> arrayToList(double[][] points)
        {
            List<double> pointList = new List<double>();

            for(int i = 0; i < points.Length; i++)
            {
                pointList.Add(points[i][0]);
                pointList.Add(points[i][1]);
            }

            return pointList;
        }
    }
}
