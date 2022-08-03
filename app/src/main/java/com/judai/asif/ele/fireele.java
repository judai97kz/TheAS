package com.judai.asif.ele;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.judai.asif.AUinfo;
import com.judai.asif.AUs;
import com.judai.asif.AuAdapter;
import com.judai.asif.MainActivity;
import com.judai.asif.R;
import com.judai.asif.aurorians;

public class fireele extends Fragment {
    ListView red;
    AuAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_fire,container,false);
        red = view.findViewById(R.id.redls);
        adapter = new AuAdapter(getActivity(),aurorians.redls,R.layout.au_row);
        red.setAdapter(adapter);
        red.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AUs s = aurorians.redls.get(i);
                Intent intent = new Intent(getActivity(), AUinfo.class);
                intent.putExtra("user",s);
                startActivity(intent);
            }
        });
        return view;
    }
}
