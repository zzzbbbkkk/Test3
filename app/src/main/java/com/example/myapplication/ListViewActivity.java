package com.example.myapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private List<Map<String, Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.list_view);
        dataList = new ArrayList<>();

        // 模拟数据，实际图片资源需替换为QQ群附件资源
        int[] images = {R.drawable.lion,R.drawable.tiger,
        R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
        String[] names = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};

        for (int i = 0; i < names.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", names[i]);
            map.put("image", images[i]);
            dataList.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, dataList, R.layout.list_item,
                new String[]{"name", "image"},
                new int[]{R.id.tv_animal_name, R.id.iv_animal_image});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String animalName = (String) dataList.get(position).get("name");
            Toast.makeText(ListViewActivity.this, "选中：" + animalName, Toast.LENGTH_SHORT).show();

            // 发送通知
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel_id")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(animalName)
                    .setContentText("这是关于" + animalName + "的通知")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("channel_id", "Channel Name", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }

            notificationManager.notify(position, builder.build());
        });
    }
}