import random

def jogar_craps():
    # primeiro lançamento de dados
    dado1 = random.randint(1, 6)
    dado2 = random.randint(1, 6)
    soma = dado1 + dado2
    
    print(f"Primeiro lançamento: {dado1} + {dado2} = {soma}")
    
    if soma == 7 or soma == 11:
        print("Você venceu!")
    elif soma == 2 or soma == 3 or soma == 12:
        print("Você perdeu!")
    else:
        ponto = soma
        print(f"O ponto agora é {ponto}")
        
        # segundo lançamento de dados
        while True:
            dado1 = random.randint(1, 6)
            dado2 = random.randint(1, 6)
            soma = dado1 + dado2
            
            print(f"Lançamento: {dado1} + {dado2} = {soma}")
            
            if soma == ponto:
                print("Você venceu!")
                break
            elif soma == 7:
                print("Você perdeu!")
                break

# jogando o jogo de Craps
jogar_craps()
