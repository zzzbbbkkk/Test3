package com.example.myapplication;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActionModeActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> dataList;
    private ArrayAdapter<String> adapter;
    private ActionMode actionMode;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode);

        listView = findViewById(R.id.list_view);
        dataList = new ArrayList<>();
        dataList.add("One");
        dataList.add("Two");
        dataList.add("Three");
        dataList.add("Four");
        dataList.add("Five");

        // 注意：这里使用新的列表项布局 action_mode_list_item.xml
        adapter = new ArrayAdapter<>(this, R.layout.action_mode_list_item, R.id.tv_text, dataList);
        listView.setAdapter(adapter);

        // 长按列表项触发上下文操作模式
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            if (actionMode != null) {
                return false;
            }
            selectedPosition = position;
            // 启动上下文操作模式
            actionMode = startActionMode(actionModeCallback);
            view.setSelected(true); // 高亮选中项
            return true;
        });
    }

    // 上下文操作模式的回调
    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // 加载上下文菜单
            getMenuInflater().inflate(R.menu.context_menu, menu);
            mode.setTitle("1 selected"); // 显示选中数量
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // 无需准备操作
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            // 处理菜单点击（这里实现删除功能）
            if (item.getItemId() == R.id.action_delete) {
                if (selectedPosition != -1 && selectedPosition < dataList.size()) {
                    dataList.remove(selectedPosition); // 移除选中项
                    adapter.notifyDataSetChanged(); // 刷新列表
                }
                mode.finish(); // 关闭上下文操作模式
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // 清理资源
            actionMode = null;
            selectedPosition = -1;
            listView.clearChoices(); // 清除选中状态
            adapter.notifyDataSetChanged();
        }
    };
}

