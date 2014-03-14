package com.example.testsmartitomandroid;

import java.util.ArrayList; 
import java.util.List; 

import com.example.testsmartitomandroid.R;

import android.app.Activity; 
import android.content.Context; 
import android.os.Bundle; 
import android.view.LayoutInflater; 
import android.view.View; 
import android.view.ViewGroup; 
import android.widget.AdapterView; 
import android.widget.BaseAdapter; 
import android.widget.GridView; 
import android.widget.ImageView; 
import android.widget.TextView; 
import android.widget.Toast; 
import android.widget.AdapterView.OnItemClickListener; 
 
public class WorkActivity extends Activity 
{ 
    private GridView gridView; 
  //图片的文字标题 
    private String[] titles = new String[] 
    { "消息管理", "设备信息", "告警处理", "链路管理", "二维条码", "工单处理", "链路管理", "二维条码"}; 
    private int[] images = new int[]{        
            R.drawable.a, R.drawable.a, R.drawable.a,  
            R.drawable.a, R.drawable.a, R.drawable.a,  
            R.drawable.a, R.drawable.a
    }; 
 
    @Override
    public void onCreate(Bundle savedInstanceState){ 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.work); 
        gridView = (GridView) findViewById(R.id.gridview); 
        PictureAdapter adapter = new PictureAdapter(titles, images, this); 
        gridView.setAdapter(adapter); 
 
        gridView.setOnItemClickListener(new OnItemClickListener() 
            { 
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
                { 
                    Toast.makeText(WorkActivity.this, "pic" + (position+1), Toast.LENGTH_SHORT).show(); 
                } 
            }); 
    } 
} 
//�Զ��������� 
class PictureAdapter extends BaseAdapter{ 
    private LayoutInflater inflater; 
    private List<Picture> pictures; 
 
    public PictureAdapter(String[] titles, int[] images, Context context) 
    { 
        super(); 
        pictures = new ArrayList<Picture>(); 
        inflater = LayoutInflater.from(context); 
        for (int i = 0; i < images.length; i++) 
        { 
            Picture picture = new Picture(titles[i], images[i]); 
            pictures.add(picture); 
        } 
    } 
 
    @Override
    public int getCount() 
    { 
        if (null != pictures) 
        { 
            return pictures.size(); 
        } else
        { 
            return 0; 
        } 
    } 
 
    @Override
    public Object getItem(int position) 
    { 
        return pictures.get(position); 
    } 
 
    @Override
    public long getItemId(int position) 
    { 
        return position; 
    } 
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) 
    { 
        ViewHolder viewHolder; 
        if (convertView == null) 
        { 
            convertView = inflater.inflate(R.layout.work_item, null); 
            viewHolder = new ViewHolder(); 
            viewHolder.title = (TextView) convertView.findViewById(R.id.title); 
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image); 
            convertView.setTag(viewHolder); 
        } else
        { 
            viewHolder = (ViewHolder) convertView.getTag(); 
        } 
        viewHolder.title.setText(pictures.get(position).getTitle()); 
        viewHolder.image.setImageResource(pictures.get(position).getImageId()); 
        return convertView; 
    } 
 
} 
 
class ViewHolder 
{ 
    public TextView title; 
    public ImageView image; 
} 
 
class Picture 
{ 
    private String title; 
    private int imageId; 
 
    public Picture() 
    { 
        super(); 
    } 
 
    public Picture(String title, int imageId) 
    { 
        super(); 
        this.title = title; 
        this.imageId = imageId; 
    } 
 
    public String getTitle() 
    { 
        return title; 
    } 
 
    public void setTitle(String title) 
    { 
        this.title = title; 
    } 
 
    public int getImageId() 
    { 
        return imageId; 
    } 
 
    public void setImageId(int imageId) 
    { 
        this.imageId = imageId; 
    } 
} 
