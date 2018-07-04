package com.pivotalsoft.get5mseller.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pivotalsoft.get5mseller.ModelItems.ProductSubItem;
import com.pivotalsoft.get5mseller.ProductsActivities.ProductsListActivity;
import com.pivotalsoft.get5mseller.R;

import java.util.List;

/**
 * Created by Gangadhar on 9/19/2017.
 */

public class ProductSubAdapter extends RecyclerView.Adapter<ProductSubAdapter.MyViewHolder> {

    private List<ProductSubItem> productsItemList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public LinearLayout productsLayout;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.txtProductName);
            productsLayout=(LinearLayout)view.findViewById(R.id.productsLayout);

        }
    }


    public ProductSubAdapter(List<ProductSubItem> productsItemList, Context mContext) {
        this.productsItemList = productsItemList;
        this.mContext = mContext;
    }

    @Override
    public ProductSubAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_sub_list_item, parent, false);

        return new ProductSubAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductSubAdapter.MyViewHolder holder, int position) {
        ProductSubItem productsItem = productsItemList.get(position);
        holder.name.setText(productsItem.getName());
        holder.productsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 =new Intent(mContext,ProductsListActivity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivity(intent4);
            }
        });


    }

    @Override
    public int getItemCount() {
        return productsItemList.size();
    }
}
