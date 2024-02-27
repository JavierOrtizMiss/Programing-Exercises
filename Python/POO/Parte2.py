def f(w, x, y, z):
    return w and y and (not z) or (not w) and (not x) and y or x and (not y) and z or (not w) and y or x and (not z)

def elmejormaestrocuri():
    m = [[0 for i in range(4)] for i in range(16)]  # Matriz que almacena la tabla
    n = 0  # Contador de las 16 combinaciones de booleanos

    # Ciclo que genera las combinaciones de valores booleanos
    for w in range(2):
        for x in range(2):
            for y in range(2):
                for z in range(2):
                    m[n][0] = w
                    m[n][1] = x
                    m[n][2] = y
                    m[n][3] = z
                    n += 1

    # Ciclo para generar la tabla aplicando la función f
    print("-----------------Tabla de verdad de la función-----------------")
    print("[w][x][y][z] = [f(w,x,y,z)]")
    for n in range(16):
        result = f(m[n][0], m[n][1], m[n][2], m[n][3])  # Calculo de la función
        print("[%d][%d][%d][%d] = %d" % (m[n][0], m[n][1], m[n][2], m[n][3], result))
    
    print("--------------Funcion Booleana Disyuntiva-------------------")
    for n in range(16):
        if f(m[n][0], m[n][1], m[n][2], m[n][3]) == 1:
            print("( ", end="")
            if m[n][0] == 0:
                print("w'", end=" ")
            if m[n][0] == 1:
                print("w", end=" ")
            if m[n][1] == 0:
                print("x'", end=" ")
            if m[n][1] == 1:
                print("x", end=" ")
            if m[n][2] == 0:
                print("y'", end=" ")
            if m[n][2] == 1:
                print("y", end=" ")
            if m[n][3] == 0:
                print("z'", end=" ")
            if m[n][3] == 1:
                print("z", end=" ")
            print(") ", end="")
            print(" + ", end="")

    print("\n\n\n--------------Funcion Booleana Conjuntiva-------------------")
    for n in range(16):
        if f(m[n][0], m[n][1], m[n][2], m[n][3]) == 0:
            print("( ", end="")
            if m[n][0] == 0:
                print("w'", end=" ")
            if m[n][0] == 1:
                print("w", end=" ")
            if m[n][1] == 0:
                print("x'", end=" ")
            if m[n][1] == 1:
                print("x", end=" ")
            if m[n][2] == 0:
                print("y'", end=" ")
            if m[n][2] == 1:
                print("y", end=" ")
            if m[n][3] == 0:
                print("z'", end=" ")
            if m[n][3] == 1:
                print("z", end=" ")
            print(") ", end="")
            print(" + ", end="")
    
    # Mapa de Karnaugh
    print("\n\n\n--------------Mapa de Karnaugh-------------------")
    print("[wx]\\[yz]    00   01   11   10")
    print("   00        %d    %d    %d    %d" % (f(0,0,0,0), f(0,0,0,1), f(0,0,1,1), f(0,0,1,0)))
    print("   01        %d    %d    %d    %d" % (f(0,1,0,0), f(0,1,0,1), f(0,1,1,1), f(0,1,1,0)))
    print("   11        %d    %d    %d    %d" % (f(1,1,0,0), f(1,1,0,1), f(1,1,1,1), f(1,1,1,0)))
    print("   10        %d    %d    %d    %d" % (f(1,0,0,0), f(1,0,0,1), f(1,0,1,1), f(1,0,1,0)))

elmejormaestrocuri()

