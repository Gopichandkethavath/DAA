class Graph:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []

    def add_edge(self, u, v, w):
        self.graph.append((w, u, v))

    def find(self, parent, i):
        if parent[i] != i:
            parent[i] = self.find(parent, parent[i])
        return parent[i]

    def apply_union(self, parent, rank, x, y):
        xroot, yroot = self.find(parent, x), self.find(parent, y)
        if rank[xroot] < rank[yroot]:
            parent[xroot] = yroot
        elif rank[xroot] > rank[yroot]:
            parent[yroot] = xroot
        else:
            parent[yroot] = xroot
            rank[xroot] += 1

    def kruskal_algo(self):
        result, i, e = [], 0, 0
        parent, rank = list(range(self.V)), [0] * self.V
        self.graph.sort()

        while e < self.V - 1:
            w, u, v = self.graph[i]
            i += 1
            x, y = self.find(parent, u), self.find(parent, v)
            if x != y:
                e += 1
                result.append((u, v, w))
                self.apply_union(parent, rank, x, y)

        for u, v, weight in result:
            print(f"{u} - {v}: {weight}")


g = Graph(6)
g.add_edge(0, 1, 4)
g.add_edge(0, 2, 4)
g.add_edge(1, 2, 2)
g.add_edge(1, 0, 4)
g.add_edge(2, 0, 4)
g.add_edge(2, 1, 2)
g.add_edge(2, 3, 3)
g.add_edge(2, 5, 2)
g.add_edge(2, 4, 4)
g.add_edge(3, 2, 3)
g.add_edge(3, 4, 3)
g.add_edge(4, 2, 4)
g.add_edge(4, 3, 3)
g.add_edge(5, 2, 2)
g.add_edge(5, 4, 3)
g.kruskal_algo()
