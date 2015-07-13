/**
 * Created by xianyu.hxy on 2015/7/13.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;



public class RunCmdUtil {

    public static void main(String[] args) {
        String[] cmd = new String[] { "cmd.exe", "/C", "wmic process get name" };
        String[] cmd1=new String[]{"powershell","/c" ,"start calc"};
        String[] cmd2=new String[]{"powershell","/c","cd D:\\tools\\enjarify-master","ls"};
        try {
            Process process = Runtime.getRuntime().exec(cmd2);
            new Thread(new RunCmd(process.getInputStream())).start();
            new Thread(new RunCmd(process.getErrorStream())).start();
            process.getOutputStream().close();

            int exitValue = process.waitFor();
            System.out.println("return_val:" + exitValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class RunCmd implements Runnable {
        private InputStream ins;
        public RunCmd(InputStream ins) {
            this.ins = ins;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(ins));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}