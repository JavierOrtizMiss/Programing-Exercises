def multiplo_3(numero):
    return numero % 3 == 0

def multiplo_5(numero):
    return numero % 5 == 0

def num():
    for i in range(1, 101):
        if multiplo_3(i) and multiplo_5(i):
            print("FizzBuzz")
        elif multiplo_3(i):
            print("Fizz")
        elif multiplo_5(i):
            print("Buzz")
        else:
            print(i)

num()
