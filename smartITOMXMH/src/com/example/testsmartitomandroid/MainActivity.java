package com.example.testsmartitomandroid;
import com.example.testsmartitomandroid.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.RadioGroup.OnCheckedChangeListener;
public class MainActivity extends TabActivity implements OnCheckedChangeListener{
	private RadioGroup mainTab;
	private TabHost tabhost;
	private Intent Work;
	private Intent Con;
	private Intent Tool;
	private Intent Set;
	private Button btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mainTab=(RadioGroup)findViewById(R.id.main_tab);
        mainTab.setOnCheckedChangeListener(this);
        tabhost = getTabHost();
        btn=(Button)findViewById(R.id.btn1);
        Work = new Intent(this, WorkActivity.class);
        tabhost.addTab(tabhost.newTabSpec("Work")
        		.setIndicator(getResources().getString(R.string.main_home), getResources().getDrawable(R.drawable.icon_1_n))
        		.setContent(Work));
        
        Con = new Intent(this, ConActivity.class);
		tabhost.addTab(tabhost.newTabSpec("Con")
	        	.setIndicator(getResources().getString(R.string.main_news), getResources().getDrawable(R.drawable.icon_2_n))
	        	.setContent(Con));
		
		Tool = new Intent(this, ToolActivity.class);
		tabhost.addTab(tabhost.newTabSpec("Tool")
	        	.setIndicator(getResources().getString(R.string.main_my_info), getResources().getDrawable(R.drawable.icon_3_n))
	        	.setContent(Tool));
		
		Set = new Intent(this,SetActivity.class);
		tabhost.addTab(tabhost.newTabSpec("Set")
	        	.setIndicator(getResources().getString(R.string.menu_search), getResources().getDrawable(R.drawable.icon_4_n))
	        	.setContent(Set));
		
		
    }
   

    @Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch(checkedId){
		case R.id.radio_button0:
			this.tabhost.setCurrentTabByTag("Work");
			
			btn.setText("功能导航");
			break;
		case R.id.radio_button1:
			this.tabhost.setCurrentTabByTag("Con");
			btn.setText("我的关注");
			break;
		case R.id.radio_button2:
			this.tabhost.setCurrentTabByTag("Tool");
			btn.setText("工具箱");
			break;
		case R.id.radio_button3:
			this.tabhost.setCurrentTabByTag("Set");
			btn.setText("设置");
			break;
		
		}
	}
    
    
}