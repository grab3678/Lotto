package com.example.lotto;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<String> pData = null;
    public interface OnItemClickListener {
        public void onItemClick(View v, int position);
    }
    private OnItemClickListener iListener = null;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.iListener = listener;
    }

    // 아이템 저장 내부클래스 생성
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.poemItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        if (iListener != null) {
                            iListener.onItemClick(v,pos);
                        }
                    }
                }
            });
        }
    }

    //생성자에서 리스트 객체 전달.
    ListAdapter(ArrayList<String> list) {
        pData = list;
    }

    //뷰홀더 객체 생성해서 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.poem_item, parent, false);
        ListAdapter.ViewHolder vh = new ListAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String text = pData.get(position);
        holder.tv1.setText(text);
    }


    @Override
    public int getItemCount() {
        return pData.size();
    }
}
