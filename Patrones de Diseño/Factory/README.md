# Factory Method

**Nombre**: Factory Method

**Problema**: 
¿Cómo crear objetos de diferentes tipos de manera flexible y desacoplada sin conocer de antemano la clase exacta de los objetos que deben ser creados? Necesitamos evitar la duplicación de código y gestionar la complejidad de la creación de objetos, permitiendo que el sistema sea fácil de extender y mantener.

**Solución**:
Definir una interfaz o clase abstracta con un método de creación (FabricaAbstracta), y permitir que las subclases concreten este método para instanciar objetos específicos. Esto encapsula la lógica de creación en un único lugar, desacoplando el código cliente de las clases concretas que deben ser instanciadas y facilitando la extensión del sistema mediante la adición de nuevas clases de productos (Iproducto) sin modificar el código existente.

![](./Factory.svg)


---

## Autor
- [@DAMM16](https://github.com/DAMM16/)
---