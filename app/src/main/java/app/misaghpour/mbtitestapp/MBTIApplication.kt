package app.misaghpour.mbtitestapp

import android.app.Application
import android.content.Context

class MBTIApplication : Application() {
    lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        context = this

    }
}