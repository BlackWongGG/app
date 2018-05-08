package hl4a.app.布局;

import 间.安卓.内容.界面;
import 间.安卓.视图.代码框;
import 间.安卓.视图.滚动视图;
import 间.安卓.资源.布局.布局_标题界面;
import 间.安卓.视图.扩展.符号栏;

public class 布局_编辑界面 extends 布局_标题界面 {
    
    public 代码框 代码;
    public 滚动视图 滚动;
    public 符号栏 符号;
    
    public 布局_编辑界面(界面 $界面) {
        super($界面);
        代码 = new 代码框(this);
        代码.置布局权重(1);
        滚动 = new 滚动视图(this);
        滚动.置高度("自动");
        符号 = new 符号栏(滚动);
        符号.置代码框(代码);
    }
    
    
}
