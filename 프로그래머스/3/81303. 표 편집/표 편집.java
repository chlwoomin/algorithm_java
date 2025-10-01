import java.util.LinkedList;
import java.util.List;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        // n = 크기 k = select
        // cmd = ["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]
        // answer = "OOOOXOOO"
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < cmd.length; i++){
            String s = cmd[i];
            String[] split = s.split(" ");
            String command = split[0];
            if (command.equals("D")){
                k+= Integer.parseInt(split[1]);
            }
            else if (command.equals("U")){
                k-= Integer.parseInt(split[1]);
            }
            else if (command.equals("C")){
                list.add(k);
                n--;
                if (k == n) k--;
            }
            else if (command.equals("Z")){
                int a = list.remove(list.size()-1);
                if (a <= k) k++;
                n++;
            }
        }
        StringBuilder sb = new StringBuilder("O".repeat(n));
        while (!list.isEmpty()){
            int i;
            i = list.remove(list.size()-1);
            sb.insert(i,'X');
        }

        return sb.toString();
    }
}