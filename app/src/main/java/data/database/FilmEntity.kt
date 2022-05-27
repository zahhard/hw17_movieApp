package data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FilmEntity(
    @PrimaryKey var word : String,
    var meaning : String,
    var example : String,
    var synonym : String,
    val url : String
)