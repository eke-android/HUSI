package hu.paprikapp.husi;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    public static final String KEY_ALCOHOL_LIST = "ALCOHOL_LIST";
    private ArrayList<AlcoholVolume> alcoholVolumeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            alcoholVolumeList = extra.getParcelableArrayList(KEY_ALCOHOL_LIST);
        }

        ListView listView = (ListView) findViewById(R.id.listView);
        AlcoholArrayAdapter alcoholAdapter = new AlcoholArrayAdapter(this, R.layout.list_item, alcoholVolumeList);
        listView.setAdapter(alcoholAdapter);
    }

    public static class AlcoholArrayAdapter extends ArrayAdapter<AlcoholVolume>{

        public AlcoholArrayAdapter(Context context, int resource, List<AlcoholVolume> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;

            if(view == null){
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.list_item, null);
            }

            TextView volumeText = (TextView) view.findViewById(R.id.volume);
            TextView alcoholText = (TextView) view.findViewById(R.id.alcohol);
            volumeText.setText(String.valueOf(getItem(position).getVolume()) + "ml");
            alcoholText.setText(String.valueOf(getItem(position).getAlcohol()) + "%");

            return view;
        }
    }
}
