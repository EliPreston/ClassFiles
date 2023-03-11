

resultsFib = {1:1, 2:1}

def fib(n):
    if n in resultsFib:
        return resultsFib[n]
    resultsFib[n] = fib(n-1) + fib(n-2)
    return resultsFib[n]

print(fib(10))
