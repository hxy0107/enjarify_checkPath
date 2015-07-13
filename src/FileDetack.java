

import tool.ZipUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

/**
 * Created by xianyu.hxy on 2015/7/13.
 */
public class FileDetack {
    public static final String FILE_BASE="D:"+ File.separator+"temp";

    public static void main(String[] args){

        File file=new File(FILE_BASE);
        if (file.exists()&&file.isDirectory()){
            File[] files=file.listFiles();
            for(File f:files){
                if(f.exists()&&f.isDirectory()){
                    File[] jarFiles=f.listFiles();
                    for(File jarFile:jarFiles ){
                        String fileName=jarFile.getName();
                        String type=fileName.substring(fileName.lastIndexOf(".")+1);
                        if(jarFile.exists()&&jarFile.isFile()&&type.equals("jar")){
                            String filePath=jarFile.getAbsolutePath();
                            String folerName=filePath.substring(0, filePath.lastIndexOf("."));
                            System.out.println("filePath:" + folerName);
                            long start=System.currentTimeMillis();
                            ZipUtil.unzip(filePath,folerName);
                            long end=System.currentTimeMillis();
                            System.out.println("untar time:"+(end-start)/1000+" s");
                        }
                    }
                }
            }
        }
    }
}
