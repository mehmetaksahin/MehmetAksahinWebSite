package com.tenisturnuvasi.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tenisturnuvasi.R;
import com.tenisturnuvasi.util.Referanslar;

import java.util.List;

public class AdapterCustomViewKortMusaitlik extends ArrayAdapter<String> {

    private final Activity context;
    private final List<String> kortMusaitlikTarihList;
    private final List<String> kortMusaitlikDurumList;

    public AdapterCustomViewKortMusaitlik(Activity context, List<String> kortMusaitlikTarihList, List<String> kortMusaitlikDurumList) {
        super(context, R.layout.custom_view_kortmusaitlik, kortMusaitlikTarihList); // herhangi bir list versen yeter
        this.context = context;
        this.kortMusaitlikTarihList = kortMusaitlikTarihList;
        this.kortMusaitlikDurumList = kortMusaitlikDurumList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View akisView = layoutInflater.inflate(R.layout.custom_view_kortmusaitlik, null, true);

        TextView textViewTarih = akisView.findViewById(R.id.textViewCVKortMusaitlikTarih);
        TextView textViewDurum = akisView.findViewById(R.id.textViewCVKortMusaitlikDurum);

        textViewTarih.setText(kortMusaitlikTarihList.get(position));
        textViewDurum.setText(kortMusaitlikDurumList.get(position));

        if (kortMusaitlikDurumList.get(position).equals(Referanslar.KORT_MUSAITLIK_DURUM_STRING_MUSAIT)) {
            textViewDurum.setTextColor(Color.GREEN);
        } else if (kortMusaitlikDurumList.get(position).equals(Referanslar.KORT_MUSAITLIK_DURUM_STRING_REZERVE)) {
            textViewDurum.setTextColor(Color.RED);
        }

        return akisView;
    }
}
