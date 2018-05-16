Informe Ejercicio Fibonacci 3

1) El programa cumple con la consigna de fibo3. Utilizando los ejemplos dados en el ejercicio el resultado es el esperado. Ademas, el programa sigue funcionando utilizando solo los parametros tanto de fibo2 como de fibo. Sin embargo, usando otros ejemplos ocurren algunas fallas. Por ejemplo, invocando los siguientes ejemplos no cumple con lo pedido:

- java -jar fibo.jar -o=vd -f=salida.txt -m=s 5

En el archivo salida.txt aparece lo siguiente: fibo<5>s:
7 ; cuando tendria que aparecer de la siguiente manera:

fibo<5>s:

7

- java -jar fibo.jar -o=vd -f=salida.txt -m=l 5

En el archivo salida.txt aparece lo siguiente: fibo<5>:
0
1
1
2
3 ; cuando tendria que aparecer de la siguiente manera:

fibo<5>: 
0
1
1
2
3

- java -jar fibo.jar -o=vi -f=salida.txt -m=l 5

En el archivo salida.txt aparece lo siguiente: fibo<5>:
3
2
1
1
0 ; cuando tendria que aparecer de la siguiente manera:

fibo<5>: 
3
2
1
1
0

Con este ejemplo, solo no funciona con la orientacion vertical(v) tanto en direccion directa(d) como inversa(i) utilizando el modo de funcionamiento de lista(l). Al no funcionar con dicho ejemplo, si queremos utilizar el siguiente ejemplo tampoco realiza el resultado esperado: 

java -jar fibo.jar -o=vi -f=salida.txt 5

Por defecto, tendria que imprimirlo en el archivo con el modo de funcionamiento de lista(l) pero no lo hace.
Otra falla que presenta es que no se pueden pasar los parametros en cualquier orden. Al querer ingresar, por ejemplo, la siguiente sentencia java -jar fibo.jar -m=l -o=hd 5 el resultado es el siguiente: 

Opciones no validas

Cuando, en realidad, el resultado tendria que ser:

fibo<5>: 0 1 1 2 3

Otra falla que tiene es que no valida si el numero el cual se obtiene de la serie de Fibonacci tiene que ser un numero positivo o, en su defecto, si se deja ingresar un numero negativo que solo ponga 0. 

- java -jar fibo.jar -1

fibo<-1>:


2) No presenta ningun tipo de tests. Esto hace que, por ejemplo, no realice nada al querer hacer la serie de Fibonacci de un numero negativo o de 0. Tampoco se chequea ningun tipo de metodo que presente alguna logica. Esto hace que al mirar la cobertura de todo el programa me de 0 como resultado. 

3) Cumple con las convenciones de Java.

4) S: el principio de Single Responsability no lo viola. Cada una de las clases se encarga de una tarea en particular.

O: el principio de Open-Closed lo viola ya que por ejemplo en la clase de FibonacciSumador en el metodo calcularFibonacci se presenta una cadena de if que si se llega a generar una nueva opcion para el modo de funcionamiento se tendria que agregar otro if. Asi, cuantos mas opciones se agreguen mas largo se haria esa cadena. Lo mismo ocurre, por ejemplo, en la clase FibonacciLargo2 dentro del metodo calcular Fibonacci con la serie de case que presenta. Si se agregaran mas opciones esa lista se haria cada vez mas larga. 

L: el principio de Liskov Substitution no se puede corroborar ya que no se presenta herencia en ninguna de las clases utilizadas.

I: el principio de interface Segregation tampoco se puede corroborar ya que no hay ninguna interfaz dentro del programa.

D: el principio de Dependency Inversion lo viola ya que en las clases FibonacciSumador y FibonacciLargo2 hace new de la clase Fibonacci cuando podria directamente llamar a los metodos de dichas clases y guardar lo que necesite de dichos metodos en la clase en la que esta manejando en ese momento. Es mejor ir siempre a lo mas abstracto. 

Mas alla de los principios SOLID, el programa presenta otros detalles que generan "ruido". Por ejemplo, hay una clase llamada FibonacciLargo2 que simplemente con el nombre no se sabe que realiza hasta que se ve sus metodos y ahi se puede deducir lo que hace realmente. Seria conveniente que presente un nombre mas claro. Como se dijo anteriormente, presenta algunas cadenas de if al igual que cadenas de case. Realizado de esa manera, si se quiere extender el programa con mas opciones seria algo tedioso y largo para los metodos que presenten dichas cadenas. 
Otra cosa que podria ser mas util es en vez de utilizar un String para el resultado final de la serie de Fibonacci de un numero seria usar un array de enteros para poder manejar mejor los parametros.
Otro detalle al analizar el programa es, por un lado, la falta de validaciones y con ello el uso de excepciones. Por el otro lado, utiliza una sola excepcion que podria ser mas clara en el nombre y, aun mejor, generar sus propias excepciones.
El nombre de la clase Fibonachi esta mal escrito. Tendria que decir Fibonacci.
En cuanto al modelo no esta bien realizado, mas alla que presente varias clases que realizan cada una distintas tareas. Hay mucho codigo redundante y casi un metodo para cada posibilidad para cada uno de los parametros. Esto hace que no se abstraiga al momento de pensar el problema en cuestion.


Waldo Gaspari      