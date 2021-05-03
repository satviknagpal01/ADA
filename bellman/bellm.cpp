#include <iostream>

using namespace std;

typedef struct totedg
{
    int src;
    int dest;
    int wt;
} totedg;
void bellmanford(int nv, totedg e[], int src_vert, int ne)
{
    int u, v, weight, i, j = 0;
    int dis[ne];

    for (i = 0; i < nv; i++)
    {
        dis[i] = 9999;
    }

    dis[src_vert] = 0;

    for (i = 0; i < nv - 1; i++)
    {
        for (j = 0; j < ne; j++)
        {
            u = e[j].src;
            v = e[j].dest;
            weight = e[j].wt;

            if (dis[u] != 9999 && dis[u] + weight < dis[v])
            {
                dis[v] = dis[u] + weight;
            }
        }
    }

    for (j = 0; j < ne; j++)
    {
        u = e[j].src;
        v = e[j].dest;
        weight = e[j].wt;

        if (dis[u] + weight < dis[v])
        {
            cout << "\n negative cycle \n";
        }
    }

    cout << "\nVertex"
         << "  Distance from source";
    for (i = 1; i <= nv; i++)
    {
        cout << "\n"
             << i << "\t" << dis[i];
    }
}
int main()
{
    int numver = 5, srcver;

    cout << "Enter the source vertex of the graph: ";
    cin >> srcver;

    totedg e[6] = {{1, 2, 1}, 
                        {1, 3, 10},
                        {2, 4, 1},
                        {3, 4, -10},
                        {5, 3, 3}};
    bellmanford(numver, e, srcver, 6);

    return 0;
}