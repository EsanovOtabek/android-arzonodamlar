package uz.lifepc.arzonodamlarv1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {

    PDFView book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0099ff")));

        String id=1+"";
        book=(PDFView)findViewById(R.id.pdfview);
        book.fromAsset(id+".pdf")
                .load();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.tool_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:{
                Toast.makeText(this,"About",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,About.class);
                startActivity(intent);
                return  true;
            }
            case R.id.contact:{
                Toast.makeText(this,"Contact",Toast.LENGTH_SHORT).show();
                return  true;
            }
            case R.id.logout:{
                finish();
                System.exit(2);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}