# Modelo Vista Controlador

**Nombre**: Modelo Vista Controlador

**Problema**: 
¿Cómo organizamos el código y la separamos de responsabilidades en aplicaciones con interfaces de usuario? 

**Solución**:
Separar las clases en 

- **Modelo**: Representa los datos y la lógica de negocio de la aplicación. Es responsable de gestionar el estado de la aplicación, acceder a la base de datos y ejecutar la lógica de negocio.

- **Vista**: Es responsable de la presentación de los datos. Genera la interfaz de usuario y se encarga de mostrar la información del modelo al usuario.

- **Controlador**: Actúa como un intermediario entre el Modelo y la Vista. Recibe las entradas del usuario, las procesa (generalmente modificando el modelo) y actualiza la vista en consecuencia.


# Ejemplo: Calculadora

![](./CalculadoraMVC.svg)


---

## Autor
- [@DAMM16](https://github.com/DAMM16/)
---