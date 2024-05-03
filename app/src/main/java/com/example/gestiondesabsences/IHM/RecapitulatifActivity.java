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
    private TextView txtLibelle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recapitulatif);
        daoJudoka = new JudokaDAO(this);
        try {
            adapterJudoka = new JudokaAdapter(this, daoJudoka.read(), this);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        constructeurGraphique();
        try {
            afficherJudokas();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public void constructeurGraphique(){
        rvLesJudokas = (RecyclerView) findViewById(R.id.rvLesJudokas);
    }

    public void afficherJudokas() throws ParseException {
        rvLesJudokas.setLayoutManager(new LinearLayoutManager(this));
        adapterJudoka = new JudokaAdapter(this, daoJudoka.read(), this);
        rvLesJudokas.setAdapter(adapterJudoka);
    }

    public void onItemClick(int position){

    }


}