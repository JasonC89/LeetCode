package base.design;

/**
 * Created by hchang on 6/15/16.
 */
public class GeoHash {
    /**
     * @param latitude, longitude a location coordinate pair
     * @param precision an integer between 1 to 12
     * @return a base32 string
     */
    public String encode(double latitude, double longitude, int precision) {
        // Write your code here
        String _base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        String lat_bin = getBin(latitude, -90, 90);
        String lng_bin = getBin(longitude, -180, 180);

        StringBuffer hash_code = new StringBuffer();
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < 30; ++i) {
            b.append(lng_bin.charAt(i));
            b.append(lat_bin.charAt(i));
        }

        for (int i = 0; i < 60; i += 5) {
            int index = b2i(b.substring(i, i + 5));
            hash_code.append(_base32.charAt(index));
        }
        return hash_code.substring(0, precision);
    }

    public int b2i(String bin) {
        return Integer.parseInt(bin, 2);
    }

    public String getBin(double value, double left, double right) {
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < 30; ++i) {
            double mid = (left + right) / 2.0;
            if (value > mid) {
                left = mid;
                b.append("1");
            } else {
                right = mid;
                b.append("0");
            }
        }
        return b.toString();
    }


    /**
     * @param geohash a base32 string
     * @return latitude and longitude a location coordinate pair
     */
    public double[] decode(String geohash) {
        // Write your code here
        String _base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        int[] mask = {16, 8, 4, 2, 1};
        double[] lon = {-180, 180};
        double[] lat = {-90, 90};
        boolean is_even = true;

        for (int i = 0; i < geohash.length(); ++i) {
            int val = _base32.indexOf(geohash.charAt(i));
            for (int j = 0; j < 5; ++j) {
                if (is_even) {
                    refine_interval(lon, val, mask[j]);
                } else {
                    refine_interval(lat, val, mask[j]);
                }
                is_even = ! is_even;
            }
        }
        double[] location = {(lat[0] + lat[1]) / 2.0, (lon[0] + lon[1]) / 2.0};
        return location;
    }

    public void refine_interval(double[] interval, int val, int mask) {
        if ((val & mask) > 0) {
            interval[0] = (interval[0] + interval[1]) / 2.0;
        } else {
            interval[1] = (interval[0] + interval[1]) / 2.0;
        }
    }


}
