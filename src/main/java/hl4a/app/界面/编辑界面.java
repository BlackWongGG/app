package hl4a.app.界面;

import android.os.Bundle;
import hl4a.app.布局.布局_编辑界面;
import java.io.File;
import 间.安卓.内容.界面;
import 间.安卓.工具.提示;
import 间.安卓.资源.图标;
import 间.工具.字符;
import 间.接口.方法;
import 间.安卓.脚本.界面.脚本界面;
import 间.接口.单值方法;

public class 编辑界面 extends 界面 {

    private 布局_编辑界面 布局;
    private File 文件;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);

        置滑动返回(true);
        
        文件 = 取传入参数(0);

        if (文件 == null) {
            结束界面();
            return;
        }

        布局 = 打开布局(new 布局_编辑界面(this));

        取导航按钮().结束界面(this);

        置标题("编辑脚本");
        置副标题(文件.getName());

        布局.代码.置文本(字符.读取(文件.getPath()));

        取标题栏().新按钮(图标.启动, new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    保存();
                    脚本界面.跳转脚本(取界面(), null, 文件.getPath());
                    return null;
                }
            });


        取标题栏().新按钮(图标.撤销, new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    布局.代码.撤销();
                    return null;
                }
            });
            
        取标题栏().新按钮(图标.重做, new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    布局.代码.重做();
                    return null;
                }
            });
            
    }

    @Override
    public void 界面刷新事件() {
        super.界面刷新事件();
        if (!文件.isFile()) {
            结束界面();
            提示.警告("文件不存在 ~");
        } else {
            保存();
        }
    }

    @Override
    public void 界面销毁事件() {
        super.界面销毁事件();
        if (文件.isFile()) {
            保存();
        }
    }

    private void 保存() {
        字符.保存(文件.getPath(), 布局.代码.取文本());
    }

}
