package hl4a.app.适配器;

import hl4a.app.布局.布局_适配器_脚本;
import hl4a.app.界面.编辑界面;
import java.io.File;
import 间.安卓.组件.基本界面;
import 间.安卓.脚本.界面.脚本界面;
import 间.安卓.视图.适配器.基本适配器;
import 间.工具.文件;
import 间.接口.方法;
import 间.收集.对象哈希表;

public class 脚本适配器 extends 基本适配器<布局_适配器_脚本> {

    private 基本界面 界面;
    
    public 脚本适配器(基本界面 $上下文) {
        super($上下文);
        界面 = $上下文;
    }
    
    @Override
    public 布局_适配器_脚本 创建() {
        return new 布局_适配器_脚本(取上下文());
    }

    public void 加载从目录(String $目录) {
        
        清空();
        
        File[] $文件 = 文件.取文件列表($目录);
        
        for (File $单个 : $文件) {
            
            if (!($单个.isFile() && $单个.getName().endsWith(".js"))) continue;
            
            对象哈希表 $参数 = new 对象哈希表();
            
            $参数.设置("文件",$单个);
            
            添加($参数);
            
        }
        
        发送更新事件();
        
    }
    
    @Override
    public 布局_适配器_脚本 处理(布局_适配器_脚本 $视图, 对象哈希表 $参数) {
        
        final File $文件 = $参数.读取("文件");
        
        $视图.加载从文件($文件);
        
        $视图.编辑.置单击事件(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    界面.跳转界面(编辑界面.class,$文件);
                    return null;
                }
            });
        
        $视图.置单击事件(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    脚本界面.跳转脚本(界面,null,$文件.getPath());
                    return null;
                }
            });
        
        return $视图;
    }
    
}
