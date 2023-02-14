// Delta College - CST 283 - Klingler                          
// Definition of class to store one geographics location with latitude/longitude

public class GeoLocation
{
   private double latitude;    // degrees
   private double longitude;   // degrees
   
   public static GeoLocation DELTA_LOCATION = new GeoLocation(43.55660,-83.99430);

   // No-arg constructor
   public GeoLocation()
   {
      latitude  = 0.0;
      longitude = 0.0;
   }

   // Parameterized constructor
   public GeoLocation(double lat, double lon)
   {
      latitude = lat;
      longitude = lon;
   }

   // "get/set" methods

   public double getLatitude()
   {  return latitude;  }
   public double getLongitude()
   {  return longitude;  }
   public void setLatitude(double lat)
   { latitude = lat;  }
   public void setLongitude(double lon)
   { longitude = lon;  }
   
   // Validate that the coordinate is in range
   public boolean validCoordinate()
   {
       if (latitude >= 0.0 && latitude <= 90.0
       && longitude >= 0.0 && longitude <= 180.0) 
          return true;
       else 
          return false;
   }
   
   // The toString() method
   public String toString()
   {
      return " Latitude:  " + latitude  +
             " Longitude: " + longitude + "\n";
   }

   // The great circle distance formula is used for this method to 
   // calculate the distance from "this" location to another passed in
   // as a parameter.  Units in miles.
   public double distanceFrom(GeoLocation anotherLocation)
   {
        final double RADIUS_EARTH = 3963.189; // in miles

        // Convert local variables to radians  
        double la1 = Math.toRadians(this.latitude);
        double lo1 = Math.toRadians(this.longitude);
        double la2 = Math.toRadians(anotherLocation.latitude);
        double lo2 = Math.toRadians(anotherLocation.longitude);
        return RADIUS_EARTH * Math.acos( Math.sin(la1) * Math.sin(la2) 
                          + Math.cos(la1) * Math.cos(la2) * Math.cos(lo2-lo1) );
    }


}  
