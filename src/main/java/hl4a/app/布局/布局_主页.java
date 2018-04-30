package hl4a.app.布局;

import 间.安卓.内容.界面;
import 间.安卓.工具.字体;
import 间.安卓.工具.颜色;
import 间.安卓.视图.图片视图;
import 间.安卓.视图.圆形图;
import 间.安卓.视图.扩展.标签滑动;
import 间.安卓.视图.按钮;
import 间.安卓.视图.文本视图;
import 间.安卓.视图.线性布局;

public class 布局_主页 extends 线性布局 {

    public 标签滑动 滑动;
    public 线性布局 新闻;

    public 布局_主页(界面 $上下文) {
        super($上下文.取界面());
        $上下文.取标题栏().置阴影(0);
        新闻 = new 线性布局($上下文.取界面());
        
        
        滑动 = new 标签滑动(this);
        滑动.添加("新闻", 新闻);
    }

}
