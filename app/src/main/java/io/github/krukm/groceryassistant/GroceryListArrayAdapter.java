package io.github.krukm.groceryassistant;


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

    private final LayoutInflater inflater;
    private final ArrayList<GroceryItem> groceryItems = new ArrayList<>();

    public GroceryListArrayAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public void addItem(GroceryItem item) {
        groceryItems.add(0, item);
        notifyDataSetChanged();
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
            convertView = inflater.inflate(R.layout.row_items, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final GroceryItem currentItem = (GroceryItem) getItem(position);
        viewHolder.itemName.setText(currentItem.getItemName());
        viewHolder.itemQuantity.setText(String.valueOf(currentItem.getQuantity()));
        viewHolder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    viewHolder.itemName.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    viewHolder.itemQuantity.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    groceryItems.get(position).setSelected(true);
                } else {
                    viewHolder.itemName.setPaintFlags(0);
                    viewHolder.itemQuantity.setPaintFlags(0);
                    groceryItems.get(position).setSelected(false);
                }
            }
        });

        viewHolder.checkBox.setChecked(groceryItems.get(position).isSelected());

        return convertView;
    }

    private class ViewHolder {
        final CheckBox checkBox;
        final TextView itemName;
        final TextView itemQuantity;

        private ViewHolder(View view) {
            checkBox = (CheckBox) view.findViewById(R.id.item_check_box);
            itemName = (TextView) view.findViewById(R.id.item_text_view);
            itemQuantity = (TextView) view.findViewById(R.id.item_quantity_text_view);
        }
    }
}
