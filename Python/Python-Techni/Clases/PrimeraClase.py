class Ejemplo:

    def __init__(self, dato, peso, sesgo):
        self.dato = dato
        self.peso = peso
        self.sesgo = sesgo

    def ecuation(self):
        return (self.dato * self.peso) + self.sesgo

    def activar(self):
        resultado = self.ecuation()

        if resultado >= 0:
            return 1
        else:
            return 0

    def aprendizaje(self, correcto):
        apren = 0.1

        resultado = self.activar()
        print(resultado)
        error = correcto - resultado
        self.peso += apren * error * self.dato
        self.sesgo += apren * error

        return error
