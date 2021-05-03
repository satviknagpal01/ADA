public class Dijkstra {

    public static void dijkstra(int[][] graph, int source) {
        int count = graph.length;
        boolean[] visited = new boolean[count];
        int[] distance = new int[count];
        for (int i = 0; i < count; i++) {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;
        for (int i = 0; i < count; i++) {
            int u = mindis(distance, visited);
            visited[u] = true;
            for (int v = 0; v < count; v++) {
                if (!visited[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
        }

    }

    private static int mindis(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minver = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minver = i;
            }
        }
        return minver;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 9, 5, 2, 0 }, { 9, 0, 0, 6, 5 }, { 5, 0, 0, 4, 5 }, { 2, 6, 4, 0, 4 },
                { 0, 5, 5, 4, 0 } };
        dijkstra(graph, 0);
    }
}