def fibonacci(n:int):
    if n ==0 or n==1:
        return n
    else:
        fib=[0,1]
        for i in range (n):
            fib.append(fib[-1]+fib[-2])
        return print(fib)

fibonacci(50)

    