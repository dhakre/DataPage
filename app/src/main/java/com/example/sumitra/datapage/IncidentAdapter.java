package com.example.sumitra.datapage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by sumitra on 9/10/2017.
 */

public class IncidentAdapter extends ArrayAdapter {
   Context context;
    List list=new ArrayList();

    public IncidentAdapter(@NonNull Context context, @LayoutRes int resource, List<Incident> incidentList) {
        super(context, resource);
    }


    public void add(Incident object) {
        super.add(object);
        list.add(object);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        incidentHolder incidentholder;
        if(row==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.display_row_data,parent,false);
            incidentholder=new incidentHolder();
            incidentholder.tx_status= (TextView) row.findViewById(R.id.status);
            incidentholder.tx_clientName= (TextView) row.findViewById(R.id.clientName);
            incidentholder.tx_creationDate= (TextView) row.findViewById(R.id.creationDate);
            incidentholder.tx_lastDate= (TextView) row.findViewById(R.id.lastDate);
            incidentholder.bn_open= (Button) row.findViewById(R.id.bnOpen);
            incidentholder.bn_open.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(context, PopUpActivity.class);
                   // intent.putextra("your_extra","your_class_value");
                    context.startActivity(intent);
                }
            });
            row.setTag(incidentholder);

        }
        else
        {
            incidentholder=(incidentHolder)row.getTag();
        }

        Incident incident= (Incident) getItem(position);
        incidentholder.tx_status.setText(incident.status.toString());
        incidentholder.tx_clientName.setText(incident.clientName.toString());
        incidentholder.tx_creationDate.setText(Integer.toString(incident.Dcreation));
        incidentholder.tx_lastDate.setText(Integer.toString(incident.Dexchange));


        return row;
    }
    //holder class
    static class incidentHolder{

        TextView tx_clientName,tx_creationDate,tx_lastDate,tx_status;
        Button bn_open;

    }

}
