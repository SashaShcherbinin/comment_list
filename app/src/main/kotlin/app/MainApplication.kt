package app

import android.app.Application
import base.data.module.networkModule
import base.database.di.databaseModule
import base.logger.di.loggerModule
import feature.comment.di.featureCommentModule
import feature.splash.di.featureSplashModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.java.KoinAndroidApplication
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val koin = KoinAndroidApplication.create(this)
            .androidContext(this)
            .androidLogger(Level.ERROR)
            .modules(
                loggerModule(),
                networkModule(),
                databaseModule(),
                featureSplashModule(),
                featureCommentModule(),
            )
        startKoin(koin)
    }
}
