package org.nearbyshops.enduserappnew.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import org.nearbyshops.enduserappnew.MyApplication;
import org.nearbyshops.enduserappnew.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by sumeet on 5/5/16.
 */
public class PrefGeneral {


    public static final String SERVICE_URL_LOCAL_HOTSPOT = "http://192.168.43.73:5121";
    public static final String SERVICE_URL_NEARBYSHOPS = "http://api.nearbyshops.org";
    public static final String SERVICE_URL_LOCAL = "http://192.168.0.5:5120";


    // for multi-market mode set default service url to null and multi market mode to true
    public static final String DEFAULT_SERVICE_URL = SERVICE_URL_NEARBYSHOPS;
    public static final boolean MULTI_MARKET_MODE_ENABLED = true;




    private static final String TAG_PREF_CURRENCY = "currency_symbol";
    private static final String TAG_MULTI_MARKET_MODE = "multi_market_mode";



    public static final String TAG_SERVICE_URL = "tag_pref_service_url";








    public static boolean getMultiMarketMode(Context context)
    {
//        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
//        return sharedPref.getBoolean(TAG_MULTI_MARKET_MODE, true);

        return MULTI_MARKET_MODE_ENABLED;
    }


//    public static void saveMultiMarketMode(boolean enabled, Context context)
//    {
//        //Creating a shared preference
//        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
//        SharedPreferences.Editor prefsEditor = sharedPref.edit();
//        prefsEditor.putBoolean(TAG_MULTI_MARKET_MODE, enabled);
//        prefsEditor.apply();
//    }





    public static String getServiceURL(Context context) {

        context = MyApplication.getAppContext();

        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        return sharedPref.getString(TAG_SERVICE_URL, DEFAULT_SERVICE_URL);
    }








    public static void saveServiceURL(String service_url, Context context)
    {
        context = MyApplication.getAppContext();

//        Context context = MyApplication.getAppContext();
        // get a handle to shared Preference
        SharedPreferences sharedPref;

        sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_name),
                MODE_PRIVATE);

        // write to the shared preference
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(
                TAG_SERVICE_URL,
                service_url);

        editor.apply();


        // log out the user
        PrefLogin.saveUserProfile(null,context);
        PrefLogin.saveCredentials(context,null,null);
    }









    public static void saveCurrencySymbol(String symbol, Context context)
    {
        context = MyApplication.getAppContext();
        //Creating a shared preference
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPref.edit();
        prefsEditor.putString(TAG_PREF_CURRENCY, symbol);
        prefsEditor.apply();
    }







    public static String getCurrencySymbol(Context context)
    {
        context = MyApplication.getAppContext();

        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        return sharedPref.getString(TAG_PREF_CURRENCY, context.getString(R.string.rupee_symbol));
    }

}
