package com.example.dz4.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dz4.R;
import com.example.dz4.listener.OnItemClickListener;
import com.example.dz4.model.BookModel;

import java.util.ArrayList;

public class AdapterBook extends RecyclerView.Adapter<AdapterBook.HolderBook> {
    ArrayList<BookModel> list;
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AdapterBook(ArrayList<BookModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterBook.HolderBook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_holder_book,parent,false);
        return new HolderBook(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBook.HolderBook holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class HolderBook extends RecyclerView.ViewHolder {
        TextView tvBookName;
        public HolderBook(@NonNull View itemView) {
            super(itemView);
            tvBookName=itemView.findViewById(R.id.tv_book_name);
        }


        public void onBind(BookModel bookModel) {
            tvBookName.setText(bookModel.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClickListener(bookModel);
                }
            });
        }
    }
}
