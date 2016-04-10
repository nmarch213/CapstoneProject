import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dom The Don on 3/9/2016.
 */
public class Time_model {

    private static String clocktime;
    private static int half;

    public Time_model(String clocktime, int half)
    {
        this.clocktime = clocktime;
        this.half = half;

    }

    public static JSONObject newTime(Time_model time) throws JSONException
    {
        JSONObject json = new JSONObject("{" +
        "'clocktime' : " + clocktime +
                "'half' : " + half + "}");

        return json;

    }


    static String getClockTime()
    {
        return clocktime;
    }
    public int getHalf() {return half;}

    public void setClockTime(String clockTime)
    {
        this.clocktime = clockTime;
    }
    public void setHalf(int half) {this.half = half;}



}
