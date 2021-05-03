import java.util.Scanner;

class prim {

    int minKey(int key[], Boolean set[], int V) {
        int min = Integer.MAX_VALUE, m = -1;
        for (int i = 0; i < V; i++)
            if (set[i] == false && key[i] < min) {
                min = key[i];
                m = i;
            }
        return m;
    }

    void mst(int graph[][], int V) {
        int parent[] = new int[V];
        int key[] = new int[V];
        Boolean set[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            set[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, set, V);
            set[u] = true;
            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && set[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        System.out.println("Edge \t Weight");
        int sum = 0;
        for (int i = 1; i < V; i++) {
            System.out.println((char) (parent[i] + 65) + " - " + (char) (i + 65) + "\t" + graph[i][parent[i]]);
            sum = sum + graph[i][parent[i]];
        }
        System.out.println("\t total weight = " + sum);
    }

    public static void main(String[] args) {
        prim p = new prim();
        int V = 5;
        Scanner sc = new Scanner(System.in);
        int graph[][] = { { 0, 9, 5, 2, 0 }, { 9, 0, 0, 6, 5 }, { 5, 0, 0, 4, 5 }, { 2, 6, 4, 0, 4 },
                { 0, 5, 5, 4, 0 } };
        p.mst(graph, V);
    }
}