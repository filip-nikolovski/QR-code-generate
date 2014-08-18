package com.example.bmt_proekt;

/* Ovaa klasa e za kreirajne na QR CODE raboti :D  */


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.android.Contents;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.method.Touch;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Button button1 = (Button) findViewById(R.id.button1);
		//button1.setOnClickListener(this);
		
		
		
		///////////////////////////
		// KOD OD BMT_PROEKT //////
		Intent i = getIntent();
		String txtPassword = i.getStringExtra("pass");
		String txtPassword1 = i.getStringExtra("pass1");
		String txtRegister = i.getStringExtra("ime");
		String txtRegister1 = i.getStringExtra("Ime1");
		
		DatabaseHelper info = new DatabaseHelper(this);
		info.open();
		String data = info.getDataCustom(txtPassword,txtPassword1);
		String data1 = info.getDataCustom(txtRegister, txtRegister1);
		info.close();
		
		String LOG_TAG = "GenerateQRCode";
	
		//public void onClick(View v) {

		//	switch (v.getId()) {
		//	case R.id.button1:
				//EditText qrInput = (EditText) findViewById(R.id.qrInput);
				//String qrInputText = qrInput.getText().toString();
				Log.v(LOG_TAG, data+data1);

				// Find screen size
				WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
				Display display = manager.getDefaultDisplay();
				Point point = new Point();
				
				try{
				display.getSize(point);
				}catch (java.lang.NoSuchMethodError ignore) {
					point.x = display.getWidth();
			        point.y = display.getHeight();
				}
				
				int width = point.x;
				int height = point.y;
				int smallerDimension = width < height ? width : height;
				smallerDimension = smallerDimension * 3 / 4;

				// Encode with a QR Code image
				QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(data+data1, null,
						Contents.Type.TEXT, BarcodeFormat.QR_CODE.toString(),
						smallerDimension);
				try {
					Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
					ImageView myImage = (ImageView) findViewById(R.id.imageView1);
					myImage.setImageBitmap(bitmap);

				} catch (WriterException e) {
					e.printStackTrace();
				}

			//	break;
				
			

			// More buttons go here (if any) ...

		//	}
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

	// public void scanNow(View view){
	//
	// }

	
	//////////////////////////////////////////////////////
	/////KOD ZA KREIRAJNE QR RABOTI///////////////////////
	
//	private String LOG_TAG = "GenerateQRCode";
//	@Override
//	public void onClick(View v) {
//
//		switch (v.getId()) {
//		case R.id.button1:
//			EditText qrInput = (EditText) findViewById(R.id.qrInput);
//			String qrInputText = qrInput.getText().toString();
//			Log.v(LOG_TAG, qrInputText);
//
//			// Find screen size
//			WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
//			Display display = manager.getDefaultDisplay();
//			Point point = new Point();
//			display.getSize(point);
//			int width = point.x;
//			int height = point.y;
//			int smallerDimension = width < height ? width : height;
//			smallerDimension = smallerDimension * 3 / 4;
//
//			// Encode with a QR Code image
//			QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(qrInputText, null,
//					Contents.Type.TEXT, BarcodeFormat.QR_CODE.toString(),
//					smallerDimension);
//			try {
//				Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
//				ImageView myImage = (ImageView) findViewById(R.id.imageView1);
//				myImage.setImageBitmap(bitmap);
//
//			} catch (WriterException e) {
//				e.printStackTrace();
//			}
//
//			break;
//			
//		
//
//		// More buttons go here (if any) ...
//
//		}
//	}
//	
	
	/////// DO TUKA////////////////////////
	//////////////////////////////////////

	// public void scanNow(View view){
	// Log.d("test","button works!");
	// Intent intent = new Intent("com.google.zxing.client.android.SCAN");
	// intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE",
	// "QR_CODE_MODE");
	// startActivityForResult(intent, 0);
	//
	// }
	//
	// public void onActivityResult(int requestCode, int resultCode, Intent
	// intent){
	// if(requestCode == 0){
	// if(resultCode == RESULT_OK){
	// String contents = intent.getStringExtra("SCAN_RESULT");
	// String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
	// Log.i("Zxing", "contents: "+contents+" format: "+format);
	// }else if(requestCode == RESULT_CANCELED){
	// Log.i("Zxing", "Canceled");
	// }
	// }
	//
	// }

}
