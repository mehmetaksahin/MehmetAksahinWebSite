package com.tenisturnuvasi.adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tenisturnuvasi.R;
import com.tenisturnuvasi.model.ui.MacFiksturVeSonucGoruntu;
import com.tenisturnuvasi.util.Referanslar;
import com.tenisturnuvasi.util.GlideApp;

import java.util.List;

public class AdapterCVFikstur extends RecyclerView.Adapter<AdapterCVFikstur.MyViewHolder> {

    private Context mContext;
    private List<MacFiksturVeSonucGoruntu> modelList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTarih, textViewKort;
        private ImageView imageViewProfPicTeklif, imageViewProfPicRakip;
        private TextView textViewAdSoyadTeklif, textViewAdSoyadRakip;

        public MyViewHolder(View view) {
            super(view);

            textViewTarih = (TextView) view.findViewById(R.id.textViewCVFiksturTarih);
            textViewKort = (TextView) view.findViewById(R.id.textViewCVFiksturKort);
            imageViewProfPicTeklif = (ImageView) view.findViewById(R.id.imageViewCVFiksturProfilePicTeklif);
            imageViewProfPicRakip = (ImageView) view.findViewById(R.id.imageViewCVFiksturProfilePicRakip);
            textViewAdSoyadTeklif = (TextView) view.findViewById(R.id.textViewCVFiksturAdSoyadTeklif);
            textViewAdSoyadRakip = (TextView) view.findViewById(R.id.textViewCVFiksturAdSoyadRakip);

        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public AdapterCVFikstur(Context mContext, List<MacFiksturVeSonucGoruntu> modelList) {
        this.mContext = mContext;
        this.modelList = modelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_fikstur, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        try {

            final MacFiksturVeSonucGoruntu model = modelList.get(position);

            // MacDurumSonuc
            holder.textViewTarih.setText(Referanslar.dateFormatddMMyyyyHHmmE.format(model.getMacDurumSonuc().getMac_saati().toDate()));
            // Kort
            holder.textViewKort.setText(model.getKort().getKort_ad());
            // Kullanici
            holder.textViewAdSoyadTeklif.setText(model.getTeklifEdenKullanici().getAd() + " " + model.getTeklifEdenKullanici().getSoyad());
            holder.textViewAdSoyadRakip.setText(model.getRakipKullanici().getAd() + " " + model.getRakipKullanici().getSoyad());
            GlideApp.with(mContext)
                    .load(model.getTeklifEdenKullanici().getFoto_mini_url())
                    .placeholder(R.drawable.profile_placeholder)
                    .into(holder.imageViewProfPicTeklif);
            GlideApp.with(mContext)
                    .load(model.getRakipKullanici().getFoto_mini_url())
                    .placeholder(R.drawable.profile_placeholder)
                    .into(holder.imageViewProfPicRakip);

        } catch (Exception e) {
            holder.textViewTarih.setText("Hata:" + e.getLocalizedMessage());
        }
    }

}