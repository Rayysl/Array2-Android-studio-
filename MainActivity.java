package com.intinya.tugas3rahmadipart2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ///Inisialisasi ArrayList
    private List kontenList = new ArrayList<>();
    //Inisialisasi ArrayAdapter
    private ArrayAdapter adapter = null;
    //Inisialisasi Variable ListVIew
    private ListView listView;

    //Inisialisasi Komponen2 Pendukung
    private EditText InputData;
    private Button SaveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_data);
        InputData = findViewById(R.id.input_data);
        SaveData = findViewById(R.id.save_data);

        //sample data default
        kontenList.add("AlQuran");
        kontenList.add("Shahih Bukhari");
        kontenList.add("Shahih Muslim");

        //Mengatur ArrayAdapter untuk listView
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, kontenList);
        listView.setAdapter(adapter);

        SaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menambahkan Konten yang akan ditampilkan pada ListView
                konten myKonten = new konten();
                myKonten.setData(InputData.getText().toString());
                adapter.add(myKonten.getData());
                Toast.makeText(getApplicationContext(),"Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
