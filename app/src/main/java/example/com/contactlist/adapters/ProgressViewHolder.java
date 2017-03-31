package example.com.contactlist.adapters;

import android.view.View;
import android.widget.ProgressBar;

import example.com.contactlist.R;

/**
 * Created by Farhad on 3/31/17.
 */

public class ProgressViewHolder extends RecyclerViewHolders {
    public ProgressBar progressBar;
    public ProgressViewHolder(View itemView) {
        super(itemView);
        progressBar = (ProgressBar)itemView.findViewById(R.id.progressBar);
    }
}
