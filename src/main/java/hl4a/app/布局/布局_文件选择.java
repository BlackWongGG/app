package hl4a.app.布局;

import 间.安卓.组件.基本界面;
import 间.安卓.视图.列表视图;
import 间.安卓.资源.布局.布局_标题界面;

public class 布局_文件选择 extends 布局_标题界面 {

    public 列表视图 列表;

    public 布局_文件选择(基本界面 $界面) {
        super($界面);
        列表 = new 列表视图(this);
    }

}
