NUM_AMOSTRAS = 10

def calcularMedia(amostras):
    soma = sum(amostras)
    return soma / len(amostras)

def calcularDesvioPadrao(amostras, media):
    soma = sum((amostra - media) ** 2 for amostra in amostras)
    return (soma / len(amostras)) ** 0.5

volts = []
for i in range(NUM_AMOSTRAS):
    amostra = float(input(f"Digite o valor da amostra {i + 1}: "))
    volts.append(amostra)

media = calcularMedia(volts)
print("\nMédia:", media)

desvioPadrao = calcularDesvioPadrao(volts, media)
print("Desvio Padrão:", desvioPadrao)

if desvioPadrao > media * 0.1:
    situacao = "Multímetro com problema."
else:
    situacao = "Multímetro OK."
print("Situação:", situacao)
