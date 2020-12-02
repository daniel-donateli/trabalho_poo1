#! /usr/bin/env python

if __name__ == "__main__":

    import random
    import argparse

    # Definição de constantes

    MAX_CARROS = 100
    MAX_INSUMOS = 99999

    # Verificar e parsear argumentos de linha de comando

    parser = argparse.ArgumentParser(description='Gerar arquivos de texto.')
    parser.add_argument('--max-carros')
    parser.add_argument('--max-insumos')
    args = parser.parse_args()

    if args.max_carros is not None:
        MAX_CARROS = int(args.max_carros)

    if args.max_insumos is not None:
        MAX_INSUMOS = int(args.max_insumos)


    # Gerar arquivo de insumos

    insumos = ['Madeira', 'Aço', 'Ferro', 'Alumínio', 'Ouro', 'Cobre', 'Chumbo']

    print('Criando arquivo de insumos...')

    file_insumos = open('../insumos.txt', 'w', encoding='utf-8')

    print('Escrevendo dados...')

    for insumo in insumos:
        file_insumos.write(insumo +
            '    ' + 
            str(random.randint(0, MAX_INSUMOS)) + 
            '\n'
        )

    print('Fechando arquivo...')

    file_insumos.close()

    # Gerar arquivo de carros

    carros = ['BR1.0', 'BRSedan', 'BRSedanTurbo', 'TitaHatch', 'TitaSedan', 'Posseidon', 'Hades', 'Zeus']
    cores = ['Azul', 'Vermelho', 'Preto', 'Amarelo', 'Prata', 'Branco']
    num_carros = random.randint(0, MAX_CARROS)

    print('Criando arquivo de carros...')

    file_carros = open('../carros.txt', 'w', encoding='utf-8')

    print('Escrevendo dados..')

    for i in range(num_carros):
        file_carros.write(random.choice(carros) + '    ' + random.choice(cores) + '\n')

    print('Fechando arquivo...')

    file_carros.close()

    print('Finalizado.')

else:
    print("Esse script não deve ser importado")