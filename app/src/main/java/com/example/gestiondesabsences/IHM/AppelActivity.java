package com.example.gestiondesabsences.IHM;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gestiondesabsences.DAO.CategorieDAO;
import com.example.gestiondesabsences.METIER.Categorie;
import com.example.gestiondesabsences.R;

import java.util.ArrayList;

public class AppelActivity extends AppCompatActivity implements OnItemClickListener {
    private RecyclerView rvLesCategories;
    Categorie uneCategorie;
    private ArrayList<Categorie> lesCategories;
    CategorieAdapter adapterCategorie;
    CategorieDAO daoCategorie;
    private TextView txtlibelle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appel);
        daoCategorie = new CategorieDAO(this);
        adapterCategorie = new CategorieAdapter(this, daoCategorie.read(), this);
        constructeurGraphique();
        afficherCategories();
    }

    public void constructeurGraphique(){
        rvLesCategories = (RecyclerView) findViewById(R.id.rvLesCategories);
    }

    private void afficherCategories(){
        rvLesCategories.setLayoutManager(new LinearLayoutManager(this));
        adapterCategorie = new CategorieAdapter(this, daoCategorie.read(), this);
        rvLesCategories.setAdapter(adapterCategorie);

    }



    @Override
    public void onItemClick(int position) {

    }
}