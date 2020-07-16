package com.ivan.galerigitar.model

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.ivan.galerigitar.R
import com.ivan.galerigitar.view.HomeActivity

class GaleriModel(activity: HomeActivity){
    private val DATABASE_NAME: String = "GaleriGitar.db"
    private val TABLE_NAME: String ="kategori"
    private val COLLUMN_ID: String = "id"
    private val COLLUMN_NAME: String ="name"
    private val COLLUMN_GAMBAR: String ="gambar_src"

    private val ctx: Context = activity.applicationContext!!
    private var myDB: SQLiteDatabase

    init{
        myDB = ctx.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null)
        createTable()
        initInsertion()
    }

    fun createTable(){
        val createTableQuery: String = """
            CREATE TABLE IF NOT EXISTS $TABLE_NAME(
                $COLLUMN_ID INTEGER PRIMARY KEY NOT NULL,
                $COLLUMN_NAME VARCHAR(50) NOT NULL,
                $COLLUMN_GAMBAR INTEGER NOT NULL
            );
        """.trimIndent()
        myDB.execSQL(createTableQuery)
    }

    fun initInsertion(){
        val insertQuery: String = """
            INSERT OR IGNORE INTO $TABLE_NAME($COLLUMN_ID, $COLLUMN_NAME, $COLLUMN_GAMBAR)
                VALUES (0, "Gitar Akustik", ${R.drawable.akustik}),
                (1, "Gitar Bass", ${R.drawable.bass}),
                (2, "Gitar Elektrik", ${R.drawable.electric}),
                (3, "Gitar Klasik", ${R.drawable.klasik});
        """.trimIndent()
        myDB.execSQL(insertQuery)
    }

    fun getName(): ArrayList<String>{
        val selectQuery: String = "SELECT " + COLLUMN_NAME + " FROM " + TABLE_NAME + ";"
        val cursor: Cursor = myDB.rawQuery(selectQuery, null)
        val arrList = ArrayList<String>()
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast){
                arrList.add(cursor.getString(0))
                cursor.moveToNext()
            }
        }
        return arrList
    }

    fun getImageSrc(): ArrayList<Int>{
        val selectQuery: String = "SELECT " + COLLUMN_GAMBAR + " FROM " + TABLE_NAME + ";"
        val cursor: Cursor = myDB.rawQuery(selectQuery, null)
        val arrList = ArrayList<Int>()
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast){
                arrList.add(cursor.getInt(0))
                cursor.moveToNext()
            }
        }
        return arrList
    }

}