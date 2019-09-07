package com.example.war.my_doc.ViewHolder;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.war.my_doc.Interface.ItemClickListener;
import com.example.war.my_doc.R;
//import com.example.war.my_doc.R;

/**
 * Created by war on 2/4/2018.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textMenuName;
    public ImageView imageView;

    private ItemClickListener itemClickListener;
    public MenuViewHolder(View itemView) {
        super(itemView);

        textMenuName=(TextView)itemView.findViewById(R.id.menu_name);
        imageView=(ImageView)itemView.findViewById(R.id.menu_image);

        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @Override
    public void onClick(View view) {

        itemClickListener.OnClick(view,getAdapterPosition(),false);

    }
}
