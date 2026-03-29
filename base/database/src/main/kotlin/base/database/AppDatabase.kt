package base.database

import androidx.room.Database
import androidx.room.RoomDatabase
import base.database.dao.ReadCommentDao
import base.database.entity.ReadCommentEntity

@Database(
    entities = [ReadCommentEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun readCommentDao(): ReadCommentDao
}
