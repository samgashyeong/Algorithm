import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> chk = new ArrayList<>();
        for(int i=0;i<6;i++){
            String input = br.readLine();
            arr.add(input);
            chk.add(input);
        }

        String a,b,c;

        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                for(int z=0;z<6;z++){

                    a = arr.get(i);
                    b = arr.get(j);
                    c = arr.get(z);


                    chk.remove(a);
                    chk.remove(b);
                    chk.remove(c);


                    String chkS = a.charAt(0) + "" + b.charAt(0)+ c.charAt(0);

                    chk.remove(chkS);

                    chkS = a.charAt(1) + "" + b.charAt(1)+ c.charAt(1);

                    chk.remove(chkS);
                    chkS = a.charAt(2) + "" + b.charAt(2)+ c.charAt(2);
                    chk.remove(chkS);

                    if(chk.isEmpty()){
                        System.out.println(a);
                        System.out.println(b);
                        System.out.println(c);
                        return;
                    }

                    chk.clear();

                    for(int e=0;e<6;e++){
                        chk.add(arr.get(e));
                    }
                }
            }
        }

        System.out.println(0);
    }
}
