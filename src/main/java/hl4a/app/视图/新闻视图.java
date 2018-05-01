package hl4a.app.视图;

import android.content.Context;
import 间.安卓.视图.列表视图;
import 间.安卓.视图.文本视图;
import 间.安卓.视图.线性布局;
import 间.接口.方法;

public class 新闻视图 extends 线性布局 {
    
    public 列表视图 列表;
    public 文本视图 提示;
    
    public 新闻视图(Context $上下文) {
        super($上下文);
        列表 = new 列表视图(this);
        提示 = new 文本视图(this);
        提示.隐藏();
    }
    
    public void 加载() {
        
    }
    
}
