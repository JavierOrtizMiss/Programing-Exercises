def f(w, x, y, z):
    return w and y and (not z) or (not w) and (not x) and y or x and (not y) and z or (not w) and y or x and (not z)

def table1():
    m = [[0 for _ in range(4)] for _ in range(16)]  # Matriz que almacena la tabla
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
    for n in range(16):
        result = f(m[n][0], m[n][1], m[n][2], m[n][3])  # Calculo de la función
        print("[%d][%d][%d][%d] = %d" % (m[n][0], m[n][1], m[n][2], m[n][3], result))
        
def tabledisyun():
    return
    

table1()
