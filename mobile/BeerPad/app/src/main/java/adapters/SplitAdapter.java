package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beerpad.R;

import java.util.List;

import models.Person;

/**
 * Created by luisalfonsobejaranosanchez on 5/28/17.
 */
public class SplitAdapter extends RecyclerView.Adapter<SplitHolder> {

    private List<Person> personList;
    private Context context;

    public SplitAdapter(List<Person> personList, Context context) {
        this.personList = personList;
        this.context = context;
    }

    @Override
    public SplitHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.split_view, parent, false);

        return new SplitHolder(itemView,context);
    }

    @Override
    public void onBindViewHolder(SplitHolder holder, int position) {
        Person person = personList.get(position);
        holder.setName(person.getName());
        holder.setmItemPhone(person.getPhone());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


}
