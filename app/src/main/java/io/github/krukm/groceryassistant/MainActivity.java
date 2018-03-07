package io.github.krukm.groceryassistant;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {

    GroceryListArrayAdapter groceryListArrayAdapter;
    ListView groceryListView;
    EditText addItemEditText;
    EditText itemQuantityEditText;
    Button addItemButton;
    CheckBox itemCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        groceryListView = (ListView) findViewById(R.id.grocery_list_view);
        addItemEditText = (EditText) findViewById(R.id.add_item_edit_text);
        itemQuantityEditText = (EditText) findViewById(R.id.item_quantity_edit_text);
        addItemButton = (Button) findViewById(R.id.add_item_button);
        itemCheckBox = (CheckBox) findViewById(R.id.item_check_box);

        groceryListArrayAdapter = new GroceryListArrayAdapter(this);
        groceryListView.setAdapter(groceryListArrayAdapter);

        addItemButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.add_item_button: {
                String newItem = addItemEditText.getText().toString();
                int newItemQuantity = 1;
                if(!itemQuantityEditText.getText().toString().isEmpty()) {
                    newItemQuantity = Integer.parseInt(itemQuantityEditText.getText().toString());
                }
                GroceryItem groceryItem = new GroceryItem(newItem, newItemQuantity);
                groceryListArrayAdapter.addItem(groceryItem);
                addItemEditText.setText("");
                itemQuantityEditText.setText("");
            }
        }
    }
}
