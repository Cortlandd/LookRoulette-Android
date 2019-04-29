package com.lookroulette.android

import android.app.Application
import android.content.Context

class LookRoulette: Application() {

    var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    override fun getApplicationContext(): Context? {
        return context
    }

}