package hl4a.app.布局;

import hl4a.app.数据.用户;
import hl4a.app.视图.用户视图;
import 间.安卓.内容.界面;
import 间.安卓.视图.扩展.标签滑动;
import 间.安卓.视图.文本视图;
import 间.安卓.视图.线性布局;

public class 布局_主页 extends 线性布局 {

    public 标签滑动 滑动;
    public 线性布局 热点;
    public 我的 我的;
    
    public 布局_主页(界面 $上下文) {
        super($上下文.取界面());
        $上下文.取标题栏().置阴影(0);
        热点 = new 线性布局($上下文.取界面());
        我的 = new 我的();
       
        
        滑动 = new 标签滑动(this);
        滑动.添加("我的", 我的);
    }
    
    public class 我的 extends 线性布局 {
        
        public 用户视图 用户;
        public 线性布局 提示;
        public 文本视图 内容;
        
        public 我的() {
            super(布局_主页.this.getContext());
            用户 = new 用户视图(this);
            提示 = new 线性布局(this);
            提示.置重力("中间");
            内容 = new 文本视图(提示);
            内容.置文本("还没有登录 ~");
        }
        
        public void 重载(用户 $用户) {
            if ($用户 == null || $用户.isAnonymous()) {
                用户.隐藏();
                提示.显示();
            } else {
                用户.显示();
                提示.隐藏();
                用户.重载($用户);
            }
        }
        
    }

}
