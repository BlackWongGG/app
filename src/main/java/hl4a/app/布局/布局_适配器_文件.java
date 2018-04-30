package hl4a.app.布局;

import android.content.Context;
import 间.安卓.视图.图片视图;
import 间.安卓.视图.文本视图;
import 间.安卓.视图.线性布局;
import java.io.File;
import 间.安卓.工具.文件;
import android.text.TextUtils;

public class 布局_适配器_文件 extends 线性布局 {
    
    public File 文件;
    public 图片视图 图标;
    public 线性布局 内容;
    public 文本视图 名称;
    public 文本视图 修改时间和大小;
    
    public 布局_适配器_文件(Context $上下文) {
        super($上下文);
        置方向("水平");
        置填充("8dp");
        置高度("自动");
        图标 = new 图片视图(this);
        图标.置宽度("40dp");
        图标.置高度("40dp");
        内容 = new 线性布局(this);
        内容.置重力("中间垂直");
        名称 = new 文本视图(内容);
        名称.置文本颜色("黑色");
        名称.置文本大小("中文本");
        名称.置文本显示在同一行(true);
        名称.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        修改时间和大小 = new 文本视图(内容);
        修改时间和大小.置文本大小("小文本");
    }
    
}
