package io.github.krukm.groceryassistant;


import android.content.ClipData.Item;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import java.util.ArrayList;

public class GroceryListArrayAdapter extends BaseAdapter {

    private final Context c;
    private ArrayList<GroceryItem> groceryItems = new ArrayList<>();

    public GroceryListArrayAdapter(Context context, ArrayList<GroceryItem> groceryItems) {
        this.c = context;
        this.groceryItems = groceryItems;
    }

    @Override
    public int getCount() {
        return groceryItems.size();
    }

    @Override
    public Object getItem(int position) {
        return groceryItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;


        if(convertView == null) {
            convertView = LayoutInflater.from(c).inflate(R.layout.row_items, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        GroceryItem currentItem = (GroceryItem) getItem(position);
        viewHolder.itemName.setText(currentItem.getItemName());

        viewHolder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    viewHolder.itemName.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    viewHolder.itemName.setPaintFlags(0);
                }
            }
        });

        return convertView;
    }

    private class ViewHolder {
        CheckBox checkBox;
        TextView itemName;

        public ViewHolder(View view) {
            checkBox = (CheckBox) view.findViewById(R.id.item_check_box);
            itemName = (TextView) view.findViewById(R.id.item_text_view);
        }
    }
}
