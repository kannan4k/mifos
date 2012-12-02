package com.example.mifosx;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	DatabaseHandler db=null;
	Button loginBtn;
	EditText username,password;
	

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        db = new DatabaseHandler(this);
        SQLiteDatabase sqlitedb=db.getWritableDatabase();
        
     
        loginBtn=(Button)findViewById(R.id.loginButton);
        username=(EditText)findViewById(R.id.usernameId);
        password=(EditText)findViewById(R.id.passwordId);
        
        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	String uname=username.getText().toString();
            	String passwd=password.getText().toString();
            	//send the request to url
            	//show the next page if result is success
            	System.out.println(uname+passwd+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            	Intent intent= new Intent(getApplicationContext(),Registration.class);
            	startActivity(intent);
            }
        });
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
