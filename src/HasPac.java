import java.io.File;
import java.util.ArrayList;

/**
 * Created by xianyu.hxy on 2015/7/13.
 */
public class HasPac {
    public static final String FILE_BASE="D:"+ File.separator+"temp";
    public static final String PAC_NAME="com"+File.separator+"alipay"+File.separator+"android"+File.separator+"app"+File.separator+"pay";
    public static final String PAC_NAME1="com"+File.separator+"alipay";
    public static ArrayList<String> appList;
    public static ArrayList<String> pacPath;
    public static boolean isContain=false;
    public static void main(String[] args){
        pacPath=new ArrayList<String>();
        appList=new ArrayList<String>();

        File baseFile=new File(FILE_BASE);
        if(baseFile.exists()&&baseFile.isDirectory()){
            File[] aFiles=baseFile.listFiles();
            //aFile a,b,c...
            for(File aFile:aFiles){
                File[] unjarFiles=aFile.listFiles();
                //unjarFile 支付宝,滴滴打车...
                for(File unjarFile:unjarFiles){
                    //if(isContain)break;
                    if(unjarFile.exists()&&unjarFile.isDirectory()){
                        //进入各个app解压文件夹根目
                        String path=unjarFile.getAbsolutePath();
                        getFileList(path);
                        for(String s:pacPath){
                            boolean b=s.contains(PAC_NAME);
                            if(b) {
                                //System.out.println(pacPath);
                                isContain=true;
                                if(!appList.contains(s)) {
                                    appList.add(s);
                                }
                               // break;
                            }
                        }
                    }


                }
            }
        }
        for(String list:appList){
            System.out.println("************"+list);
        }

    }
    public static void getFileList(String directory) {
        File f = new File(directory);
        File[] files = f.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
              //  System.out.println("文件：" + files[i]);
            } else {
                //System.out.println("目录：" + files[i].getAbsolutePath());
                pacPath.add(files[i].getAbsolutePath());
                getFileList(files[i].getAbsolutePath());
            }
        }
    }

}
