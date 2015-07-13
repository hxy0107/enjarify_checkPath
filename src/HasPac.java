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
                //unjarFile ֧����,�εδ�...
                for(File unjarFile:unjarFiles){
                    //if(isContain)break;
                    if(unjarFile.exists()&&unjarFile.isDirectory()){
                        //�������app��ѹ�ļ��и�Ŀ
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
              //  System.out.println("�ļ���" + files[i]);
            } else {
                //System.out.println("Ŀ¼��" + files[i].getAbsolutePath());
                pacPath.add(files[i].getAbsolutePath());
                getFileList(files[i].getAbsolutePath());
            }
        }
    }

}
