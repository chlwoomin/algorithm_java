import java.util.HashMap;
class Solution {
        public int solution(String s) {
        String ans = "";
        HashMap<String, String> map = new HashMap<>();
        map.put("ze","zero");
        map.put("on","one");
        map.put("tw","two");
        map.put("th","three");
        map.put("fo","four");
        map.put("fi","five");
        map.put("si","six");
        map.put("se","seven");
        map.put("ei","eight");
        map.put("ni","nine");
        int answer = 0;
        for(int i =0; i<s.length(); i++){
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                ans += s.charAt(i);
                continue;
            }
            String substring = s.substring(i, i+2);
            switch (substring){
                case "ze": ans += "0"; i+=3; break;
                case "on": ans += "1"; i+=2; break;
                case "tw": ans += "2"; i+=2; break;
                case "th": ans += "3"; i+=4; break;
                case "fo": ans += "4"; i+=3; break;
                case "fi": ans += "5"; i+=3; break;
                case "si": ans += "6"; i+=2; break;
                case "se": ans += "7"; i+=4; break;
                case "ei": ans += "8"; i+=4; break;
                case "ni": ans += "9"; i+=3; break;
            }
        }
        answer = Integer.parseInt(ans);

        return answer;
    }
}