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
        List<String> notesList = new ArrayList<>();
        notesList.addAll(Arrays.asList("Pirmadiens",
                "Antradienis",
                "Trečiadienis",
                "Ketvirtadienis",
                "Penktadienis",
                "Šeštadienis",
                "Sekmadienis"
        ));
        // 2. Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
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
}