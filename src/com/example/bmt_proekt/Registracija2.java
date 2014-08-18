package com.example.bmt_proekt;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class Registracija2 extends Activity implements OnClickListener{
	
	//TextView proba;
	EditText adresa,grad,password,idTelefon,username;
	String s1,s2,s3,s4;
	Button nezadolzitelno,qr;
	
	@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.registracija2);
	
	//ScrollView sView = (ScrollView)findViewById(R.id.s)
	
	
	Intent i=getIntent();
    s1=i.getStringExtra("ime");
    s2=i.getStringExtra("prezime");
    s3=i.getStringExtra("maticen");
    s4=i.getStringExtra("date");
    
	adresa=(EditText)findViewById(R.id.editText1);
	grad=(EditText)findViewById(R.id.editText2);
	password=(EditText)findViewById(R.id.editText4);
	username=(EditText)findViewById(R.id.editUsername);
	idTelefon=(EditText)findViewById(R.id.editText5);
	//nezadolzitelno=(Button)findViewById(R.id.button2);
	qr=(Button)findViewById(R.id.qr);
	//proba = (TextView)findViewById(R.id.proba);
	
	DatabaseHelper hel = new DatabaseHelper(Registracija2.this);
	hel.open();
	 final int num = hel.checjUsername(username.getText().toString());
	
	//proba.setText(s1);
	
	Button zacuvaj=(Button)findViewById(R.id.button1);
	zacuvaj.setOnClickListener(new OnClickListener() {
		
		
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			try{
			DatabaseHelper db=new DatabaseHelper(Registracija2.this);
			db.open();
		
			
			if(db.checjUsername(username.getText().toString())>0){
				AlertDialog.Builder a = new AlertDialog.Builder(Registracija2.this);
				a.setTitle("Zafateno username");
				a.setMessage("izberi novo");
				a.setPositiveButton("OK",null);
				AlertDialog dialog= a.show();
				
			}else if(password.getText().toString().equals("") && username.getText().toString().equals("")){
				
				AlertDialog.Builder a = new AlertDialog.Builder(Registracija2.this);
				a.setTitle("Prazno username ili password");
				a.setMessage("vnesi nesto");
				a.setPositiveButton("OK",null);
				AlertDialog dialog= a.show();
			}
			
			
			else {
				 
				String name=s1;
				String surname=s2;
				String embg=s3;
				String dateBirth=s4;
				String street=adresa.getText().toString();
				String city=grad.getText().toString();
				String username1 = username.getText().toString();
				String password1=password.getText().toString();
				String PhoneID=idTelefon.getText().toString();
							
				DatabaseHelper entry=new DatabaseHelper(Registracija2.this);
					entry.open();
				entry.createEntry(name, surname, embg,dateBirth, street, city, username1, password1, PhoneID);
				entry.close();
				db.close();
				
				AlertDialog.Builder b = new AlertDialog.Builder(Registracija2.this);
				b.setTitle("saved"+num);
				b.setMessage("your data is saved successfully");
				b.setPositiveButton("OK",null);
				AlertDialog dialog= b.show();
			}
			}catch (Exception e) {
				// TODO: handle exception
				String error= e.toString();
				Dialog d = new Dialog(Registracija2.this);
				d.setTitle("NEUSPESNO");
				TextView tv=new TextView(Registracija2.this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//BAZATA ZAPOCNUVA OD TUKA
//			boolean didItWork=true;			
//			
//					
//			try{
//			String name=s1;
//			String surname=s2;
//			String embg=s3;
//			String dateBirth=s4;
//			String street=adresa.getText().toString();
//			String city=grad.getText().toString();
//			String username1 = username.getText().toString();
//			String password1=password.getText().toString();
//			String PhoneID=idTelefon.getText().toString();
//						
//			 DatabaseHelper entry=new DatabaseHelper(Registracija2.this);
//						entry.open();			
//						
//						if(db.checjUsername(username1) < 0){
//							AlertDialog.Builder a = new AlertDialog.Builder(Registracija2.this);
//							a.setTitle("Zafateno username");
//							a.setMessage("izberi novo");
//							a.setPositiveButton("OK",null);
//							AlertDialog dialog= a.show();
//							
//						
//						}
//						else{
//							entry.createEntry(name, surname, embg,dateBirth, street, city, username1, password1, PhoneID);
//							entry.close();
//							db.close();
//						
//								
//																
//						}
//			
//			}
//			
//			
//			
//			catch(Exception e){
//							didItWork=false;
//							
//							String error= e.toString();
//							Dialog d = new Dialog(Registracija2.this);
//							d.setTitle("NEUSPESNO");
//							TextView tv=new TextView(Registracija2.this);
//							tv.setText(error);
//							d.setContentView(tv);
//							d.show();
//							
//						}
//		
//							finally{
//							if(didItWork){
////								Dialog d = new Dialog(Registracija2.this);
////								d.setTitle("OK");
////								TextView tv=new TextView(Registracija2.this);
////								tv.setText("USPESNO SNIMANJE");
////								d.setContentView(tv);
////								d.show();
//								
//								AlertDialog.Builder b = new AlertDialog.Builder(Registracija2.this);
//								b.setTitle("saved"+num);
//								b.setMessage("your data is saved successfully");
//								b.setPositiveButton("OK",null);
//								AlertDialog dialog= b.show();
//				
//			 
//			
//								}
//							}	
//			
			
		
			
		}});
	
	
	// KODOT ZA BAZATA
	
	//KOPCE ZA POGLED NA BAZATA
//	nezadolzitelno.setOnClickListener(new OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			Intent pogled=new Intent(getApplicationContext(),PodatociBaza.class);
//			startActivity(pogled);
//		}
//	});
//	
//	
	
	
	
	
	
	
	qr.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent data = new Intent(getApplicationContext(),MainActivity.class);
			data.putExtra("ime", password.getText().toString());
			data.putExtra("Ime1", username.getText().toString());
			startActivity(data);
			
		}
	});
	

	

	//go naogja imey na telefonot i go pecati vo text poleto
	//(treba da se napravi vo panela da ne moze da se modiicira)
	TelephonyManager tm = (TelephonyManager) getSystemService(android.content.Context.TELEPHONY_SERVICE);
	idTelefon.setText(tm.getDeviceId());
//	
//	TelephonyManager tMgr=(TelephonyManager)mAppContext.getSystemService(Context.TELEPHONY_SERVICE);
//	mPhoneNumber = tMgr.getLine1Number();
//	
	//sim_karticka.setText(s4);
	
	
	getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	
	}
	

//	IntentIntegrator integrator = new IntentIntegrator();
//	
//	

	
@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	
}
}
