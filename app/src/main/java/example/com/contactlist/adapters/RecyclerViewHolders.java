package example.com.contactlist.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import example.com.contactlist.R;

/**
 * Created by Farhad on 3/31/17.
 */

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView textViewContactName;
    TextView textViewContactNo;
    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        textViewContactName = (TextView)itemView.findViewById(R.id.txt_username);
        textViewContactNo = (TextView)itemView.findViewById(R.id.txt_phoneno);
    }
    @Override
    public void onClick(View view) {
    }
}
