package smartparking.client;

import java.io.UnsupportedEncodingException;

/**
 * Created by chenhuanhuan on 16-6-15.
 */
public class T {
    public static void main(String[] args) {
        try {
            System.out.println(new String("\u00008".getBytes(), "gb2312"));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }
    }
}
