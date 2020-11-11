package com.example.puiplanetcustomlist.task;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.puiplanetcustomlist.PlanetAdapter;
import com.example.puiplanetcustomlist.R;
import com.example.puiplanetcustomlist.model.Planet;
import com.example.puiplanetcustomlist.network.NetUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

import static android.R.layout.simple_list_item_1;

public class APIPlanetDownload implements Runnable{

    private static final String API_PLANET_BASE_URL = "http://sanger.dia.fi.upm.es/pmd-task/public/list-example/";
    private static final String API_PLANET_URL_GET_LIST_METHOD = "planets.php";
    private Activity activity;

    static GsonBuilder gsonBuilder = new GsonBuilder();
    static Gson gson = gsonBuilder.create();

    public APIPlanetDownload(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void run() {
        String result = "";
        try {
            result = NetUtils.getURLText(API_PLANET_BASE_URL + API_PLANET_URL_GET_LIST_METHOD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // the stuff managing Strings was removed because now we use our own adapter
        /*String[] listP = new String[planetList.size()];
        for (int i = 0; i < planetList.size(); i++) {
            listP[i] = planetList.get(i).toString();
        }*/

        // final String[] finalListP = listP;

        // this wasn't used
        /*GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("dd/MM/yyyy hh:mm a");
        Gson gson = gsonBuilder.create();
        String response = null;
        try {
            response = NetUtils.getURLText(urlServerBase+urlServerService);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        // final String finalResult = result;

        final List<Planet> planetList = Arrays.asList(gson.fromJson(result, Planet[].class));

        for (int i = 0; i < planetList.size(); i++) {
            planetList.get(i).getImageName();
            Planet planet = planetList.get(i);
            try {
                planet.setBitmap(NetUtils.getURLImage(API_PLANET_BASE_URL + planet.getImageName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ListView lv = activity.findViewById(R.id.lst_h);
                PlanetAdapter adapter = new PlanetAdapter(activity);
                adapter.addPlanets(planetList);
                lv.setAdapter(adapter);
            }
        });
    }
}
