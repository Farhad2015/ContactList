package example.com.contactlist;

import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import example.com.contactlist.adapters.ContactListItemAdapter;
import example.com.contactlist.dbcontent.CLDatabaseAdapter;
import example.com.contactlist.models.ContactListItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private LinearLayoutManager linearLayoutManager;
    List<ContactListItem> clList = new ArrayList<>();
    RecyclerView recyclerViewContactList;
    ContactListItemAdapter mAdapter;
    private Handler handler;

    CLDatabaseAdapter mydb;
    Button buttonLoadMore;

    int startnum = 0;
    int lastnum = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for status-bar color lollipop or higher version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        handler = new Handler();
        mydb = new CLDatabaseAdapter(MainActivity.this);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        clList = mydb.getData();
        recyclerViewContactList = (RecyclerView)findViewById(R.id.rv_Home_ContactList);
        recyclerViewContactList.setLayoutManager(linearLayoutManager);
        mAdapter = new ContactListItemAdapter(clList, MainActivity.this, recyclerViewContactList);
        recyclerViewContactList.setAdapter(mAdapter);
        mAdapter.setOnLoadMoreListener(new ContactListItemAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                clList.add(null);
//                mAdapter.notifyItemInserted(clList.size() - 1);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        clList.remove(clList.size() - 1);
                        mAdapter.notifyItemRemoved(clList.size());
                        for (int i = 0; i < mydb.getData().size(); i++) {
                            ContactListItem contactListItem = new ContactListItem();
                            contactListItem.setContactPersonName(mydb.getData().get(i).getContactPersonName());
                            contactListItem.setContactNumber(mydb.getData().get(i).getContactNumber());
                            clList.add(contactListItem);
                            mAdapter.notifyItemInserted(clList.size());
                        }
                        mAdapter.notifyDataSetChanged();
                        mAdapter.setLoaded();
                    }
                }, 4000);
                System.out.println("load");
            }
        });

    }

}
