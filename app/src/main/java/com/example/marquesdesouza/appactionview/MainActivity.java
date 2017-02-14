package com.example.marquesdesouza.appactionview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
        private EditText edtSMS,edtSITE,edtGPS1,edtGPS2;
        private Button btnSMS,btnSITE,btnGPS;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtGPS1=(EditText) findViewById(R.id.edt_gps);
       edtGPS2=(EditText)findViewById(R.id.edit_GPS2);
       edtSITE=(EditText)findViewById(R.id.edt_site);
       edtSMS=(EditText)findViewById(R.id.edt_sms);
       btnGPS=(Button)findViewById(R.id.btn_gps);
       btnSITE=(Button) findViewById(R.id.btn_site);
       btnSMS=(Button) findViewById(R.id.btn_sms);
       btnSITE.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intentSite = new Intent(Intent.ACTION_VIEW);

               String site = edtSITE.getText().toString();
               if (!site.startsWith("http://")) {
                   site = "http://" + site;
               }

               intentSite.setData(Uri.parse(site));
               startActivity(intentSite);
           }
       });
       btnSMS.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intentSMS = new Intent(Intent.ACTION_VIEW);
               intentSMS.setData(Uri.parse("sms:" + edtSMS.getText()));
               startActivity(intentSMS);
           }
       });
       btnGPS.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intentMapa = new Intent(Intent.ACTION_VIEW);
               intentMapa.setData(Uri.parse("geo:" + edtGPS1.getText()+","+edtGPS2.getText()));
              startActivity(intentMapa);
           }
       });
    }
}
