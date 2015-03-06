package date.intec.be.multifragmentsapp.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import date.intec.be.multifragmentsapp.R;
import date.intec.be.multifragmentsapp.model.Person;

/**
 * Created by JawadA on 27/02/2015.
 */
public class PersonAdapter extends BaseAdapter {

   List<Person> persons;
    Context context;

    public PersonAdapter(Context context, List<Person> persons) {
        this.context = context;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);

        }
        TextView name = (TextView) convertView.findViewById(R.id.txtv_name);
        TextView age = (TextView) convertView.findViewById(R.id.txtv_Age);

        name.setText(getItem(position).getName());
        age.setText(getItem(position).getAge() + "");


        return convertView;

    }
}
