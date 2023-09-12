NUM_AMOSTRAS = 10

def calcularMedia(amostras):
    soma = sum(amostras)
    return soma / len(amostras)

def calcularDesvioPadrao(amostras, media):
    soma = sum((amostra - media) ** 2 for amostra in amostras)
    return (soma / len(amostras)) ** 0.5

def main():
    volts = []

    for i in range(NUM_AMOSTRAS):
        amostra = float(input(f"Digite o valor da amostra {i + 1}: "))
        volts.append(amostra)

    # Cálculo da média
    media = calcularMedia(volts)
    print("\nMédia:", media)

    # Cálculo do desvio padrão
    desvioPadrao = calcularDesvioPadrao(volts, media)
    print("Desvio Padrão:", desvioPadrao)

    # Situação do multímetro
    situacao = "Multímetro com problema." if desvioPadrao > media * 0.1 else "Multímetro OK."
    print("Situação:", situacao)

if __name__ == "__main__":
    main()
