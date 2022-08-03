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
import com.judai.asif.R;
import com.judai.asif.aurorians;

public class thunderele extends Fragment {
    ListView yellow;
    AuAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_thunder,container,false);
        yellow = view.findViewById(R.id.yellowls);
        adapter = new AuAdapter(getActivity(), aurorians.yellowls,R.layout.au_row);
        yellow.setAdapter(adapter);
        yellow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AUs s = aurorians.yellowls.get(i);
                Intent intent = new Intent(getActivity(), AUinfo.class);
                intent.putExtra("user",s);
                startActivity(intent);
            }
        });
        return view;
    }
}
