package hl4a.app;

import android.net.Uri;
import android.os.Bundle;
import hl4a.app.工具.信息;
import hl4a.app.界面.编辑界面;
import 间.安卓.工具.提示;
import 间.安卓.工具.文件;
import 间.安卓.组件.基本界面;
import 间.安卓.脚本.界面.脚本界面;
import 间.安卓.视图.按钮;
import 间.安卓.视图.文本视图;
import 间.安卓.资源.布局.布局_标题界面;
import 间.工具.字符;
import 间.接口.简单方法;
import java.nio.file.Files;
import java.nio.file.PathMatcher;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RunScript extends 基本界面 {

    private 布局_执行脚本 布局;
    private String 脚本;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        Uri $地址 = getIntent().getData();
        if ($地址 == null) {
            结束界面();
            return;
        }
        脚本 = 文件.取Uri路径($地址);
        if (!文件.是文件(脚本)) {
            结束界面();
            return;
        }
        布局 = 打开布局(new 布局_执行脚本());
        置标题(字符.格式化("打开 $1", 文件.取名称(脚本)));
        取导航按钮().结束界面(this);
    }

    public class 布局_执行脚本 extends 布局_标题界面 {

        public 文本视图 文本;
        public 按钮 执行;
        public 按钮 编辑;
        public 按钮 导入;

        public 布局_执行脚本() {
            super(RunScript.this);
            置填充("填充");

            文本 = new 文本视图(this);
            文本.置文本("恶意脚本可能侵犯您的隐私、窃取(/删除)您的数据，\n以及损坏您的设备。 \n脚本的权限很大、您应该只执行来源可信的脚本。\n\nHL4A建议您执行他人的脚本前先查看以确保安全性。");
            文本.置文本颜色("红色#控件");

            执行 = new 按钮(this);
            执行.置背景颜色("红色#控件");
            执行.置上边距("8dp");
            执行.置宽度("最大");
            执行.置文本("执行脚本");
            执行.置单击事件(new 简单方法() {
                    @Override
                    public void 调用() {
                        脚本界面.跳转脚本(RunScript.this, null, 脚本);
                    }
                });

            编辑 = new 按钮(this);
            编辑.置宽度("最大");
            编辑.置文本("编辑脚本");
            编辑.置单击事件(new 简单方法() {
                    @Override
                    public void 调用() {
                        跳转界面(编辑界面.class, 文件.取文件对象(脚本));
                    }
                });

            final String $输出 = 信息.脚本 + "/" + 文件.取名称(脚本);
              
            if (文件.比较(脚本,$输出)) {
                
                return;
                
            }
            
            导入 = new 按钮(this);
            导入.置宽度("最大");
            导入.置文本("导入到HL4A");
            导入.置单击事件(new 简单方法() {
                    @Override
                    public void 调用() {
                        
                        if (文件.是文件($输出)) {
                            提示.警告按钮("覆盖", new 简单方法() {
                                    @Override
                                    public void 调用() {
                                        文件.复制(脚本,$输出);
                                        提示.普通("覆盖成功 ~");
                                    }
                                }, "已有同名脚本 ~");
                        } else {
                            文件.复制(脚本,$输出);
                            提示.普通("导入成功 ~");
                        }
                    }
                });

        }

    }

}
