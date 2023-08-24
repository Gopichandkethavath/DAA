def nqueens(k,n):
    if k>n:
        print(x[1:n+1])
    else:
        for i in range(1, n+1):
            if place(k,i):
                x[k]=i
                nqueens(k+1, n)
def place(k,i):
    for j in range(1,k):
        if (x[j] ==i) or (abs(x[j] -i) ==abs(j - k)):
            return False
    return True
print("possible arrangement of queens:")
n=8
x=[0] * (n+1)
nqueens(1,n)