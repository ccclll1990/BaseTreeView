package basetreeview.ahao.com.basetreeviewpro;


import com.ahao.basetreeview.adapter.SingleLayoutTreeAdapter;
import com.ahao.basetreeview.model.TreeNode;
import com.ahao.basetreeview.util.DpUtil;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MySingleLayoutTreeAdapter extends SingleLayoutTreeAdapter<File> {

    public MySingleLayoutTreeAdapter(int layoutResId, List<TreeNode<File>> dataToBind) {
        super(layoutResId, dataToBind);
    }

    @Override
    protected void convert(BaseViewHolder helper, TreeNode<File> item) {
        super.convert(helper, item);
        helper.setText(R.id.textView, item.getId() + ":" + item.getData().getName() + " level=" + item.getLevel());
        if (item.isLeaf()) {
            helper.setImageResource(R.id.level_icon, R.drawable.video);
        } else {
            if (item.isExpand()) {
                helper.setImageResource(R.id.level_icon, R.drawable.tree_icon_collapse);
            } else {
                helper.setImageResource(R.id.level_icon, R.drawable.tree_icon_expand);
            }
        }

    }

    @Override
    protected int getTreeNodeMargin() {
        return DpUtil.dip2px(this.mContext, 30);
    }
}
