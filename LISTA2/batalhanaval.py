import random

NUM_JOGADORES = 2
NUM_NAVIOS = 5
TAMANHO_TABULEIRO = 5

# Funcao para gerar um tabuleiro
def gerarTabuleiro(tamanho):
    if tamanho < 1 or tamanho > 9:
        print("Erro: O tamanho deve estar entre 1 e 9. Retornando matriz vazia.")
        return None
    
    tabuleiro = [['-' for _ in range(tamanho + 1)] for _ in range(tamanho + 1)]
    tabuleiro[0][0] = '*'
    
    for i in range(1, tamanho + 1):
        tabuleiro[0][i] = str(i)
        tabuleiro[i][0] = str(i)
    
    return tabuleiro

# Funcao para imprimir um tabuleiro
def imprimirTabuleiro(tabuleiro):
    for linha in tabuleiro:
        print(' '.join(linha))

# Funcao para posicionar um navio no tabuleiro
def gerarNavio(tabuleiro, linha, coluna):
    if linha < 1 or linha >= len(tabuleiro) or coluna < 1 or coluna >= len(tabuleiro[0]):
        print("Coordenadas invalidas. Escolha coordenadas diferentes.")
    elif tabuleiro[linha][coluna] == '@':
        print("Voce ja posicionou um navio aqui. Escolha coordenadas diferentes.")
    else:
        tabuleiro[linha][coluna] = '@'
        return True
    return False

# Funcao para realizar um tiro
def atirar(jogador, alvo, contadorAcertos, tabuleirosModelo, tabuleirosJogo, linha, coluna):
    if linha < 1 or linha >= len(tabuleirosModelo[0]) or coluna < 1 or coluna >= len(tabuleirosModelo[0][0]):
        print("Coordenadas invalidas. Escolha coordenadas diferentes.")
    else:
        case = tabuleirosModelo[alvo][linha][coluna]
        if case in ['X', 'O']:
            print("Voce ja atirou neste local. Escolha coordenadas diferentes.")
        elif case == '-':
            tabuleirosModelo[alvo][linha][coluna] = 'O'
            tabuleirosJogo[alvo][linha][coluna] = 'O'
            print(f"JOGADOR {jogador + 1} ERROU!")
            return True
        elif case == '@':
            tabuleirosModelo[alvo][linha][coluna] = 'X'
            tabuleirosJogo[alvo][linha][coluna] = 'X'
            contadorAcertos[jogador] += 1
            print(f"JOGADOR {jogador + 1} ACERTOU O NAVIO DO JOGADOR {alvo + 1}!!!")
            return True
    return False

def main():
    print("Bem-vindo ao jogo de Batalha Naval!!!")
    
    # Chamando tabuleiro
    tabuleirosModelo = [[[None for _ in range(TAMANHO_TABULEIRO + 1)] for _ in range(TAMANHO_TABULEIRO + 1)] for _ in range(NUM_JOGADORES)]
    tabuleirosJogo = [[[None for _ in range(TAMANHO_TABULEIRO + 1)] for _ in range(TAMANHO_TABULEIRO + 1)] for _ in range(NUM_JOGADORES)]
    
    for jogador in range(NUM_JOGADORES):
        tabuleirosModelo[jogador] = gerarTabuleiro(TAMANHO_TABULEIRO)
        tabuleirosJogo[jogador] = gerarTabuleiro(TAMANHO_TABULEIRO)
    
    # Coordenadas
    for jogador in range(NUM_JOGADORES):
        print(f"\nJOGADOR {jogador + 1}, INSIRA AS COORDENADAS DO SEU NAVIO")
        
        for navio in range(NUM_NAVIOS):
            verificarNavio = False
            while not verificarNavio:
                linha = int(input(f"Insira a localizacao da linha do navio {navio + 1}: "))
                coluna = int(input(f"Insira a localizacao da coluna do navio {navio + 1}: "))
                verificarNavio = gerarNavio(tabuleirosModelo[jogador], linha, coluna)
        
        imprimirTabuleiro(tabuleirosModelo[jogador])
    
    # Inicializando jogo
    contadorAcertos = [0 for _ in range(NUM_JOGADORES)]
    vencedor = -1
    alvo = 0
    while vencedor == -1:
        for jogador in range(NUM_JOGADORES):
            if jogador == 0:
                alvo = 1
            elif jogador == 1:
                alvo = 0
            
            verificarCoordenada = False
            while not verificarCoordenada:
                print(f"\nJOGADOR {jogador + 1}, insira a linha do tiro: ")
                linha = int(input())
                print(f"Jogador {jogador + 1}, insira a coluna do tiro: ")
                coluna = int(input())
                verificarCoordenada = atirar(jogador, alvo, contadorAcertos, tabuleirosModelo, tabuleirosJogo, linha, coluna)
            
            imprimirTabuleiro(tabuleirosJogo[alvo])
            print(f"Navios restantes: {NUM_NAVIOS - contadorAcertos[jogador]}")
            
            if NUM_NAVIOS - contadorAcertos[jogador] == 0:
                vencedor = jogador
                break
    
    # Resultado
    print(f"\nJOGADOR {vencedor + 1} VENCEU! VOCE AFUNDOU TODOS OS NAVIOS DO OPONENTE!")
    print("Tabuleiros finais:\nJOGADOR 1:")
    imprimirTabuleiro(tabuleirosJogo[0])
    print("\nJOGADOR 2:")
    imprimirTabuleiro(tabuleirosJogo[1])

if __name__ == "__main__":
    main()
