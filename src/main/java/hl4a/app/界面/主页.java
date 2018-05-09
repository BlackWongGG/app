package hl4a.app.界面;

import android.os.Bundle;
import hl4a.app.工具.信息;
import hl4a.app.布局.布局_主页;
import 间.安卓.内容.界面;
import 间.安卓.工具.提示;
import 间.安卓.弹窗.弹窗;
import 间.安卓.视图.线性布局;
import 间.安卓.视图.输入框;
import 间.安卓.资源.图标;
import 间.工具.字符;
import 间.工具.文件;
import 间.工具.时间;
import 间.接口.方法;
import 间.接口.简单方法;

public class 主页 extends 界面 {

    private 布局_主页 布局;
    private 弹窗 新建;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);

        布局 = 打开布局(new 布局_主页(this));

        置标题("HL4A");
        置副标题("好消息 不行接受不了！");

        刷新脚本();

        新建 = new 弹窗(取界面());

        新建.置标题("新建脚本");

        线性布局 $底层 = new 线性布局(取界面());

        $底层.置左右填充("填充");

        final 输入框 $输入 = new 输入框($底层);

        $输入.置默认文本("文件名");

        新建.置内容($底层);

        新建.置中按钮("取消", null);

        新建.置右按钮("新建", new 方法() {
                @Override
                public Boolean 调用(Object[] $参数) {
                    String $地址 = 信息.脚本 + "/" + $输入.取文本() + ".js";
                    if (文件.是文件($地址)) {
                        提示.吐司.警告("该脚本已存在 ~");
                        return true;
                    } else {
                        提示.普通("创建成功 ~");
                        字符.保存($地址, "");
                        刷新脚本();
                        return false;
                    }
                }
            });

        取标题栏().新按钮(图标.添加, new 简单方法() {
                @Override
                public void 调用() {
                    $输入.置文本("");
                    新建.显示();
                }
            });

    }

    @Override
    public void 界面刷新事件() {
        super.界面刷新事件();
        刷新脚本();
    }

    void 刷新脚本() {

        if (!文件.是目录(信息.脚本)) {
            文件.创建目录(信息.脚本);
        }

        布局.本地.列表.加载从目录(信息.脚本);

    }

    private long 返回时间 = 时间.时间戳() - 23333;

    @Override
    public boolean 返回按下事件() {
        long 上次 = 返回时间;
        if ((返回时间 = 时间.时间戳()) - 上次 < 2333) {
            结束界面();
            return false;
        } else {
            提示.普通("再按一次返回键退出 ~");
            return true;
        }
    }

}
