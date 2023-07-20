package basetreeview.ahao.com.basetreeviewpro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahao.basetreeview.model.TreeNode;
import com.ahao.basetreeview.util.TreeDataUtils;

import java.util.ArrayList;
import java.util.List;

public class MultiLayoutTreeActivity  extends Activity {

    RecyclerView recyclerView;

    MyMultiLayoutTreeAdapter adapter;

    private final List<TreeNode<File>> allData = new ArrayList<>();

    private final List<TreeNode<File>> dataToBind = new ArrayList<>();
    @Override
    protected void onCreate(  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_multi_layout_tree);
        initUI();
        initData();
        initEvent();
    }

    private void initEvent() {
        recyclerView.setAdapter(adapter);

        adapter.setOnTreeClickedListener(new MyMultiLayoutTreeAdapter.OnTreeClickedListener<File>() {
            @Override
            public void onNodeClicked(View view, TreeNode<File> node, int position) {
                ImageView icon = view.findViewById(R.id.level_icon);
                if(node.isExpand()){
                    icon.setImageResource(R.drawable.tree_icon_collapse);
                }else{
                    icon.setImageResource(R.drawable.tree_icon_expand);
                }

            }

            @Override
            public void onLeafClicked(View view, TreeNode<File> node, int position) {

            }
        });
    }

    private void initData() {
        dataToBind.clear();
        dataToBind.addAll(TreeDataUtils.convertDataToTreeNode(DataSource.getFiles(),1));
        adapter = new MyMultiLayoutTreeAdapter(dataToBind);
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
