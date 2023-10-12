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

}
