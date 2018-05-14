package hl4a.app.布局;

import 间.安卓.内容.界面;
import 间.安卓.视图.代码框;
import 间.安卓.视图.扩展.标题栏;
import 间.安卓.视图.扩展.符号栏;
import 间.安卓.视图.滚动视图;
import 间.安卓.资源.布局.布局_标题界面;
import 间.接口.单值方法;
import 间.安卓.资源.图标;
import 间.接口.简单方法;

public class 布局_编辑界面 extends 布局_标题界面 {

    public 标题栏 操作;
    public 代码框 代码;
    public 滚动视图 滚动;
    public 符号栏 符号;

    public 布局_编辑界面(界面 $界面) {
        super($界面);
        操作 = new 标题栏(this);
        操作.置标题("选中文本");
        操作.隐藏();
        代码 = new 代码框(this);
        代码.置布局权重(1);

        操作.新按钮(图标.全选, new 简单方法() {
                @Override
                public void 调用() {
                    代码.全选();
                }
            });

        操作.新按钮(图标.复制, new 简单方法() {
                @Override
                public void 调用() {
                    代码.复制();
                }
            });
            
        操作.新按钮(图标.剪切, new 简单方法() {
                @Override
                public void 调用() {
                    代码.剪切();
                }
            });
            
        操作.新按钮(图标.粘贴, new 简单方法() {
                @Override
                public void 调用() {
                    代码.粘贴();
                }
            });
            
        代码.置代码选中事件(new 单值方法<Boolean>() {
                @Override
                public void 调用(Boolean $参数) {
                    if ($参数) {
                        取标题栏().隐藏();
                        操作.显示();
                    } else {
                        取标题栏().显示();
                        操作.隐藏();
                    }
                }
            });

        滚动 = new 滚动视图(this);
        滚动.置高度("自动");
        符号 = new 符号栏(滚动);
        符号.置代码框(代码);
    }


}
