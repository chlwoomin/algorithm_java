import java.util.LinkedList;
import java.util.Queue;

class Solution {
public int[] solution(String[][] places) {
        int[] answer = {};
        answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = seek(places[i]);
        }

        return answer;
    }
    Integer[] dx = {-1,1,0,0};
    Integer[] dy = {0,0,-1,1};

    // ["POOOP",
    //  "OXXOX",
    //  "OPXPX",
    //  "OOXOX",
    //  "POXXP"]
    private int seek(String[] place) {
        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length(); j++) {
                if (place[i].charAt(j) == 'X' || place[i].charAt(j) == 'O')
                    continue;
                queue.add(new Integer[]{i, j});
                int depth = 0;
                boolean[][] visited = new boolean[5][5];
                while (!queue.isEmpty()) {
                    Integer[] target = queue.poll();
                    visited[target[0]][target[1]] = true;
                    for (int k = 0; k<4; k++){
                        int nx = target[0] + dx[k];
                        int ny = target[1] + dy[k];
                        if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                        if (visited[nx][ny]) continue;
                        if (place[nx].charAt(ny) == 'O' && depth < 1) {
                            queue.add(new Integer[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                        else if (place[nx].charAt(ny) == 'P')
                            return 0;
                        // X는 Continue
                    }
                    depth++;
                }
            }
        }
        return 1;
    }
}