package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1={
            {"Doctor Name: Almedina Golos", "Hospital Address : Muje Pasica 1", "Exp : 1yrs", "Mobile No: 111111111", "010"},
            {"Doctor Name: Asmira Husic", "Hospital Address : Muje Pasica 2", "Exp : 2yrs", "Mobile No: 222222222", "020"},
            {"Doctor Name: Amna Obradovic", "Hospital Address : Muje Pasica 3", "Exp : 3yrs", "Mobile No: 333333333", "030"},
            {"Doctor Name: Enez Husnic", "Hospital Address : Muje Pasica 4", "Exp : 4yrs", "Mobile No: 444444444", "040"},
            {"Doctor Name: Amer Golos", "Hospital Address : Muje Pasica 5", "Exp : 5yrs", "Mobile No: 555555555", "050"}
    };
    private String[][] doctor_details2={
            {"Doctor Name: Harisa Golos", "Hospital Address : Muje Pasica 1", "Exp : 1yrs", "Mobile No: 111111111", "010"},
            {"Doctor Name: Ahmed Golos", "Hospital Address : Muje Pasica 2", "Exp : 2yrs", "Mobile No: 222222222", "020"},
            {"Doctor Name: Selma Golos", "Hospital Address : Muje Pasica 3", "Exp : 3yrs", "Mobile No: 333333333", "030"},
            {"Doctor Name: Jasna Golos", "Hospital Address : Muje Pasica 4", "Exp : 4yrs", "Mobile No: 444444444", "040"},
            {"Doctor Name: Elma Golos", "Hospital Address : Muje Pasica 5", "Exp : 5yrs", "Mobile No: 555555555", "050"}
    };
    private String[][] doctor_details3={
            {"Doctor Name: Merima Tikvesa", "Hospital Address : Muje Pasica 1", "Exp : 1yrs", "Mobile No: 111111111", "010"},
            {"Doctor Name: Amar Tikvesa", "Hospital Address : Muje Pasica 2", "Exp : 2yrs", "Mobile No: 222222222", "020"},
            {"Doctor Name: Mehmed Tikvesa", "Hospital Address : Muje Pasica 3", "Exp : 3yrs", "Mobile No: 333333333", "030"},
            {"Doctor Name: Cel Tikvesa", "Hospital Address : Muje Pasica 4", "Exp : 4yrs", "Mobile No: 444444444", "040"},
            {"Doctor Name: Sel Tikvesa", "Hospital Address : Muje Pasica 5", "Exp : 5yrs", "Mobile No: 555555555", "050"}
    };
    private String[][] doctor_details4={
            {"Doctor Name: Jasmin Col", "Hospital Address : Muje Pasica 1", "Exp : 1yrs", "Mobile No: 111111111", "010"},
            {"Doctor Name: Sudo Col", "Hospital Address : Muje Pasica 2", "Exp : 2yrs", "Mobile No: 222222222", "020"},
            {"Doctor Name: Sab Col", "Hospital Address : Muje Pasica 3", "Exp : 3yrs", "Mobile No: 333333333", "030"},
            {"Doctor Name: Sef Col", "Hospital Address : Muje Pasica 4", "Exp : 4yrs", "Mobile No: 444444444", "040"},
            {"Doctor Name: Selma Col", "Hospital Address : Muje Pasica 5", "Exp : 5yrs", "Mobile No: 555555555", "050"}
    };
    private String[][] doctor_details5={
            {"Doctor Name: Alena T", "Hospital Address : Muje Pasica 1", "Exp : 1yrs", "Mobile No: 111111111", "010"},
            {"Doctor Name: Samir K", "Hospital Address : Muje Pasica 2", "Exp : 2yrs", "Mobile No: 222222222", "020"},
            {"Doctor Name: Aldin V", "Hospital Address : Muje Pasica 3", "Exp : 3yrs", "Mobile No: 333333333", "030"},
            {"Doctor Name: Ermin H", "Hospital Address : Muje Pasica 4", "Exp : 4yrs", "Mobile No: 444444444", "040"},
            {"Doctor Name: Alema M", "Hospital Address : Muje Pasica 5", "Exp : 5yrs", "Mobile No: 555555555", "050"}
    };
TextView tv;
Button btn;
String[][] doctor_details = {};
HashMap<String, String>item;
SimpleAdapter sa;
ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.titleDoctorDetails);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDoctorDetails);
        lst.setAdapter(sa);
    }
}