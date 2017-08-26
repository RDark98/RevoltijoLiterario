package com.example.anonymousinc.revoltijoliterario.FragmentLeeDescubre.Poemas;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.anonymousinc.revoltijoliterario.R;

/**
 * Created by Anonymous.Inc on 04/07/2017.
 */

public class PoemasCursorAdapter extends CursorAdapter{
    public PoemasCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_item_poema, viewGroup, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {

        // Referencias UI.
        TextView nameText = (TextView) view.findViewById(R.id.namepoema);
        TextView nameText1 = (TextView) view.findViewById(R.id.deppoema1);
        final ImageView avatarImage = (ImageView) view.findViewById(R.id.avatarpoema);

        // Obtener los valores del nombre y la imagen de un contacto.
        String nombre = cursor.getString(cursor.getColumnIndex(PoemasContract.PoemaEntry.NOMBRE));
        String imagenOri = cursor.getString(cursor.getColumnIndex(PoemasContract.PoemaEntry.IMAGEN));
        String text1 = cursor.getString(cursor.getColumnIndex(PoemasContract.PoemaEntry.DETALLE1));

        // Establecer el nombre y la imagen.
        nameText.setText(nombre);
        nameText1.setText(text1);

        Glide
                .with(context)
                .load(Uri.parse("file:///android_asset/" + imagenOri))
                .asBitmap()
                .error(R.drawable.ic_account_circle)
                .centerCrop()
                .into(avatarImage);

    }
}
