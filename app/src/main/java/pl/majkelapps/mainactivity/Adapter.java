package pl.majkelapps.mainactivity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;
import pl.majkelapps.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    public Adapter() {
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }


    @Override
    public int getItemCount() {
        return 30;
    }

    public void add(Object message) {
    }

    public void addAll(List<Object> messagesList) {
        for (Object mc : messagesList) {
            add(mc);
        }
    }

    public void remove(Object message) {

    }


    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }


    public Object getItem(int position) {
        return null;
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        @Override
        public void onClick(View v) {
        }

        public void addElement() {

        }
    }


}


