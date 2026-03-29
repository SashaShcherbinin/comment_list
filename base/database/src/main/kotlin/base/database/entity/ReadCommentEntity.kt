package base.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "read_comments")
data class ReadCommentEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
)
