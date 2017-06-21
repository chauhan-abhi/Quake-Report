package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import java.util.List;


class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }
    protected void onStartLoading() {
        forceLoad();
    }
    public List<Earthquake> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
