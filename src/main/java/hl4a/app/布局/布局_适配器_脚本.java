package hl4a.app.布局;

import android.content.Context;
import 间.安卓.视图.图片按钮;
import 间.安卓.视图.扩展.线性按钮;
import 间.安卓.视图.文本视图;
import 间.安卓.视图.线性布局;
import 间.安卓.资源.图标;
import java.io.File;
import hl4a.app.适配器.文件适配器;
import 间.安卓.工具.文件;
import 间.安卓.工具.绘画;
import android.graphics.drawable.BitmapDrawable;
import hl4a.app.R;

public class 布局_适配器_脚本 extends 线性布局 {
    
    public 线性布局 显示;
    public 文本视图 名称;
    public 文本视图 信息;
    public 线性布局 其他;
    public 线性按钮 编辑;
    public 线性按钮 更多;
    
    public 布局_适配器_脚本(Context $上下文) {
        super($上下文);
        置背景("白色");
        置左填充("16dp");
        置高度("56dp");
        置方向("水平");
        显示 = new 线性布局(this);
        显示.置布局权重(1);
        显示.置重力("中间垂直");
        名称 = new 文本视图(显示);
        名称.置文本颜色("黑色");
        信息 = new 文本视图(显示);
        信息.置上边距("2dp");
        其他 = new 线性布局(this);
        其他.置方向("水平");
        其他.置宽度("自动");
        其他.置重力("中间");
        编辑 = new 线性按钮(其他);
        编辑.置图片(R.drawable.ic_edit_black_24dp);
        更多 = new 线性按钮(其他);
        更多.置图片(R.drawable.ic_more_vert_black_24dp);
    }

    public void 加载从文件(File $文件) {
        名称.置文本($文件.getName());
        信息.置文本(文件.格式大小($文件.length()));
    }
    
}
