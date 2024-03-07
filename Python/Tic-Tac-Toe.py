import random

def print_board(board):
    print("+-------+-------+-------+")
    print(f"|       |       |       |")
    print(f"|   {board[1]}   |   {board[2]}   |   {board[3]}   |")
    print(f"|       |       |       |")
    print("+-------+-------+-------+")
    print(f"|       |       |       |")
    print(f"|   {board[4]}   |   {board[5]}   |   {board[6]}   |")
    print(f"|       |       |       |")
    print("+-------+-------+-------+")
    print(f"|       |       |       |")
    print(f"|   {board[7]}   |   {board[8]}   |   {board[9]}   |")
    print(f"|       |       |       |")
    print("+-------+-------+-------+")

def check_winner(board):
    # Check rows
    for i in range(1, 8, 3):
        if board[i] == board[i+1] == board[i+2]:
            return board[i]

    # Check columns
    for i in range(1, 4):
        if board[i] == board[i+3] == board[i+6]:
            return board[i]

    # Check diagonals
    if board[1] == board[5] == board[9]:
        return board[1]
    if board[3] == board[5] == board[7]:
        return board[3]

    return None

def tic_tac_toe():
    board = [" "]*10
    board[5] = "X"  # Machine's move, always start from center
    print_board(board)

    while True:
        # Player's move
        while True:
            try:
                move = int(input("Ingresa tu movimiento: "))
                if move < 1 or move > 9 or board[move] != " ":
                    print("Movimiento no válido. Inténtalo de nuevo.")
                else:
                    board[move] = "O"
                    break
            except ValueError:
                print("Por favor, ingresa un número.")

        print_board(board)
        winner = check_winner(board)
        if winner == "O":
            print("¡Has Ganado!")
            break
        elif winner is None:
            if " " not in board:
                print("¡Empate!")
                break

        # Machine's move
        while True:
            machine_move = random.randint(1, 9)
            if board[machine_move] == " ":
                board[machine_move] = "X"
                break

        print("Turno de la máquina:")
        print_board(board)
        winner = check_winner(board)
        if winner == "X":
            print("¡La máquina ha ganado!")
            break
        elif winner is None:
            if " " not in board:
                print("¡Empate!")
                break

if __name__ == "__main__":
    tic_tac_toe()
