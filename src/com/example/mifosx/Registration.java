package com.example.mifosx;

import com.example.POJO.Client;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends Activity {
	
		Button registerBtn=null;
		EditText office=null;
		EditText fname=null;
		EditText lname=null;
		EditText cbname=null;
		EditText externalId=null;
		EditText joiningDate=null;
		
		DatabaseHandler db=null;
		
	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.registration);
	        
	        registerBtn=(Button)findViewById(R.id.registerBtn);
	        office=(EditText)findViewById(R.id.office);
	        fname=(EditText)findViewById(R.id.fname);
	        lname=(EditText)findViewById(R.id.lname);
	        cbname=(EditText)findViewById(R.id.cbname);
	        externalId=(EditText)findViewById(R.id.externalid);
	        joiningDate=(EditText)findViewById(R.id.joiningdate);
	        
	        registerBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Client client=new Client();
					client.setOffice(office.getText().toString());
					client.setFirstName(fname.getText().toString());
					client.setLastName(lname.getText().toString());
					client.setCbName(cbname.getText().toString());
					client.setExternalId(externalId.getText().toString());
					client.setJoiningDate(joiningDate.getText().toString());
					
					db=new DatabaseHandler(getApplicationContext());
					db.addClient(client);
				}
			});
	        
	        
	        
	  }

}
