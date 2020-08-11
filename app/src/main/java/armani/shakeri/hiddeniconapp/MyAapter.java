package armani.shakeri.hiddeniconapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAapter extends RecyclerView.Adapter<MyAapter.MyViewHolder> {

    List<String> nameList;
    Context   context;

    public MyAapter(List<String> nameList){

       this.nameList = nameList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_name_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String name = nameList.get(position);
        holder.txtName.setText(name);
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;


        public MyViewHolder(@NonNull View v) {
            super(v);

            txtName = v.findViewById(R.id.txt_rowNameItem_name);
        }
    }
}
