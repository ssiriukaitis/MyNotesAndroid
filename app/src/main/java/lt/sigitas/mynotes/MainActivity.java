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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. data
        List<Note> notesList = new ArrayList<>();


        for (int i = 1; i <= 15; i++){
            Note note = new Note(i, "name" + i, "some note text" + i);

            notesList.add(note);
        }



        // 2. Adapter
        ArrayAdapter<Note> adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                notesList
        );
        // 3. View (List view)

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }
//    public void doSomething(){
//        TextView myTextView = findViewById(R.id.MyTextView);
//        myTextView.setText("Labas, Sigitai");
//    }
    //
}