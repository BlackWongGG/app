package hl4a.app.布局;

import 间.安卓.内容.界面;
import 间.安卓.工具.颜色;
import 间.安卓.视图.扩展.标签滑动;
import 间.安卓.视图.文本视图;
import 间.安卓.视图.线性布局;

public class 布局_主页 extends 线性布局 {

    public 标签滑动 滑动;
    public 本地 本地;
    
    public 布局_主页(界面 $上下文) {
        super($上下文.取界面());
        $上下文.取标题栏().置阴影(0);
        滑动 = new 标签滑动(this);
        滑动.添加("本地",本地 = new 本地());
    }
    
    public class 本地 extends 线性布局 {
        
        public 本地() {
            super(布局_主页.this.getContext());
        }
        
    }

}
