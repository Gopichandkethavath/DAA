class item:
    def __init__(self, profit, weight):
        self.profit = profit
        self.weight = weight
        self.ratio = profit / weight

def fractionalKnapsack(W, arr):
    arr.sort(key=lambda x: x.ratio, reverse=True)
    finalProfit = 0.0
    for item in arr:
        if item.weight <= W:
            W = W - item.weight
            finalProfit = finalProfit + item.profit
        else:
            finalProfit = finalProfit + (item.profit / item.weight) * W
            break
    return finalProfit

if __name__ == "__main__":
    W = int(input("Enter the maximum weight to be filled in the knapsack: "))
    n = int(input("Enter the total number of items: "))
    arr = []
    for i in range(0, n):
        p1 = int(input("Enter profit: "))
        w1 = int(input("Enter weight: "))
        arr.append(item(p1, w1))
    print("The maximum profit is:")
    max_val = fractionalKnapsack(W, arr)
    print(max_val)
