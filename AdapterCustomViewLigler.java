package com.tenisturnuvasi.adapter;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tenisturnuvasi.R;
import com.tenisturnuvasi.model.LigTemel;
import com.tenisturnuvasi.util.Referanslar;
import com.tenisturnuvasi.util.GlideApp;

import java.util.List;

public class AdapterCustomViewLigler extends ArrayAdapter<String> {

    public final Activity context;
    public final List<String> ligTemelIdList;
    public final List<LigTemel> ligTemelList;

    public AdapterCustomViewLigler(Activity context, List<String> ligTemelIdList, List<LigTemel> ligTemelList) {
        super(context, R.layout.custom_view_ligler, ligTemelIdList);
        this.context = context;
        this.ligTemelIdList = ligTemelIdList;
        this.ligTemelList = ligTemelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View akisView = layoutInflater.inflate(R.layout.custom_view_ligler, null, true);

        ImageView imageViewLogo = akisView.findViewById(R.id.imageViewCVLiglerLogo);
        TextView textViewLigAd = akisView.findViewById(R.id.textViewCVLiglerLigAdi);
        TextView textViewLigKisaAd = akisView.findViewById(R.id.textViewCVLiglerLigKisaAdi);
        TextView textViewLigSezon = akisView.findViewById(R.id.textViewCVLiglerLigSezon);

        LigTemel ligTemel = ligTemelList.get(position);
        textViewLigAd.setText(ligTemel.getLig_ad());
        textViewLigKisaAd.setText(ligTemel.getLig_kisa_ad() + " (" + ligTemel.getIl_ad() + ")");
        String sezonAraligi = Referanslar.dateFormatddMMM.format(ligTemel.getBas_tarih().toDate()) + " - " + Referanslar.dateFormatddMMM.format(ligTemel.getBit_tarih().toDate());
        textViewLigSezon.setText(sezonAraligi);
        GlideApp.with(akisView)
                .load(ligTemel.getLig_logo_url())
                .fitCenter() //.centerCrop()
                .placeholder(R.drawable.tenisturnuvasi_com_logo)
                .into(imageViewLogo);

        return akisView;
    }
}
