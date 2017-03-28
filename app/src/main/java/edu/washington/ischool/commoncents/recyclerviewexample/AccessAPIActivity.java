package edu.washington.ischool.commoncents.recyclerviewexample;

import android.os.Bundle;
import android.app.Activity;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;

public class AccessAPIActivity extends Activity {

  public static final String DEV_ID = "1948";
  public static final String AUTH_KEY = "FBDCBC658DDB43D1A3C212FFA2E79FC2";
  public static final String BASE_URL = "http://api.smitegame.com/smiteapi.scv/";

  private String timeStamp;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_access_api);

    timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    String signature = getMD5Hash(DEV_ID + "createsessionJson" + AUTH_KEY + timeStamp);
  }

  /**
   * API requires the use of an MD5 hash to create a signature, which is required
   * for each API method call.
   *
   * The pattern for creating a session is
   *
   *    base_url/createsessionJson/{devID}/{signature}/{timeStamp}
   *
   * @param input To create the input, we need ther devID, methodName, authKey,
   *              and utc timestamp (yyyyMMddHHmmss)
   *
   * @return hashed signature used for method calls
   *
   *
   */
  public String getMD5Hash(String input) {
    try {
      java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
      byte[] array = md.digest(input.getBytes(Charset.forName("UTF-8")));
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < array.length; ++i) {
        sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
      }
      return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {

    }
    return null;
  }

}
