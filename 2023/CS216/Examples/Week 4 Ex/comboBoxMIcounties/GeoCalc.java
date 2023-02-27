// Delta College - CST w83 - Klingler  
// This class exists to house calculation(s) useful for a geographical location

public class GeoCalc
{
    // This method receives two sets of geographical coordinates  
    // and returns the great circle distance betweent them (in miles)
    // Preconditions:             
    //    1) Latitude/longitude values in radians 
    //    2) Value ranges:  -90.0 <= Latitude  <= 90.0  
    //                    -180.0 <= Longitude <= 180.0  
    public static double calcGreatCircleDist(double la1, double lo1, 
                                             double la2, double lo2) 
    {
       final double RADIUS_EARTH = 3963.189;   // in miles

       // Convert local variables to radians  
       la1 = Math.toRadians(la1);
       lo1 = Math.toRadians(lo1);
       la2 = Math.toRadians(la2);
       lo2 = Math.toRadians(lo2);

       // Calculate great circle distance in miles
       return RADIUS_EARTH * Math.acos(Math.sin(la1) * Math.sin(la2)
                     + Math.cos(la1) * Math.cos(la2) * Math.cos(lo2 - lo1));
    }
}
