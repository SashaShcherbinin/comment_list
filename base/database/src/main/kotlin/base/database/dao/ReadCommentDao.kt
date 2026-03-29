package base.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import base.database.entity.ReadCommentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReadCommentDao {

    @Query("SELECT id FROM read_comments")
    fun observeAllIds(): Flow<List<Int>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: ReadCommentEntity)
}
