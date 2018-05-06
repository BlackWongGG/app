package hl4a.app.适配器;

import hl4a.app.布局.布局_适配器_脚本;
import java.io.File;
import 间.安卓.视图.适配器.基本适配器;
import 间.工具.文件;
import 间.收集.对象哈希表;
import android.content.Context;

public class 脚本适配器 extends 基本适配器<布局_适配器_脚本> {

    public 脚本适配器(Context $上下文) {
        super($上下文);
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
        
        File $文件 = $参数.读取("文件");
        
        $视图.加载从文件($文件);
        
        return $视图;
    }
    
}
