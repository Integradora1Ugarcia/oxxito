package mx.edu.utng.ugarcia.oxxito;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.edu.utng.ugarcia.oxxito.dao.ProductDAO;
import mx.edu.utng.ugarcia.oxxito.models.Product;

public class ListProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating);




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent (view.getContext(), NewProductActivity.class);
                startActivityForResult(intent2, 0);
            }
        });

        // Se crea un objeto para mostrar todos los productos
        ProductDAO dao = new ProductDAO(getApplicationContext());
        List<Product> listProducts;
        try {
            listProducts = dao.getAll();
            List<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
            for (Product pro : listProducts) {

            }
        } catch (Exception e) {

        }



    }



}
