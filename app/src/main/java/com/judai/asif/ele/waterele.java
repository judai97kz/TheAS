package com.judai.asif.ele;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.judai.asif.AUinfo;
import com.judai.asif.AUs;
import com.judai.asif.AuAdapter;
import com.judai.asif.R;
import com.judai.asif.aurorians;

import java.util.ArrayList;

public class waterele extends Fragment {
    ListView blue;
    AuAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_water,container,false);
        blue = view.findViewById(R.id.bluels);
        adapter = new AuAdapter(getActivity(), aurorians.bluels,R.layout.au_row);
        blue.setAdapter(adapter);
        blue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), AUinfo.class);
                intent.putExtra("user",i);
                startActivity(intent);
            }
        });
        aurorians.tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aurorians.tim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String tenau = aurorians.editText.getText().toString();
                        char[] charArray = tenau.toCharArray();
                        boolean foundSpace = true;
                        for(int i = 0; i < charArray.length; i++) {
                            if(Character.isLetter(charArray[i])) {
                                if(foundSpace) {
                                    charArray[i] = Character.toUpperCase(charArray[i]);
                                    foundSpace = false;
                                }
                            }
                            else {
                                foundSpace = true;
                            }
                        }
                        // chuy???n ?????i m???ng char th??nh string
                        tenau = String.valueOf(charArray);
                        locate(aurorians.bluels,tenau);
                    }
                });
            }
        });
        return view;
    }
    public void locate(ArrayList<AUs> arrayList , String target)
    {
        for(int i=0;i < arrayList.size();i++)
        {
            if(arrayList.get(i).get_name().equals(target)==true)
            {
                Intent intent = new Intent(getActivity(),AUinfo.class);
                intent.putExtra("user",i);
                startActivity(intent);
                break;
            }
            if(i == arrayList.size() - 1 && arrayList.get(i).get_name().equals(target)==false)
            {
                Toast.makeText(getActivity(),"Aurorian kh??ng t???n t???i trong h??? n?????c!",Toast.LENGTH_LONG).show();
            }
        }
    }
}
