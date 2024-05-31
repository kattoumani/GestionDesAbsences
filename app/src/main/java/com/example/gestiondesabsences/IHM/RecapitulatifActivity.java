package com.example.gestiondesabsences.IHM;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gestiondesabsences.DAO.JudokaDAO;
import com.example.gestiondesabsences.METIER.Judoka;
import com.example.gestiondesabsences.R;

import java.text.ParseException;
import java.util.ArrayList;

public class RecapitulatifActivity extends AppCompatActivity implements OnItemClickListener {
    private RecyclerView rvLesJudokas;
    Judoka unJudoka;
    private ArrayList<Judoka> lesJudokas;
    JudokaAdapter adapterJudoka;
    JudokaDAO daoJudoka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recapitulatif);
        daoJudoka = new JudokaDAO(this);adapterJudoka = new JudokaAdapter(this, daoJudoka.read(), this);
        constructeurGraphique();
        afficherJudokas();

    }

    public void constructeurGraphique(){
        rvLesJudokas = (RecyclerView) findViewById(R.id.rvLesJudokas);
    }

    public void afficherJudokas() {
        rvLesJudokas.setLayoutManager(new LinearLayoutManager(this));
        adapterJudoka = new JudokaAdapter(this, daoJudoka.read(), this);
        rvLesJudokas.setAdapter(adapterJudoka);
    }


    @Override
    public void onItemClick(int position) {

    }
}