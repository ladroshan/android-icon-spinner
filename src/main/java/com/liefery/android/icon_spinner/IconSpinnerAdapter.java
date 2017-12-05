package com.liefery.android.icon_spinner;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class IconSpinnerAdapter extends BaseAdapter {
    final private Context context;

    final private ItemSpinnable[] spinnerEntries;

    final private int itemPadding;

    public <E extends ItemSpinnable> IconSpinnerAdapter(
        Context context,
        E[] spinnerEntries ) {
        this.context = context;
        this.spinnerEntries = spinnerEntries;
        this.itemPadding = (int) context.getResources().getDimension(
            R.dimen.icon_spinner_item_padding );
    }

    @Override
    public int getCount() {
        return spinnerEntries.length;
    }

    @Override
    public Object getItem( int position ) {
        return spinnerEntries[position];
    }

    @Override
    public long getItemId( int position ) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getDropDownView( int position, View view, ViewGroup parent ) {
        View item = getCustomView( position, parent );
        item.setPadding( itemPadding, itemPadding, itemPadding, itemPadding );
        return item;
    }

    @Override
    public View getView( int pos, View view, ViewGroup parent ) {
        return getCustomView( pos, parent );
    }

    private View getCustomView( int position, ViewGroup parent ) {
        ItemSpinnable item = spinnerEntries[position];

        LayoutInflater inflater = LayoutInflater.from( context );
        ViewGroup spinnerView = (ViewGroup) inflater.inflate(
            R.layout.icon_spinner_item,
            parent,
            false );

        // Setting the title text
        TextView title = spinnerView.findViewById( R.id.title );
        title.setText( item.getTitle() );

        // Setting the subtitle text
        TextView subTitle = spinnerView.findViewById( R.id.subtitle );
        if ( item.getSubtitle() != null ) {
            subTitle.setVisibility( View.VISIBLE );
            subTitle.setText( item.getSubtitle() );
        } else {
            subTitle.setVisibility( View.GONE );
        }

        // Setting the Image Drawable
        ImageView iconView = spinnerView.findViewById( R.id.icon );
        iconView.setImageDrawable( item.getIconDrawable() );

        // Setting the color of the background shape of the drawable
        GradientDrawable drawable = (GradientDrawable) iconView.getBackground();
        drawable.setColor( item.getColor() );

        return spinnerView;
    }
}
