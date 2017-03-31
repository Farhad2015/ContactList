package example.com.contactlist.dbcontent;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Farhad on 3/31/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MRContactList.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "tbl_contactlist";
    public static final String COL_ID = "UID";
    public static final String COL_CONTACTPNAME="CONTACTNAME";
    public static final String COL_CONTACTNUMBER="CONTACTNUMBER";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_CONTACTPNAME+" TEXT, "+COL_CONTACTNUMBER+" TEXT);");

        db.execSQL("insert into  tbl_contactlist(CONTACTNAME, CONTACTNUMBER) values('Abir Khan', '01511111111'),('Abid Hasan','01522222222'),('Ashik Rahman', '0124511555442'),('Alan', '7451061320')," +
                "('Alan', '0147785203669'),('Alex','789456123'),('Aiub','89545665444'),('Beleyar','98687987635'),('Banu','456556644'),('Clez','23613132331'),('Maruf','6533631313'),('Shafi','8523631313')," +
                "('Farabee','654654646'),('Bappa','456656631313'),('Rajan','87645646'),('Nazim','99988898'),('Rubel','88555456664'),('Tasmia','89796612311'),('Saiful','6533631313'),('Farid','6533631313')," +
                "('Nakamuka', '56464466'),('Popy','6533631313'),('sumanto','6533631313'),('Nagib','6533631313'),('Abenty','6533631313'),('Zakia','6533631313'),('Mukit','6533631313'),('Moumi','6533631313')," +
                "('Kapil','6533631313'),('Tipu','6533631313'),('Zilani','6533631313'),('Imtu','6533631313'),('Zakir','6533631313'),('Rezbi','6533631313'),('Sarwar','6533631313'),('Asif','6533631313')");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
}
