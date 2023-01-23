package lt.sigitas.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<Note> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Note> notesList =  generateNotesList(15);

        setUpViews();

        setUpListViewAdapter(notesList);


    }

    private void setUpListViewAdapter(List<Note> notesList) {
        this.adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                notesList
        );

        this.listView.setAdapter(adapter);
    }

    private void setUpViews() {
        setContentView(R.layout.activity_main);
        this.listView = findViewById(R.id.listView);
    }


    private List<Note> generateNotesList(int recordNo) {
        List<Note> notesList = new ArrayList<>();
        for (int i = 1; i <= recordNo; i++){
            Note note = new Note(i, "name" + i, "some note text" + i);

            notesList.add(note);
        }
        return notesList;
    }

}