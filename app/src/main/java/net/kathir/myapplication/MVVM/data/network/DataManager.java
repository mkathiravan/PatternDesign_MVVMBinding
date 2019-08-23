package net.kathir.myapplication.MVVM.data.network;

import com.preference.PowerPreference;
import com.preference.Preference;

import net.kathir.myapplication.App;
import net.kathir.myapplication.MVVM.data.db.database.LogDatabase;
import net.kathir.myapplication.MVVM.data.network.services.MovieService;

public class DataManager {

    private static DataManager sInstance;

    private DataManager() {
        // This class is not publicly instantiable
    }

    public static synchronized DataManager getInstance() {
        if (sInstance == null) {
            sInstance = new DataManager();
        }
        return sInstance;
    }

    public Preference getPrefs() {
        return PowerPreference.defult();
    }

    public LogDatabase getLogDatabse() {
        return LogDatabase.getInstance(App.getInstance());
    }

    public MovieService getMovieService() {
        return MovieService.getInstance();
    }
}
