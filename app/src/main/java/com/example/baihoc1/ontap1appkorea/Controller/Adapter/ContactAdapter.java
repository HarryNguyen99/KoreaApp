package com.example.baihoc1.ontap1appkorea.Controller.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.baihoc1.ontap1appkorea.Model.ContactResult;
import com.example.baihoc1.ontap1appkorea.R;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolfer> {

    public Context context;
    public List<ContactResult> data;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<ContactResult> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public ContactViewHolfer onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).
                inflate(R.layout.contact_item_layout, viewGroup, false);
        return new ContactViewHolfer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolfer contactViewHolfer, int i) {
        ContactResult contactResult = data.get(i);
        contactResult.tvTenCoQuan.setText(contactResult.getName());
        contactResult.tvSdtKhanCap.setText(contactResult.getPhone());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ContactViewHolfer extends RecyclerView.ViewHolder {

        TextView tvTenCoQuan;
        TextView tvSdtKhanCap;

        public ContactViewHolfer(@NonNull View itemView) {
            super(itemView);

            tvTenCoQuan = itemView.findViewById(R.id.tv_ten_co_quan);
            tvSdtKhanCap = itemView.findViewById(R.id.tv_sdt_khancap);

        }
    }
}
