package RegEx;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalNumberRequests {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {

        // input file name
        String filename;
        filename = scan.nextLine();

        // read file
        File input = null;
        BufferedReader br = null;

        Map<String, Integer> map = new HashMap<>();

        try {
            input = new File(filename);
             br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/" + input));

            final String regEx = "([A-Za-z0-9]+\\.[A-Za-z0-9]+\\.((com)|(net)))";

            /*
            *  Find values matching pattern
            *  and map them
            * */
            Pattern p = Pattern.compile(regEx);
            String st;
            while ((st = br.readLine()) != null) {
                Matcher m = p.matcher(st);
                while (m.find()) {
                    if (map.get(m.group(1)) != null) {
                        int count = map.get(m.group(1));
                        map.put(m.group(), ++count);
                    } else {
                        map.put(m.group(), 1);
                    }
                }
            }

        } finally {
            if(br != null)
                br.close();
        }

        // write to file
        File output = null;
        BufferedWriter bw = null;

        try {
            output = new File(System.getProperty("user.dir") + "/output");
            bw = new BufferedWriter(new FileWriter(output));

            for (Map.Entry entry : map.entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
            bw.flush();

        } finally {
            if (bw != null)
                bw.close();
        }

    }

}
