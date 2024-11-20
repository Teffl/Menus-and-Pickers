package com.example.menusandpickers;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ContextualMenu extends AppCompatActivity {

    private ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contextual_menu);

        Button popupButton = findViewById(R.id.popup_button);
        TextView contextualText = findViewById(R.id.contextual_text);

        // Popup Menu Setup
        popupButton.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(ContextualMenu.this, view);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(item -> {
                Toast.makeText(ContextualMenu.this, "You clicked on " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true; // Indicating the item was successfully handled
            });
            popupMenu.show();
        });

        // Contextual Action Bar (CAB) Setup for Long Click
        contextualText.setOnLongClickListener(view -> {
            if (mActionMode != null) return false; // Only one action mode at a time
            mActionMode = startActionMode(mActionModeCallback);
            view.setSelected(true);  // Mark the view as selected to show CAB
            return true;
        });
    }

    // ActionMode Callback to handle CAB events
    private final ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate the menu for the contextual action bar (CAB)
            getMenuInflater().inflate(R.menu.contextual_menu, menu);
            return true; // Menu was successfully created
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            // No need to modify the menu dynamically, so return false
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            // Using if-else to handle item clicks instead of switch
            if (item.getItemId() == R.id.action_edit) {
                showToast("Edit Selected");
                mode.finish(); // Close the ActionMode
                return true;
            } else if (item.getItemId() == R.id.action_share) {
                showToast("Share Selected");
                mode.finish(); // Close the ActionMode
                return true;
            } else if (item.getItemId() == R.id.action_delete) {
                showToast("Delete Selected");
                mode.finish(); // Close the ActionMode
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null; // Cleanup when action mode is finished
        }
    };

    // Helper function to show Toast messages
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}