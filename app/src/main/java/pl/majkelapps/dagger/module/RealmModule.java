package pl.majkelapps.dagger.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;



@Module
public class RealmModule {

    private SharedPreferences sharedPreferences;

    public RealmModule(Context context) {
        Realm.init(context);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    Realm provideRealm(RealmConfiguration realmConfiguration) {
        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
        } catch (Exception e) {
            realm = Realm.getInstance(realmConfiguration);
        }
        return realm;
    }

    @Provides
    RealmConfiguration provideRealmConfiguration() {
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("default.realm")
                .build();
        return config;
    }

    @Provides
    SharedPreferences providesSharedPreference() {
        return sharedPreferences;
    }

}
