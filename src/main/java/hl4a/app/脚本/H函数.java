package hl4a.app.脚本;

import java.io.Serializable;
import org.mozilla.javascript.Function;
import 间.安卓.脚本.JavaScript;
import 间.接口.函数;

public class H函数 implements 函数,Serializable {

    private JavaScript 环境;
    private Function 函数;

    public H函数(JavaScript $环境, Function $函数) {
        环境 = $环境;
        函数 = $函数;
    }

    @Override
    public Object 调用(Object[] $参数) {
        return 环境.调用函数(函数,$参数);
    }

}
