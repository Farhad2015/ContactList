package example.com.contactlist.dbcontent;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import example.com.contactlist.models.ContactListItem;

/**
 * Created by Farhad on 3/31/17.
 */

public class CLDatabaseAdapter {
    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase db;
    private Context context;

    public CLDatabaseAdapter(Context context) {
        dbHelper = new DatabaseHelper(context);
        this.context = context;
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }


    public List<ContactListItem> getData() {
        List<ContactListItem> data = new ArrayList<>();
        open();
//        Cursor c = db.rawQuery("SELECT * FROM tbl_contactlist WHERE UID BETWEEN " + strtnum + " AND " + lstNum, null);
        Cursor c = db.rawQuery("SELECT * FROM tbl_contactlist", null);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                ContactListItem databaseDataHandler = new ContactListItem();
                databaseDataHandler.setContactPersonName(c.getString(1));
                databaseDataHandler.setContactNumber(c.getString(2));

                data.add(databaseDataHandler);
            }
            c.close();
            db.close();
        }
        return data;
    }
}
