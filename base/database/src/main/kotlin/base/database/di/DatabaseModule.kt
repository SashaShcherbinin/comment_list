package base.database.di

import androidx.room.Room
import base.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

fun databaseModule(): Module = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app_database",
        ).fallbackToDestructiveMigration(true).build()
    }
    single { get<AppDatabase>().readCommentDao() }
}
