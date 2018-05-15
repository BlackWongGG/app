package hl4a.app.适配器;

import hl4a.app.布局.布局_适配器_脚本;
import hl4a.app.界面.编辑界面;
import java.io.File;
import 间.安卓.工具.处理;
import 间.安卓.工具.提示;
import 间.安卓.工具.文件;
import 间.安卓.工具.线程;
import 间.安卓.弹窗.进度弹窗;
import 间.安卓.组件.基本界面;
import 间.安卓.脚本.界面.脚本界面;
import 间.安卓.视图.弹出菜单;
import 间.安卓.视图.适配器.基本适配器;
import 间.接口.方法;
import 间.接口.简单方法;
import 间.收集.I对象哈希表;
import 间.收集.对象哈希表;

public class 脚本适配器 extends 基本适配器<布局_适配器_脚本> {

    private 基本界面 界面;
    private String 目录;

    public 脚本适配器(基本界面 $上下文) {
        super($上下文);
        界面 = $上下文;
    }

    @Override
    public 布局_适配器_脚本 创建() {
        return new 布局_适配器_脚本(取上下文());
    }

    public void 加载从目录(String $目录) {

        目录 = $目录;

        清空();

        File[] $文件 = 文件.取文件列表($目录);

        for (File $单个 : $文件) {

            if (!($单个.isFile() && $单个.getName().endsWith(".js"))) continue;

            对象哈希表 $参数 = new 对象哈希表();

            $参数.设置("文件", $单个);

            添加($参数);

        }

        发送更新事件();

    }

    @Override
    public 布局_适配器_脚本 处理(布局_适配器_脚本 $视图, I对象哈希表 $参数) {

        final File $文件 = $参数.读取("文件");

        $视图.加载从文件($文件);

        $视图.编辑.置单击事件(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    界面.跳转界面(编辑界面.class, $文件);
                    return null;
                }
            });

        final 弹出菜单 $菜单 = new 弹出菜单($视图.更多);

        $菜单.添加("删除", new 简单方法() {
                @Override
                public void 调用() {
                    文件.删除($文件.getPath());
                    提示.普通("已删除");
                    加载从目录(目录);
                }
            });


        $菜单.添加("分享", new 简单方法() {
                @Override
                public void 调用() {
                    boolean $成功 = 文件.打开($文件.getPath(), "text/plain");
                    if (!$成功) {
                        提示.普通("分享失败 ~");
                    }
                }
            });


        $视图.更多.置单击事件(new 简单方法() {
                @Override
                public void 调用() {
                    $菜单.显示();
                }
            });

        $视图.置单击事件(new 简单方法(处理.异步) {
                @Override
                public void 调用() {
                    脚本界面.跳转脚本(界面,null,$文件.getPath());
                }
            }.构建());

        return $视图;
    }

}
