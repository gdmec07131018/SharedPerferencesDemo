package cn.edu.gdmec.s0713108.sharedperferencesdemo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText et1, et2, et3;
	private final String name = "public";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
		et3 = (EditText) findViewById(R.id.et3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void Read(View view) {
		SharedPreferences sharedPreferences = getSharedPreferences(name,
				Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);
		String name = sharedPreferences.getString("name", "soul");
		int age = sharedPreferences.getInt("age",30);
		float height = sharedPreferences.getFloat("height", 1.8f);
		et1.setText(name);
		et2.setText(String.valueOf(age));
		et3.setText(String.valueOf(height));
	}

	public void Write(View view) {
		SharedPreferences sharedPreferences = getSharedPreferences(name,
				Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString("name",et1.getText().toString());
		editor.putInt("age",Integer.valueOf(et2.getText().toString()));
		editor.putFloat("height",Float.valueOf(et3.getText().toString()));
		editor.commit();
		editor.clear();
	}
}
