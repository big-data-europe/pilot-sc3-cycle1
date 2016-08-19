package sparkbin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.spark.api.java.function.Function;

/**
 *
 * @author John Vlachos
 */
public class BinaryPipe implements Function<byte[], String> {

    String command = "./run_stream.exe";
    String dir = "/root/";
    String temp_file;

    @Override
    public String call(byte[] t1) throws Exception {
        String tstamp = new SimpleDateFormat("HHmmssSSS").format(new Date());
        temp_file = dir + tstamp + ".bin";
        File file = new File(temp_file);
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.write(t1);
        dos.flush();
        dos.close();
        String sb = "";

        ProcessBuilder builder = new ProcessBuilder(command);
        builder.directory(new File(dir));
        builder.redirectInput(new File(temp_file));
        //builder.redirectOutput(new File("/root/out.txt"));
        //builder.redirectError(new File("/root/err.txt"));
        Process pr = builder.start();
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        pr.waitFor();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb += line + "\n";
        }
        file.delete();
        return sb;

    }
}
