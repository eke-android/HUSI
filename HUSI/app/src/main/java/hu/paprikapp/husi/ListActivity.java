package hu.paprikapp.husi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    public static final String KEY_ALCOHOL_LIST = "ALCOHOL_LIST";
    private ArrayList<AlcoholVolume> alcoholVolumeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<AlcoholVolume> alcoholAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alcoholVolumeList);
        listView.setAdapter(alcoholAdapter);
    }
}
