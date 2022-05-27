package data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

//    @Query("SELECT * FROM WordEntity")
//    fun getAll() : LiveData<List<WordEntity>>
//
//    @Query("SELECT COUNT(*) FROM WordEntity")
//    fun getCount(): LiveData<Int>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(vararg wordEntity: WordEntity)
//
//    @Query("DELETE FROM WordEntity")
//    fun deleteAll()
//
//    @Query("SELECT * FROM WordEntity WHERE word LIKE :search")
//    suspend fun loadWord(search: String?): WordEntity
//
//    @Query("SELECT * FROM WordEntity WHERE meaning LIKE :search")
//    suspend fun loadWordInPersian(search: String?): WordEntity
//
//    @Update//(entity = WordEntity::class)
//    fun update(obj: WordEntity)
//
//    @Delete(entity = WordEntity::class)
//    suspend fun deleteWord(word: WordEntity)

}