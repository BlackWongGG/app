package hl4a.app.适配器;

import android.content.Context;
import 间.安卓.视图.适配器.基本适配器;
import 间.安卓.资源.布局.布局_适配器_数组;
import 间.收集.I对象哈希表;
import 间.收集.对象哈希表;
import 间.接口.简单方法;
import 间.安卓.工具.链接;

public class 手册适配器 extends 基本适配器<布局_适配器_数组> {

    public 手册适配器(Context $上下文) {
        super($上下文);
    }

    @Override
    public 布局_适配器_数组 创建() {
        return new 布局_适配器_数组(取上下文());
    }

    public void 添加(String $名称, String $地址) {
        I对象哈希表 $参数 = new 对象哈希表();
        $参数.设置("名称", $名称);
        $参数.设置("地址", $地址);
        添加($参数);
    }

    @Override
    public 布局_适配器_数组 处理(布局_适配器_数组 $视图, final I对象哈希表 $参数) {
        $视图.文本.置文本((String)$参数.读取("名称"));
        $视图.置单击事件(new 简单方法() {
                @Override
                public void 调用() {
                    链接.打开("https://hl4a.github.io/app/doc/" + (String)$参数.读取("地址") + ".html",(String)$参数.读取("名称"));
                }
            });
        return $视图;
    }

}
