package date.intec.be.multifragmentsapp.fragments;


import android.app.Activity;
import android.location.GpsStatus;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import date.intec.be.multifragmentsapp.R;
import date.intec.be.multifragmentsapp.helper.PersonAdapter;
import date.intec.be.multifragmentsapp.model.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerson extends Fragment {

    private ListView mLvPersons;
    private PersonAdapter adapter;
    private List<Person> persons;
    private OnPersonSelectedListener listener;
    private Person person;


    public interface OnPersonSelectedListener{
        public void showPerson(String person);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof  OnPersonSelectedListener){
         listener = (OnPersonSelectedListener) activity;
        }
        else{
            throw new ClassCastException(activity.toString() + " must implement the FragmentPerson.OnPersonSelectedListener");
        }
    }

    public FragmentPerson() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        persons = new ArrayList<>();
        persons.add(new Person("Bert",15));
        persons.add(new Person("Scarlet Johansen", 24));
        persons.add(new Person("Naomi Campbell", 26));
        persons.add(new Person("Adriana Lima", 28));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


            View view = inflater.inflate(R.layout.fragment_person, container, false);
            mLvPersons = (ListView) view.findViewById(R.id.lstPersons);
            adapter = new PersonAdapter(getActivity(),persons);
            mLvPersons.setAdapter(adapter);

            mLvPersons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                person = (Person) parent.getItemAtPosition(position);
                  listener.showPerson(person.toString());
                }
            });

        return view;
    }


}
