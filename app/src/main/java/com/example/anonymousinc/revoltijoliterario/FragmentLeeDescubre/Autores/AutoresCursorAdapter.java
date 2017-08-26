package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Autores;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.anonymousinc.revoltijoliterario.R;

import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Anonymous.Inc on 04/07/2017.
 */

public class AutoresCursorAdapter extends CursorAdapter{
    public AutoresCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_item_autor, viewGroup, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {

        // Referencias UI.
        TextView nameText = (TextView) view.findViewById(R.id.name);
        TextView nameText1 = (TextView) view.findViewById(R.id.dep1);
        TextView nameText2 = (TextView) view.findViewById(R.id.dep2);
        TextView nameText3 = (TextView) view.findViewById(R.id.dep3);
        final ImageView avatarImage = (ImageView) view.findViewById(R.id.avatar);

        // Obtener los valores del nombre y la imagen de un contacto.
        String nombre = cursor.getString(cursor.getColumnIndex(AutoresContract.AutorEntry.NOMBRE));
        String text1 = cursor.getString(cursor.getColumnIndex(AutoresContract.AutorEntry.DETALLE1));
        String text2 = cursor.getString(cursor.getColumnIndex(AutoresContract.AutorEntry.DETALLE2));
        String text3 = cursor.getString(cursor.getColumnIndex(AutoresContract.AutorEntry.DETALLE3));
        String imagenOri = cursor.getString(cursor.getColumnIndex(AutoresContract.AutorEntry.IMAGEN));

        // Establecer el nombre y la imagen.
        nameText.setText(nombre);
        nameText1.setText(text1);
        nameText2.setText(text2);
        nameText3.setText(text3);
        Glide
                .with(context)
                .load(Uri.parse("file:///android_asset/" + imagenOri))
                .asBitmap()
                .error(R.drawable.ic_account_circle)
                .centerCrop()
                .into(avatarImage);

    }
}
