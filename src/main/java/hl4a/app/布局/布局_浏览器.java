package hl4a.app.布局;

import 间.安卓.组件.基本界面;
import 间.安卓.视图.浏览器;
import 间.安卓.资源.布局.布局_标题界面;

public class 布局_浏览器 extends 布局_标题界面 {
    
    public 浏览器 浏览器;
    
    public 布局_浏览器(基本界面 $界面) {
        super($界面);
        浏览器 = new 浏览器(this);
    }
    
}
