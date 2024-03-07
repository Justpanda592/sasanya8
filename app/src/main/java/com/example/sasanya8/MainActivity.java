package com.example.sasanya8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
    }

    void start() {
        String[] valutes = {"RUB","ZAR","SGD","TRY","KRW","RMB","JPY"};
        String[] desc_valutes = {"Russian rouble","South African rand","Singapore dollar","Turkish lira","Korean won","Chinese yuan","Japanese yen"};
        String[] cities = {"Moscow","Pretoria","Singapore","Ankara","Seoul","Beijing","Tokyo"};
        int[] images = {R.drawable.ru, R.drawable.by, R.drawable.de, R.drawable.am, R.drawable.kr, R.drawable.cn, R.drawable.jp};

        ListView lvMain = findViewById(R.id.lvMain);

        CustomAdapter adapter = new CustomAdapter(this, valutes, desc_valutes, cities, images);
        lvMain.setAdapter(adapter);
    }

    public class CustomAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final String[] valutes;
        private final String[] descriptions;
        private final String[] capitals;
        private final int[] images;

        public CustomAdapter(Context context, String[] valutes, String[] descriptions, String[] capitals, int[] images) {
            super(context, R.layout.list_item_custom, valutes);
            this.context = context;
            this.valutes = valutes;
            this.descriptions = descriptions;
            this.capitals = capitals;
            this.images = images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_item_custom, parent, false);

            TextView currencyName = rowView.findViewById(R.id.currencyName);
            TextView description = rowView.findViewById(R.id.description);
            TextView capital = rowView.findViewById(R.id.capital);
            ImageView imageView = rowView.findViewById(R.id.imageView);

            currencyName.setText(valutes[position]);
            description.setText(descriptions[position]);
            capital.setText(capitals[position]);
            imageView.setImageResource(images[position]);

            return rowView;
        }
    }
}