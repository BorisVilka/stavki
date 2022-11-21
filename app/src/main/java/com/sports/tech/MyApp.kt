package com.sports.tech

import android.app.Application
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.onesignal.OneSignal

class MyApp: Application() {


    override fun onCreate() {
        super.onCreate()
        val mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(0)
            .build()
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings)
        OneSignal.initWithContext(this)
        OneSignal.setAppId("47ec0fb6-27c3-4b20-8ccb-785890574f59")
    }
}