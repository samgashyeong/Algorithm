import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static ArrayList<Integer> list = new ArrayList<>();

    static void f(int start, int end){ // 재귀 함수의 인자를 시작과 끝 인덱스만 받도록 수정
        if(start > end) return; // 시작 인덱스가 끝 인덱스보다 크면 종료

        int root = list.get(start); // 현재 서브트리의 루트

        int rightSubtreeStart = start + 1; // 오른쪽 서브트리의 시작 인덱스

        while(rightSubtreeStart <= end && list.get(rightSubtreeStart) < root) {
            rightSubtreeStart++; // 오른쪽 서브트리의 시작을 찾음
        }

        f(start + 1, rightSubtreeStart - 1); // 왼쪽 서브트리 재귀 호출
        f(rightSubtreeStart, end); // 오른쪽 서브트리 재귀 호출

        System.out.println(root); // 후위 순회이므로 루트는 가장 마지막에 출력
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while (true){
            s = br.readLine();
            if(s == null || s.equals("")) break;
            list.add(Integer.parseInt(s));
        }

        f(0, list.size() - 1);
    }
}