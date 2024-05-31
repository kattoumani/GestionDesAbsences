package com.example.gestiondesabsences.IHM;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gestiondesabsences.DAO.CategorieDAO;
import com.example.gestiondesabsences.DAO.JudokaDAO;
import com.example.gestiondesabsences.METIER.Categorie;
import com.example.gestiondesabsences.METIER.Judoka;
import com.example.gestiondesabsences.R;

import java.util.ArrayList;
import java.util.List;

public class AppelActivity extends AppCompatActivity implements OnItemClickListener {
    private RecyclerView rvLesCategories, rvJudokasPopUp;
    Categorie uneCategorie;
    private ArrayList<Categorie> lesCategories;
    CategorieAdapter adapterCategorie;
    CategorieDAO daoCategorie;

    JudokaDAO daoJudoka;
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

    /*private void setupCategoriesRecyclerView(Categorie categorie) {
        RecyclerView rvCategories = findViewById(R.id.rvLesCategories);
        rvCategories.setLayoutManager(new LinearLayoutManager(this));

        List<Categorie> categories = daoCategorie.read();
        CategorieAdapter categorieAdapter = new CategorieAdapter(this, categories, this) {
            public void onClick(View view) {
                Intent intent = new Intent(AppelActivity.this, GestionActivity.class);
                intent.putExtra("categorieId", categorie.getId());
                startActivity(intent);
            }
        };
        rvCategories.setAdapter(categorieAdapter);
    }*/
}