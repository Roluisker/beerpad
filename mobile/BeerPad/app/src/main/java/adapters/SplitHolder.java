package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.beerpad.R;


/**
 * Created by luisalfonsobejaranosanchez on 5/28/17.
 */
public class SplitHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mItemName;
    private TextView mItemPhone;

    private SplitListener splitListener;

    public SplitHolder(View v, Context context) {
        super(v);

        mItemName = (TextView) v.findViewById(R.id.split_name);
        mItemPhone = (TextView) v.findViewById(R.id.split_phone);

        try {
            splitListener = (SplitListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.getClass().getSimpleName() + " must implement SlidePanelListener interface");
        }

        v.setOnClickListener(this);

    }

    public void setName(String name){
        mItemName.setText(name);
    }

    public void setmItemPhone(String phone){
        mItemPhone.setText(phone);
    }

    @Override
    public void onClick(View v) {
        if(splitListener != null){
            splitListener.isSplitClicked();
        }
    }

    public interface SplitListener {
        void isSplitClicked();
    }

    public void setSplitListener(SplitListener listener) {
        this.splitListener = listener;
    }

}
