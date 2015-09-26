package br.com.ceduphh.bruno.paisesamericadosul;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by BRUNO on 09/09/2014.
 */
public class CountriesActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] names = getResources().getStringArray(R.array.names);
        String[] capitals = getResources().getStringArray(R.array.capitals);
        TypedArray flags = getResources().obtainTypedArray(R.array.flags);

        Country[] countries = new Country[names.length];
        for (int i = 0; i < countries.length; i++) {
            countries[i] = new Country(names[i], capitals[i], flags.getResourceId(i, -1));
        }

        flags.recycle();

        CountryAdapter adapter = new CountryAdapter(this, countries);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        Country country = (Country) listView.getAdapter().getItem(position);

        //Bundle bundle = new Bundle();
        //bundle.putString("NAME",country.getName());

        Intent intent = new Intent(this, ContriesDetailsActivity.class);
        //intent.putExtras(bundle);
        intent.putExtra("NAME",country.getName());
        // startActivity(intent,bundle);
        startActivity(intent);
    }

    private class CountryAdapter extends ArrayAdapter<Country> {

        public CountryAdapter(Context context, Country[] countries) {
            super(context, 0, countries);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();

            Country country = (Country) getItem(position);

            View view = inflater.inflate(R.layout.america_do_sul, null);

            ImageView flagImageView = (ImageView) view.findViewById(R.id.flag);
            flagImageView.setBackgroundResource(country.getFlag());

            TextView nameTextView = (TextView) view.findViewById(R.id.name);
            nameTextView.setText(country.getName());

            TextView capitalTextView = (TextView) view.findViewById(R.id.capital);
            capitalTextView.setText(country.getCapital());

            return view;
        }
    }
}
