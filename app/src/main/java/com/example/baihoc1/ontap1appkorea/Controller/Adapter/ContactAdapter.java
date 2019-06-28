package com.example.baihoc1.ontap1appkorea.Controller.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.baihoc1.ontap1appkorea.Model.ContactResult;
import com.example.baihoc1.ontap1appkorea.Model.contact.Result;
import com.example.baihoc1.ontap1appkorea.R;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    public Context context;
    public List<Result> data;

    public ContactAdapter(Context context, List<Result> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).
                inflate(R.layout.contact_item_layout, viewGroup, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        Result contactResult = data.get(i);
        contactViewHolder.tvTenCoQuan.setText(contactResult.getName());
        contactViewHolder.tvSdtKhanCap.setText(contactResult.getPhone());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView tvTenCoQuan;
        TextView tvSdtKhanCap;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTenCoQuan = itemView.findViewById(R.id.tv_ten_co_quan);
            tvSdtKhanCap = itemView.findViewById(R.id.tv_sdt_khancap);

        }
    }
}
