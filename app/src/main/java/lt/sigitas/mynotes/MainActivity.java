package lt.sigitas.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "my_notes_main";
    private ListView listView;
    private ArrayAdapter<Note> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Note> notesList =  generateNotesList(15);

        setUpViews();

        setUpListViewAdapter(notesList);


        setUpClick(notesList);
        setUpLongClick(notesList);


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

    private void setUpListViewAdapter(List<Note> notesList) {
        this.adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                notesList
        );

        this.listView.setAdapter(adapter);
    }

    private void setUpClick(List<Note> notesList) {
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.i(TAG, "onItemClick" + position + ", #:" + notesList.get(position));

            }
        };
        listView.setOnItemClickListener(listener);
    }
    private void setUpLongClick(List<Note> notesList) {
        AdapterView.OnItemLongClickListener listenerLongClick = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "Removed on long click" + position + ", #:" + notesList.get(position));

                notesList.remove(position);
                adapter.notifyDataSetChanged();

                return false;
            }

        };
        listView.setOnItemLongClickListener(listenerLongClick);
    }






}