package com.judai.asif;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AUinfo extends AppCompatActivity {
    TextView na,ca,ea,ea1,tif,as;
    ImageView  ia;
    ListView lsskill;
    ArrayList<Skills> aList;
    SkillAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auinfo);
        Intent intent = getIntent();
        AUs aUs = (AUs) intent.getSerializableExtra("user");
        na = findViewById(R.id.namea);
        ca=findViewById(R.id.Classa);
        ea=findViewById(R.id.Elea);
        ea1=findViewById(R.id.Elea1);
        ia=findViewById(R.id.imga);
        tif=findViewById(R.id.tif);
        as=findViewById(R.id.astar);
        na.setText(aUs.get_name());
        ca.setText(aUs.get_class());
        ea.setText(aUs.get_ele1());
        String cele = aUs.get_ele2();
        if(cele.equals("")==true)
        {
            ea1.setText(aUs.get_ele2());
        }
        else
        {
            String c = "/  ";
            cele = c.concat(aUs.get_ele2());
            ea1.setText(cele);
        }
        tif.setText(aUs.get_info());
        as.setText(aUs.get_star());
        ia.setImageResource(aUs.get_img());
        lsskill = findViewById(R.id.lskill);
        aList = new ArrayList<>();
        aList.add(new Skills(aUs.get_sk1(),aUs.get_img1()));
        aList.add(new Skills(aUs.get_sk2(),aUs.get_img2()));
        aList.add(new Skills(aUs.get_sk3(),aUs.get_img3()));
        adapter = new SkillAdapter(this,aList,R.layout.skill_row);
        lsskill.setAdapter(adapter);



    }
}