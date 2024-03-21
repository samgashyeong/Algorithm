import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
class XY{
    public int x;
    public int y;

    public XY(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static boolean[][] arr = new boolean[15][15];

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        

        ArrayList<XY> xyArr = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            xyArr.add(new XY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(xyArr, new Comparator<XY>() {
			
			@Override
			public int compare(XY o1, XY o2) {

                if(o1.y == o2.y){
                    return o1.x-o2.x;
                }
				else{
                    return o1.y-o2.y;
                }
			}
		});
        

        for(int i=0;i<n;i++){
            System.out.println(xyArr.get(i).x + " " + xyArr.get(i).y);
        }

	}
}