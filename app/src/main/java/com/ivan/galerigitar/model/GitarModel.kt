package com.ivan.galerigitar.model

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import com.ivan.galerigitar.R

class GitarModel(activity: AppCompatActivity) {
    private val DATABASE_NAME: String = "GaleriGitar.db"
    private val TABLE_NAME: String ="gitar"
    private val COLLUMN_ID: String = "id"
    private val COLLUMN_NO: String = "no"
    private val COLLUMN_NAME: String ="name"
    private val COLLUMN_GAMBAR: String ="gambar_src"
    private val COLLUMN_DETAIL: String ="detail_src"
    private val COLLUMN_KAT: String ="kategori"

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
                $COLLUMN_NO INTEGER NOT NULL,
                $COLLUMN_NAME VARCHAR(100) NOT NULL,
                $COLLUMN_GAMBAR INTEGER NOT NULL,
                $COLLUMN_DETAIL INTEGER NOT NULL,
                $COLLUMN_KAT INTEGER NOT NULL,
                FOREIGN KEY($COLLUMN_KAT) REFERENCES kategori(id)
            );
        """.trimIndent()
        myDB.execSQL(createTableQuery)
    }

    fun initInsertion(){
        val insertQuery: String = """
            INSERT OR IGNORE INTO $TABLE_NAME($COLLUMN_ID, $COLLUMN_NO, $COLLUMN_NAME, $COLLUMN_GAMBAR, 
                $COLLUMN_DETAIL, $COLLUMN_KAT) VALUES
                (1, 0, "Gibson 125th Anniversary SJ-200", ${R.drawable.gibson_125}, ${R.string.akustik_gibson_125}, 0),
                (2, 1, "Taylor Custom Grand Auditorium", ${R.drawable.taylor_auditorium}, ${R.string.akustik_taylor_auditorium}, 0),
                (3, 2, "Taylor Custom Brazilian Rosewood", ${R.drawable.taylor_brazilian}, ${R.string.akustik_taylor_brazilian}, 0),
                (4, 3, "Taylor Custom Dreadnought ES", ${R.drawable.taylor_dreadnought}, ${R.string.akustik_taylor_dreadnought}, 0),
                (5, 4, "Taylor Custom GC #16 Queen's Walnut", ${R.drawable.taylor_gc}, ${R.string.akustik_taylor_gc}, 0),
                (6, 0, "Fender Tony Franklin Fretless Precision Bass", ${R.drawable.fender_tony}, ${R.string.bass_fender_tony}, 1),
                (7, 1, "Fender Custom Shop 1959 Precision Bass HR SGM MASTERBUILT", ${R.drawable.fender_custom_bass}, ${R.string.bass_fender_custom}, 1),
                (8, 2, "Dingwall Z3 5-String SMB IB", ${R.drawable.dingwall}, ${R.string.bass_dingwall}, 1),
                (9, 3, "Franz Bassguitars Wega 5-str Euro Esche MN", ${R.drawable.franz_bass}, ${R.string.bass_franz}, 1),
                (10, 4, "Esh Poseidon Lava Yellow", ${R.drawable.esh_poseidon}, ${R.string.bass_esh_poseidon}, 1),
                (11, 0, "Nik Huber Redwood Tigereye Burst", ${R.drawable.e_nik_huber_redwood}, ${R.string.elektrik_nik_huber_redwood}, 2),
                (12, 1, "PRS McCarty Graveyard Limited", ${R.drawable.e_prs_mc_carty}, ${R.string.elektrik_prs_mccarty}, 2),
                (13, 2, "Fender Custom Shop Smoked Tele MBDW", ${R.drawable.e_fender_custom}, ${R.string.elektik_fender}, 2),
                (14, 3, "Gibson Gallery's Choice R6 Rich Hippie", ${R.drawable.e_gibson_gallery}, ${R.string.elektrik_gibson}, 2),
                (15, 4, "Nik Huber Orca 59 Superhollow", ${R.drawable.e_nik_huber}, ${R.string.elektrik_nik_huber_orca}, 2),
                (16, 0, "Hanika Natural-Torres", ${R.drawable.hanika_natural}, ${R.string.klasik_hanika_natural}, 3),
                (17, 1, "Lakewood A-38 Edition 2020", ${R.drawable.k_lakewood}, ${R.string.klasik_gitar_lakewood}, 3),
                (18, 2, "Cordoba GK Pro", ${R.drawable.cordoba_gk}, ${R.string.klasik_cordoba}, 3),
                (19, 3, "Hanika 54 PF", ${R.drawable.hanika_pf}, ${R.string.klasik_hanika_pf}, 3),
                (20, 4, "LaMancha Amatista Antiguo", ${R.drawable.la_mancha}, ${R.string.klasik_lamancha}, 3);
        """.trimIndent()
        myDB.execSQL(insertQuery)
    }

    fun getNameSrcDetail(kategori: Int, selected: Int): ArrayList<String>{
        val selectQuery: String = """
            SELECT $COLLUMN_NAME, $COLLUMN_GAMBAR, $COLLUMN_DETAIL FROM $TABLE_NAME
            WHERE $COLLUMN_KAT = $kategori AND $COLLUMN_NO = $selected;
        """.trimIndent()
        val cursor: Cursor = myDB.rawQuery(selectQuery, null)
        val arrList = ArrayList<String>()
        if(cursor.moveToFirst()){
            arrList.add(cursor.getString(0))
            arrList.add(cursor.getString(1))
            arrList.add(cursor.getString(2))
        }
        return arrList
    }

    fun getName(kategori: Int): ArrayList<String>{
        val selectQuery: String = """
            SELECT $COLLUMN_NAME FROM $TABLE_NAME
            WHERE $COLLUMN_KAT = $kategori;
        """.trimIndent()
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

    fun getGambar(kategori: Int): ArrayList<Int>{
        val selectQuery: String = """
            SELECT $COLLUMN_GAMBAR FROM $TABLE_NAME
            WHERE $COLLUMN_KAT = $kategori;
        """.trimIndent()
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