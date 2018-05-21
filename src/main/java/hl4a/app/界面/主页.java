package hl4a.app.界面;

import android.os.Bundle;
import android.view.ViewGroup;
import hl4a.app.R;
import hl4a.app.工具.信息;
import hl4a.app.布局.布局_新建脚本;
import java.io.File;
import 间.安卓.内容.界面;
import 间.安卓.工具.处理;
import 间.安卓.工具.提示;
import 间.安卓.工具.文件;
import 间.安卓.弹窗.弹窗;
import 间.安卓.组件.基本界面;
import 间.安卓.脚本.界面.脚本界面;
import 间.安卓.视图.列表视图;
import 间.安卓.视图.弹出菜单;
import 间.安卓.视图.扩展.标签滑动;
import 间.安卓.视图.扩展.线性按钮;
import 间.安卓.视图.扩展.设置组;
import 间.安卓.视图.扩展.设置视图;
import 间.安卓.视图.文本视图;
import 间.安卓.视图.线性布局;
import 间.安卓.视图.适配器.基本适配器;
import 间.安卓.资源.图标;
import 间.安卓.资源.布局.布局_标题界面;
import 间.工具.字符;
import 间.工具.时间;
import 间.接口.单值方法;
import 间.接口.方法;
import 间.接口.简单方法;
import 间.收集.I对象哈希表;
import 间.收集.对象哈希表;

public class 主页 extends 界面 {

    private 布局_主页 布局;
    private 布局_新建脚本 布局_新建;
    private 弹窗 新建;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);

        置滑动返回(false);

        布局 = 打开布局(new 布局_主页());
        置标题("HL4A");
        置副标题("好消息 不行接受不了！");

        刷新脚本();

        /*
        
       final 手册适配器 $手册 = new 手册适配器(取界面());

        处理.异步(new 简单方法() {
                @Override
                public void 调用() {
                    $手册.同步加载();
                }
            });

            */
            
        新建 = new 弹窗(取界面());
        新建.置标题("新建脚本");
        新建.置内容(布局_新建 = new 布局_新建脚本(取界面()));
        布局_新建.输入.置文本改变事件(new 单值方法<String>() {
                @Override
                public void 调用(String $参数) {
                    String $地址 = 信息.脚本 + "/" + $参数 + ".js";
                    if (文件.是文件($地址)) {
                        布局_新建.输入.setError("该脚本已存在 ~");
                    } else {
                        布局_新建.输入.setErrorEnabled(false);
                    }
                }
            });
        新建.置中按钮("取消", null);
        新建.置右按钮("新建", new 方法() {
                @Override
                public Boolean 调用(Object[] $参数) {
                    String $地址 = 信息.脚本 + "/" + 布局_新建.输入.取文本() + ".js";
                    if (布局_新建.输入.取文本().toString().isEmpty()) {
                        提示.吐司.警告("不要留空 ~");
                        return true;
                    }  else if (文件.是文件($地址)) {
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
                    布局_新建.输入.置文本("");
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

    public class 布局_主页 extends 布局_标题界面 {

        public 标签滑动 滑动;
        public 本地 本地;
        public 其他 其他;

        public 布局_主页() {
            super(取界面());
            取标题栏().置阴影(0);
            滑动 = new 标签滑动(this);
            滑动.添加("本地", 本地 = new 本地());
            滑动.添加("其他", 其他 = new 其他());
        }

        public class 本地 extends 线性布局 {

            public 脚本列表视图 列表;

            public 本地() {
                super(取界面());
                列表 = new 脚本列表视图(this);
            }

        }

        public class 其他 extends 线性布局 {

            public 设置组 设置;
            public 设置视图 帮助;
            
            public 其他() {
                super(取界面());
                设置 = new 设置组(this);
                帮助 = 设置.新建设置("帮助");
                帮助.普通设置("查看手册", "不定时更新 ~", new 简单方法() {
                        @Override
                        public void 调用() {
                            跳转界面(手册界面.class);
                        }
                    });
            }

        }

    }
    
    public class 脚本列表视图 extends 列表视图 {

        private 脚本适配器 适配器;

        public 脚本列表视图(基本界面 $上下文) {
            super($上下文);
            适配器 = new 脚本适配器();
            置适配器(适配器);
        }

        public 脚本列表视图(ViewGroup $父视图) {
            this(取界面());
            加入到($父视图);
        }

        public void 加载从目录(String $目录) {
            适配器.加载从目录($目录);
        }

    }

    public class 脚本适配器 extends 基本适配器<布局_适配器_脚本> {

        private String 目录;

        public 脚本适配器() {
            super(取界面());
        }

        @Override
        public 布局_适配器_脚本 创建() {
            return new 布局_适配器_脚本();
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
                        取界面().跳转界面(编辑界面.class, $文件);
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
                              脚本界面.跳转脚本(取界面(),null,$文件.getPath());
                          }
                      }.构建());

            return $视图;
        }

    }

    public class 布局_适配器_脚本 extends 线性布局 {

        public 线性布局 显示;
        public 文本视图 名称;
        public 文本视图 信息;
        public 线性布局 其他;
        public 线性按钮 编辑;
        public 线性按钮 更多;

        public 布局_适配器_脚本() {
            super(取界面());
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
    

}
