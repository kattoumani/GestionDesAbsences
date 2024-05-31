package com.example.gestiondesabsences.IHM;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gestiondesabsences.DAO.CategorieDAO;
import com.example.gestiondesabsences.DAO.JudokaDAO;
import com.example.gestiondesabsences.METIER.Categorie;
import com.example.gestiondesabsences.METIER.Judoka;
import com.example.gestiondesabsences.R;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class GestionActivity extends AppCompatActivity implements OnItemClickListener {
    private RecyclerView rvLesJudokas;
    Judoka unJudoka;
    private ArrayList<Judoka> lesJudokas;
    private JudokaAdapter adapterJudoka;
    private CategorieAdapter categorieAdapter;

    JudokaDAO daoJudoka;
    CategorieDAO daoCategorie;

    private Button btnAjouter;
    private TextView txtNom, txtPrenom, txtNumeroTelephone, txtDateNaissance, txtCategorie;

    private View.OnClickListener ajouterJudoka = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ajouterJudoka();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);
        daoJudoka = new JudokaDAO(this);
        adapterJudoka = new JudokaAdapter(this, daoJudoka.read(), this);
        constructeurGraphique();
        afficherJudokas();
        btnAjouter.setOnClickListener(ajouterJudoka);
    }

    public void constructeurGraphique(){
        txtNom = (TextView) findViewById(R.id.editTextNom);
        txtPrenom = (TextView) findViewById(R.id.editTextPrenom);
        txtNumeroTelephone = (TextView) findViewById(R.id.editTextNumeroTelephone);
        txtDateNaissance = (TextView) findViewById(R.id.editTextDateNaissance);
        txtCategorie = (TextView) findViewById(R.id.editTextCategorie);
        rvLesJudokas = (RecyclerView) findViewById(R.id.rvLesJudokas);
        btnAjouter = (Button) findViewById(R.id.btnAjouter);
    }

    public void afficherJudokas() {
        rvLesJudokas.setLayoutManager(new LinearLayoutManager(this));
        adapterJudoka = new JudokaAdapter(this, daoJudoka.read(), this);
        rvLesJudokas.setAdapter(adapterJudoka);
    }

    public void ajouterJudoka(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.ajouter_judoka, null);
        dialogBuilder.setView(dialogView);
        final EditText editTextNom = dialogView.findViewById(R.id.editTextNom);
        final EditText editTextPrenom = dialogView.findViewById(R.id.editTextPrenom);
        final EditText editTextNumeroTelephone = dialogView.findViewById(R.id.editTextNumeroTelephone);
        final EditText editTextDateNaissance = dialogView.findViewById(R.id.editTextDateNaissance);
        //final EditText editTextCategorie = dialogView.findViewById(R.id.editTextCategorie);
        //CategorieDAO uneCategorie = null;

        dialogBuilder.setTitle("Ajouter un judoka");
        dialogBuilder.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                String nom = editTextNom.getText().toString();
                String prenom = editTextPrenom.getText().toString();
                String numeroTelephone = editTextNumeroTelephone.getText().toString();
                String dateNaissance = editTextDateNaissance.getText().toString();
                //int categorie = Integer.parseInt(editTextCategorie.getText().toString());

                Judoka unJudoka = new Judoka(0, nom, prenom, numeroTelephone, dateNaissance);
                daoJudoka.insert(unJudoka);
            }
        });
        dialogBuilder.setNegativeButton("Annuler", null);
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    public void onItemClick(int position) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.ajouter_judoka, null);
        dialogBuilder.setView(dialogView);
        final EditText editTextNom = dialogView.findViewById(R.id.editTextNom);
        final EditText editTextPrenom = dialogView.findViewById(R.id.editTextPrenom);
        final EditText editTextNumeroTelephone = dialogView.findViewById(R.id.editTextNumeroTelephone);
        final EditText editDateNaissance = dialogView.findViewById(R.id.editTextDateNaissance);
        final Judoka unJudoka;

        unJudoka = daoJudoka.read().get(position);
        editTextNom.setText(unJudoka.getNom());
        editTextPrenom.setText(unJudoka.getPrenom());
        editTextNumeroTelephone.setText(unJudoka.getNumeroTelephone());
        editDateNaissance.setText(unJudoka.getDateNaissance());

        dialogBuilder.setTitle("Modifier / Supprimer ");
        dialogBuilder.setPositiveButton("Modifier",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String nom = editTextNom.getText().toString();
                        String prenom = editTextPrenom.getText().toString();
                        String numero = editTextNumeroTelephone.getText().toString();
                        String dateNaissance = editDateNaissance.getText().toString();

                        unJudoka.setNom(nom);
                        unJudoka.setPrenom(prenom);
                        unJudoka.setNumeroTelephone(numero);
                        unJudoka.setDateNaissance(dateNaissance);

                        daoJudoka.update(unJudoka);
                        afficherJudokas();
                    }
                });
        dialogBuilder.setNegativeButton("Annuler", null);
        dialogBuilder.setNeutralButton("Supprimer",

                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        daoJudoka.delete(unJudoka);
                        afficherJudokas();
                    }
                });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

}