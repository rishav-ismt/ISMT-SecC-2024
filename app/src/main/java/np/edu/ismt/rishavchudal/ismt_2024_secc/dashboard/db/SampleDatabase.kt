package np.edu.ismt.rishavchudal.ismt_2024_secc.dashboard.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Product::class],
    version = 1
)
abstract class SampleDatabase: RoomDatabase() {
    abstract fun getProductDao(): ProductDao

    companion object {
        private var INSTANCE: SampleDatabase? = null

        fun getInstance(applicationContext: Context): SampleDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    applicationContext,
                    SampleDatabase::class.java,
                    "sample_db"
                ).build()
            }
            return INSTANCE!!
        }
    }
}