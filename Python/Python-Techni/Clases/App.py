import PrimeraClase
ia = PrimeraClase.Ejemplo(1, 0.5, -1)

correcto = 1

while True:

    error = ia.aprendizaje(correcto)

    if error == 0:
        print("¡Aprendizaje correcto!")
        break

    print("Corrigiendo pesos...")