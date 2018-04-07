package hl4a.app.布局;

import 间.安卓.内容.界面;
import 间.安卓.视图.圆形图;
import 间.安卓.视图.扩展.高级滑动;
import 间.安卓.视图.文本视图;
import 间.安卓.视图.线性布局;
import 间.安卓.资源.布局.布局_基本界面;
import 间.安卓.视图.扩展.设置组;
import android.preference.PreferenceActivity;
import 间.安卓.视图.扩展.设置视图;

public class 布局_用户信息 extends 布局_基本界面 {
    
    public 高级滑动 滑动;
    public 线性布局 用户底层;
    public 圆形图 头像;
    public 线性布局 用户内容;
    public 文本视图 用户名;
    public 文本视图 签名;
    
    public 设置组 设置;
    public 设置视图 用户账号;
    
    public 布局_用户信息(界面 $上下文) {
        super($上下文);
        $上下文.置标题("个人资料");
        用户底层 = new 线性布局(this);
        用户底层.置背景颜色("白色");
        用户底层.置填充("16dp");
        用户底层.置高度("自动");
        用户底层.置阴影("4dp");
        用户底层.置重力("中间垂直");
        用户底层.置方向("左右");

        头像 = new 圆形图(用户底层);
        头像.置宽度("56dp");
        头像.置高度("56dp");
        
        用户内容 = new 线性布局(用户底层);
        用户内容.置重力("中间垂直");
        用户内容.置左边距("16dp");
        用户名 = new 文本视图(用户内容);
        用户名.置文本颜色("黑色");

        签名 = new 文本视图(用户内容);
        签名.置上边距("4dp");
        
        设置 = new 设置组(this);
        用户账号 = 设置.新建设置("用户账号");
    }
    
}
