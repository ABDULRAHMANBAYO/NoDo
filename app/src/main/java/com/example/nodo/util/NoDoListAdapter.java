package com.example.nodo.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nodo.R;
import com.example.nodo.model.NoDo;
import java.util.List;



public class NoDoListAdapter extends RecyclerView.Adapter<NoDoListAdapter.NoDoViewHolder> {

    private List<NoDo> noDoList;
    private final LayoutInflater noDoInflater;

    public NoDoListAdapter(Context context) {
      noDoInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NoDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            //Use inflater to get recycler view:get view layout
        View view = noDoInflater.inflate(R.layout.recyclerview_item,parent,false);
        return new NoDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoDoViewHolder holder, int position) {

        // Map data to view:set data to view
        if(noDoList != null)
        {
            NoDo current = noDoList.get(position);
            holder.noDoTextView.setText(current.getNoDo());
        }
        else {
            holder.noDoTextView.setText(R.string.no_notodo);
        }

    }

   public  void setNoDos(List<NoDo>noDos){
        noDoList = noDos;
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        if(noDoList != null)
            return noDoList.size();
        else return  0;
    }

    // Get view then pass view to onBindViewHolder
    public class NoDoViewHolder extends RecyclerView.ViewHolder {
        private TextView noDoTextView;
        public NoDoViewHolder(@NonNull View itemView) {

            super(itemView);
            noDoTextView = itemView.findViewById(R.id.textView);
        }
    }
}
