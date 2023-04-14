import statistics

# realizando as 10 medições de voltagem
leituras = [5.6, 6.2, 5.9, 6.5, 5.8, 6.1, 5.7, 6.3, 5.5, 6.0]

# calculando a média e o desvio padrão das leituras
media = statistics.mean(leituras)
desvio_padrao = statistics.stdev(leituras)

# verificando se o desvio padrão é superior a 10% do valor médio
limite_desvio = media * 0.1
if desvio_padrao > limite_desvio:
    estado = "com problemas"
else:
    estado = "operacional"

# imprimindo os resultados
print("Leituras:", leituras)
print("Média:", media)
print("Desvio Padrão:", desvio_padrao)
print("Estado do multímetro:", estado)
