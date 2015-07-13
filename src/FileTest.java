import tool.ZipUtil;

import java.io.File;

/**
 * Created by xianyu.hxy on 2015/7/13.
 */
public class FileTest {
    public static final String path="D:"+ File.separator+"AA.jar";
    public static void main(String[] args){
        ZipUtil.unzip(path,"D:"+File.separator+"XXXXXXX");
    }
}
