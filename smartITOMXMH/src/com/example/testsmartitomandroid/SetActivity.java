package com.example.testsmartitomandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView=new TextView(this);
//		textView.setText("������Ϣ");
		setContentView(textView);
	}
	
}