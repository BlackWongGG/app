package hl4a.app.视图;

import android.content.Context;
import android.view.ViewGroup;
import hl4a.app.数据.用户;
import 间.安卓.视图.圆形图;
import 间.安卓.视图.文本视图;
import 间.安卓.视图.线性布局;

public class 用户视图 extends 线性布局 {

    public 线性布局 用户底层;
    public 圆形图 头像;
    public 线性布局 用户内容;
    public 文本视图 用户名;
    public 文本视图 签名;

    public 用户视图(Context $上下文) {
        super($上下文);
        用户底层 = new 线性布局(this);
        用户底层.置背景颜色("白色");
        用户底层.置填充("16dp");
        用户底层.置高度("自动");
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
    }

    public 用户视图(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }

    public void 重载(用户 $用户) {
        if ($用户 == null || $用户.isAnonymous()) return;
        用户名.置文本($用户.取用户名());
        签名.置文本($用户.取签名());
        $用户.显示头像(头像);
    }



}
