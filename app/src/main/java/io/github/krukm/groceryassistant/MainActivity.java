package io.github.krukm.groceryassistant;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener {

    ArrayList<GroceryItem> groceryList = new ArrayList<>();
    GroceryListArrayAdapter groceryListArrayAdapter;
    ListView groceryListView;
    EditText addItemEditText;
    Button addItemButton;
    CheckBox itemCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        groceryListView = (ListView) findViewById(R.id.grocery_list_view);
        addItemEditText = (EditText) findViewById(R.id.add_item_edit_text);
        addItemButton = (Button) findViewById(R.id.add_item_button);
        itemCheckBox = (CheckBox) findViewById(R.id.item_check_box);

        groceryListArrayAdapter = new GroceryListArrayAdapter(this, groceryList);
        groceryListView.setAdapter(groceryListArrayAdapter);

        addItemButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.add_item_button: {
                String newItem = addItemEditText.getText().toString();
                GroceryItem groceryItem = new GroceryItem(newItem);
                groceryList.add(0, groceryItem);
                groceryListArrayAdapter.notifyDataSetChanged();
                addItemEditText.setText("");
            }
        }
    }
}
