package hl4a.app.布局;

import hl4a.app.视图.脚本列表视图;
import 间.安卓.内容.界面;
import 间.安卓.组件.基本界面;
import 间.安卓.视图.扩展.标签滑动;
import 间.安卓.视图.线性布局;
import 间.安卓.资源.布局.布局_标题界面;

public class 布局_主页 extends 布局_标题界面 {

    public 标签滑动 滑动;
    public 本地 本地;
    
    public 布局_主页(界面 $上下文) {
        super($上下文);
        取标题栏().置阴影(0);
        滑动 = new 标签滑动(this);
        滑动.添加("本地",本地 = new 本地($上下文.取界面()));
    }
    
    public class 本地 extends 线性布局 {
        
        public 脚本列表视图 列表;
        
        public 本地(基本界面 $界面) {
            super($界面);
            列表 = new 脚本列表视图($界面,this);
        }
        
    }

}
