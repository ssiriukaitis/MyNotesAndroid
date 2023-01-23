package lt.sigitas.mynotes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "my_notes_main";
    private ListView listView;
    private ArrayAdapter<Note> adapter;
    private List<Note> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.notesList =  generateNotesList(15);

        setUpViews();

        setUpListViewAdapter();


        setUpClick();
        setUpLongClick();


    }

    private List<Note> generateNotesList(int recordNo) {
        List<Note> notesList = new ArrayList<>();
        for (int i = 1; i <= recordNo; i++){
            Note note = new Note(i, "name" + i, "some note text" + i);

            notesList.add(note);
        }
        return notesList;
    }

    private void setUpViews() {
        setContentView(R.layout.activity_main);
        this.listView = findViewById(R.id.listView);
    }

    private void setUpListViewAdapter() {
        this.adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                this.notesList
        );

        this.listView.setAdapter(adapter);
    }

    private void setUpClick() {
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.i(TAG, "onItemClick" + position + ", #:" + MainActivity.this.notesList.get(position));

            }
        };
        listView.setOnItemClickListener(listener);
    }
    private void setUpLongClick() {
        AdapterView.OnItemLongClickListener listenerLongClick = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                displayNoteDeleteAlertDisplay(position);

                return false;
            }

        };
        listView.setOnItemLongClickListener(listenerLongClick);
    }

    private void displayNoteDeleteAlertDisplay(int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        DialogInterface.OnClickListener listener = (dialogInterface, i) ->{
            //Log.i(TAG, "Removed on long click" + position + ", #:" + this.notesList.get(position));
            displayDeleteMessage("Removed note (id: " + this.notesList.get(position).getId() + "from list");
            notesList.remove(position);
            adapter.notifyDataSetChanged();

        } ;
        builder.setMessage("Are you sure want to remove?");
        builder.setPositiveButton("Yes", listener);
        builder.setNegativeButton("No", null);
        builder.show();
    }

    public void displayDeleteMessage(String message){
        Snackbar.make(listView, message, Snackbar.LENGTH_LONG).show();
    }
}