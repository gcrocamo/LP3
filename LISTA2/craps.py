import random

def jogarDado():
    dado = random.randint(1, 6);
    return dado

dado1, dado2 = jogarDado(), jogarDado()
ponto=dado1+dado2
print("Dado 1: ", dado1, "| Dado 2: ", dado2)
print("Pontos: ", ponto)

if ponto==7 or ponto==11:
    print("Voce ganhou :-)")
elif ponto==2 or ponto==3 or ponto==12:
    print("Vc perdeu :-(")
else:
    cont = 0
    print("ESTAGIO 2:")
    while True:
        dado1, dado2 = jogarDado(), jogarDado()
        print ("Jogada ", ++cont, ":")
        print("Dado 1: ", dado1, "| Dado 2: ", dado2)
        print("Pontos: ", ponto)
        if dado1+dado2 == ponto:
            print("Voce ganhou :-)")
            break
        elif dado1+dado2 == 7:
            print("Vc perdeu :-(")
            break
        