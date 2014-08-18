package com.example.bmt_proekt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class Registracija extends Activity implements OnClickListener{
EditText ime,prezime,maticen;
DatePicker date;
	
	@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.registracija);
	ime=(EditText)findViewById(R.id.editText1);
	prezime=(EditText)findViewById(R.id.editText2);
	maticen=(EditText)findViewById(R.id.editText3);
	date = (DatePicker)findViewById(R.id.datePicker1);
	
	Button sledna=(Button)findViewById(R.id.button1);
	
	//PREFRLANJE NA NAREDNATA STRANA
	sledna.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent nextScreen=new Intent(getApplicationContext(),Registracija2.class);
			nextScreen.putExtra("ime", ime.getText().toString());
			nextScreen.putExtra("prezime", prezime.getText().toString());
			nextScreen.putExtra("maticen", maticen.getText().toString());
			nextScreen.putExtra("date", date.getDayOfMonth()+" "+date.getMonth()+1+" "+date.getYear());
			startActivity(nextScreen);
		}
	});
	
	getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
}

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	
}
}
