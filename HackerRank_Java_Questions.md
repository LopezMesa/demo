# HackerRank - Preguntas Más Frecuentes de Generación de Código en Java

Este documento contiene las preguntas de código más frecuentes en HackerRank para Java, con sus enunciados en inglés, traducción al español y soluciones.

---

## 1. FizzBuzz

### 🇺🇸 English Statement

Write a program that prints the numbers from 1 to n. But for multiples of three print "Fizz" instead of the number and for the multiples of five print "Buzz". For numbers which are multiples of both three and five print "FizzBuzz".

**Input Format:** A single integer, n.

**Constraints:** 1 <= n <= 10^5

**Output Format:** Print the FizzBuzz sequence, one per line.

### 🇪🇸 Traducción al Español

Escribe un programa que imprima los números del 1 al n. Pero para los múltiplos de tres imprime "Fizz" en lugar del número y para los múltiplos de cinco imprime "Buzz". Para los números que son múltiplos de ambos, tres y cinco, imprime "FizzBuzz".

**Formato de Entrada:** Un único entero, n.

**Restricciones:** 1 <= n <= 10^5

**Formato de Salida:** Imprime la secuencia FizzBuzz, uno por línea.

### 💻 Solución en Java

```java
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        scanner.close();
    }
}
```

---

## 2. Diagonal Difference

### 🇺🇸 English Statement

Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix arr is shown below:
```
1 2 3
4 5 6
9 8 9
```
The left-to-right diagonal = 1 + 5 + 9 = 15. The right-to-left diagonal = 3 + 5 + 9 = 17. Their absolute difference is |15 - 17| = 2.

**Function Description:** Complete the diagonalDifference function. It must return an integer representing the absolute diagonal difference.

**Parameters:** int arr[n][m] - an array of integers

**Returns:** int - the absolute diagonal difference

**Constraints:** -100 <= arr[i][j] <= 100

### 🇪🇸 Traducción al Español

Dada una matriz cuadrada, calcula la diferencia absoluta entre las sumas de sus diagonales.

Por ejemplo, la matriz cuadrada arr se muestra a continuación:
```
1 2 3
4 5 6
9 8 9
```
La diagonal de izquierda a derecha = 1 + 5 + 9 = 15. La diagonal de derecha a izquierda = 3 + 5 + 9 = 17. Su diferencia absoluta es |15 - 17| = 2.

**Descripción de la Función:** Completa la función diagonalDifference. Debe devolver un entero que represente la diferencia absoluta de las diagonales.

**Parámetros:** int arr[n][m] - un arreglo de enteros

**Retorna:** int - la diferencia absoluta de las diagonales

**Restricciones:** -100 <= arr[i][j] <= 100

### 💻 Solución en Java

```java
import java.util.Scanner;

public class DiagonalDifference {
    public static int diagonalDifference(int[][] arr) {
        int n = arr.length;
        int leftToRight = 0;
        int rightToLeft = 0;

        for (int i = 0; i < n; i++) {
            leftToRight += arr[i][i];
            rightToLeft += arr[i][n - 1 - i];
        }

        return Math.abs(leftToRight - rightToLeft);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(diagonalDifference(arr));
        scanner.close();
    }
}
```

---

## 3. Left Rotation

### 🇺🇸 English Statement

A left rotation operation on an array shifts each of the array's elements 1 unit to the left. For example, if 2 left rotations are performed on array [1, 2, 3, 4, 5], then the array would become [3, 4, 5, 1, 2]. Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.

Given an array a of n integers and a number, d, perform d left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.

**Function Description:** Complete the rotLeft function. It should return the resulting array of integers.

**Parameters:** int[] a - the array to rotate; int d - the number of rotations

**Returns:** int[] - the rotated array

**Constraints:** 1 <= n <= 10^5; 1 <= d <= n; 1 <= a[i] <= 10^6

### 🇪🇸 Traducción al Español

Una operación de rotación izquierda en un arreglo desplaza cada uno de los elementos del arreglo 1 unidad hacia la izquierda. Por ejemplo, si se realizan 2 rotaciones izquierdas en el arreglo [1, 2, 3, 4, 5], entonces el arreglo se convertiría en [3, 4, 5, 1, 2]. Nótese que el elemento con el índice más bajo se mueve al índice más alto en una rotación. Esto se llama un arreglo circular.

Dado un arreglo a de n enteros y un número d, realiza d rotaciones izquierdas en el arreglo. Devuelve el arreglo actualizado para ser impreso como una sola línea de enteros separados por espacios.

**Descripción de la Función:** Completa la función rotLeft. Debe devolver el arreglo resultante de enteros.

**Parámetros:** int[] a - el arreglo a rotar; int d - el número de rotaciones

**Retorna:** int[] - el arreglo rotado

**Restricciones:** 1 <= n <= 10^5; 1 <= d <= n; 1 <= a[i] <= 10^6

### 💻 Solución en Java

```java
import java.util.Scanner;

public class LeftRotation {
    public static int[] rotLeft(int[] a, int d) {
        int n = a.length;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[i] = a[(i + d) % n];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] result = rotLeft(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(" ");
        }
        scanner.close();
    }
}
```

---

## 4. Two Strings

### 🇺🇸 English Statement

Given two strings, determine if they share a common substring. A substring may be as small as one character.

For example, the words "a", "and", "art" share the common substring "a". The words "be" and "cat" do not share a substring.

**Function Description:** Complete the twoStrings function. It should return a string, either "YES" or "NO" based on whether the strings share a common substring.

**Parameters:** String s1 - a string; String s2 - another string

**Returns:** String - either "YES" or "NO"

**Constraints:** 1 <= |s1|, |s2| <= 10^5

### 🇪🇸 Traducción al Español

Dadas dos cadenas, determina si comparten una subcadena común. Una subcadena puede ser tan pequeña como un solo carácter.

Por ejemplo, las palabras "a", "and", "art" comparten la subcadena común "a". Las palabras "be" y "cat" no comparten una subcadena.

**Descripción de la Función:** Completa la función twoStrings. Debe devolver una cadena, ya sea "YES" o "NO" según si las cadenas comparten una subcadena común.

**Parámetros:** String s1 - una cadena; String s2 - otra cadena

**Retorna:** String - ya sea "YES" o "NO"

**Restricciones:** 1 <= |s1|, |s2| <= 10^5

### 💻 Solución en Java

```java
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings {
    public static String twoStrings(String s1, String s2) {
        Set<Character> chars = new HashSet<>();

        for (char c : s1.toCharArray()) {
            chars.add(c);
        }

        for (char c : s2.toCharArray()) {
            if (chars.contains(c)) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < q; i++) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            System.out.println(twoStrings(s1, s2));
        }
        scanner.close();
    }
}
```

---

## 5. Minimum Swaps 2

### 🇺🇸 English Statement

You are given an unordered array consisting of consecutive integers [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending order.

For example, given the array [7, 1, 3, 2, 4, 5, 6] we perform the following steps:
```
i   arr                     swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
```
It took 5 swaps to sort the array.

**Function Description:** Complete the minimumSwaps function. It must return an integer representing the minimum number of swaps to sort the array.

**Parameters:** int[] arr - an unordered array of integers

**Returns:** int - the minimum number of swaps to sort the array

**Constraints:** 1 <= n <= 10^5; 1 <= arr[i] <= n

### 🇪🇸 Traducción al Español

Se te da un arreglo desordenado que consiste en enteros consecutivos [1, 2, 3, ..., n] sin duplicados. Se te permite intercambiar cualquier dos elementos. Encuentra el número mínimo de intercambios necesarios para ordenar el arreglo en orden ascendente.

Por ejemplo, dado el arreglo [7, 1, 3, 2, 4, 5, 6] realizamos los siguientes pasos:
```
i   arr                     swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
```
Tomó 5 intercambios ordenar el arreglo.

**Descripción de la Función:** Completa la función minimumSwaps. Debe devolver un entero que represente el número mínimo de intercambios para ordenar el arreglo.

**Parámetros:** int[] arr - un arreglo desordenado de enteros

**Retorna:** int - el número mínimo de intercambios para ordenar el arreglo

**Restricciones:** 1 <= n <= 10^5; 1 <= arr[i] <= n

### 💻 Solución en Java

```java
import java.util.Scanner;

public class MinimumSwaps2 {
    public static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (arr[i] != i + 1) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(minimumSwaps(arr));
        scanner.close();
    }
}
```

---

## 6. New Year Chaos

### 🇺🇸 English Statement

It is New Year's Day and people are in line for the Wonderland rollercoaster ride. Each person wears a sticker indicating their initial position in the queue from 1 to n. Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker. One person can bribe at most two others.

Determine the minimum number of bribes that took place to get to a given queue order. Print the number of bribes, or, if anyone has bribed more than two people, print "Too chaotic".

**Function Description:** Complete the minimumBribes function. It must print an integer representing the minimum number of bribes necessary, or "Too chaotic" if the line configuration is not possible.

**Parameters:** int[] q - the positions of the people after all bribes

**Returns:** void - prints the minimum number of bribes or "Too chaotic"

**Constraints:** 1 <= n <= 10^5

### 🇪🇸 Traducción al Español

Es el Día de Año Nuevo y la gente está en fila para la montaña rusa de Wonderland. Cada persona lleva una etiqueta que indica su posición inicial en la cola del 1 al n. Cualquier persona puede sobornar a la persona directamente frente a ellos para intercambiar posiciones, pero aún llevan su etiqueta original. Una persona puede sobornar como máximo a otras dos.

Determina el número mínimo de sobornos que tuvieron lugar para llegar a un orden de cola dado. Imprime el número de sobornos, o, si alguien ha sobornado a más de dos personas, imprime "Too chaotic".

**Descripción de la Función:** Completa la función minimumBribes. Debe imprimir un entero que represente el número mínimo de sobornos necesarios, o "Too chaotic" si la configuración de la línea no es posible.

**Parámetros:** int[] q - las posiciones de las personas después de todos los sobornos

**Retorna:** void - imprime el número mínimo de sobornos o "Too chaotic"

**Restricciones:** 1 <= n <= 10^5

### 💻 Solución en Java

```java
import java.util.Scanner;

public class NewYearChaos {
    public static void minimumBribes(int[] q) {
        int bribes = 0;

        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] q = new int[n];

            for (int j = 0; j < n; j++) {
                q[j] = scanner.nextInt();
            }

            minimumBribes(q);
        }
        scanner.close();
    }
}
```

---

## 7. Sock Merchant

### 🇺🇸 English Statement

John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

For example, there are n = 7 socks with colors ar = [1, 2, 1, 2, 1, 3, 2]. There is one pair of color 1 and one of color 2. There are three odd socks left, one of each color. The number of pairs is 2.

**Function Description:** Complete the sockMerchant function. It must return an integer representing the number of matching pairs of socks that are available.

**Parameters:** int n - the number of socks in the pile; int[] ar - the colors of each sock

**Returns:** int - the number of pairs

**Constraints:** 1 <= n <= 100; 1 <= ar[i] <= 100

### 🇪🇸 Traducción al Español

John trabaja en una tienda de ropa. Tiene una gran pila de calcetines que debe emparejar por color para la venta. Dado un arreglo de enteros que representan el color de cada calcetín, determina cuántos pares de calcetines con colores coincidentes hay.

Por ejemplo, hay n = 7 calcetines con colores ar = [1, 2, 1, 2, 1, 3, 2]. Hay un par de color 1 y uno de color 2. Quedan tres calcetines sin par, uno de cada color. El número de pares es 2.

**Descripción de la Función:** Completa la función sockMerchant. Debe devolver un entero que represente el número de pares coincidentes de calcetines que están disponibles.

**Parámetros:** int n - el número de calcetines en la pila; int[] ar - los colores de cada calcetín

**Retorna:** int - el número de pares

**Restricciones:** 1 <= n <= 100; 1 <= ar[i] <= 100

### 💻 Solución en Java

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {
    public static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> colorCount = new HashMap<>();

        for (int color : ar) {
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
        }

        int pairs = 0;
        for (int count : colorCount.values()) {
            pairs += count / 2;
        }

        return pairs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ar = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }

        System.out.println(sockMerchant(n, ar));
        scanner.close();
    }
}
```

---

## 8. Repeated String

### 🇺🇸 English Statement

Lilah has a string, s, of lowercase English letters that she repeated infinitely many times. Given an integer, n, find and print the number of letter "a"'s in the first n letters of Lilah's infinite string.

For example, if the string s = "abcac" and n = 10, the substring we consider is "abcacabcac", the first 10 characters of her infinite string. There are 4 occurrences of "a" in the substring.

**Function Description:** Complete the repeatedString function. It should return an integer representing the number of occurrences of "a" in the prefix of length n in the infinitely repeating string.

**Parameters:** String s - a string to repeat; long n - the number of characters to consider

**Returns:** long - the frequency of "a" in the substring

**Constraints:** 1 <= |s| <= 100; 1 <= n <= 10^12

### 🇪🇸 Traducción al Español

Lilah tiene una cadena, s, de letras minúsculas del inglés que repite infinitamente. Dado un entero n, encuentra e imprime el número de letras "a" en las primeras n letras de la cadena infinita de Lilah.

Por ejemplo, si la cadena s = "abcac" y n = 10, la subcadena que consideramos es "abcacabcac", los primeros 10 caracteres de su cadena infinita. Hay 4 ocurrencias de "a" en la subcadena.

**Descripción de la Función:** Completa la función repeatedString. Debe devolver un entero que represente el número de ocurrencias de "a" en el prefijo de longitud n en la cadena que se repite infinitamente.

**Parámetros:** String s - una cadena para repetir; long n - el número de caracteres a considerar

**Retorna:** long - la frecuencia de "a" en la subcadena

**Restricciones:** 1 <= |s| <= 100; 1 <= n <= 10^12

### 💻 Solución en Java

```java
import java.util.Scanner;

public class RepeatedString {
    public static long repeatedString(String s, long n) {
        long countInString = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') countInString++;
        }

        long fullRepeats = n / s.length();
        long remaining = n % s.length();

        long total = fullRepeats * countInString;

        for (int i = 0; i < remaining; i++) {
            if (s.charAt(i) == 'a') total++;
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        long n = scanner.nextLong();

        System.out.println(repeatedString(s, n));
        scanner.close();
    }
}
```

---

## 9. Counting Valleys

### 🇺🇸 English Statement

Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. During his last hike he took exactly n steps. For every step he took, he noted if it was an uphill, U, or a downhill, D step. Gary's hikes start and end at sea level and each step up or down represents a 1 unit change in altitude.

A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level. A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.

Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.

For example, if Gary's path is s = [DDUUUUDD], he first enters a valley 2 units deep. Then he climbs out onto a mountain 2 units high. Finally, he returns to sea level and ends his hike.

**Function Description:** Complete the countingValleys function. It must return an integer that denotes the number of valleys Gary traversed.

**Parameters:** int n - the number of steps Gary takes; String s - a string describing his path

**Returns:** int - the number of valleys Gary traversed

**Constraints:** 2 <= n <= 10^6; s[i] is either 'U' or 'D'

### 🇪🇸 Traducción al Español

Gary es un excursionista ávido. Rastrea sus caminatas meticulosamente, prestando mucha atención a pequeños detalles como la topografía. Durante su última caminata dio exactamente n pasos. Para cada paso que dio, anotó si era un paso cuesta arriba, U, o cuesta abajo, D. Las caminatas de Gary comienzan y terminan al nivel del mar y cada paso arriba o abajo representa un cambio de 1 unidad en la altitud.

Una montaña es una secuencia de pasos consecutivos por encima del nivel del mar, comenzando con un paso hacia arriba desde el nivel del mar y terminando con un paso hacia abajo al nivel del mar. Un valle es una secuencia de pasos consecutivos por debajo del nivel del mar, comenzando con un paso hacia abajo desde el nivel del mar y terminando con un paso hacia arriba al nivel del mar.

Dada la secuencia de pasos de subida y bajada de Gary durante su última caminata, encuentra e imprime el número de valles por los que caminó.

Por ejemplo, si el camino de Gary es s = [DDUUUUDD], primero entra en un valle de 2 unidades de profundidad. Luego sube a una montaña de 2 unidades de altura. Finalmente, regresa al nivel del mar y termina su caminata.

**Descripción de la Función:** Completa la función countingValleys. Debe devolver un entero que denote el número de valles que Gary atravesó.

**Parámetros:** int n - el número de pasos que da Gary; String s - una cadena que describe su camino

**Retorna:** int - el número de valles que Gary atravesó

**Restricciones:** 2 <= n <= 10^6; s[i] es ya sea 'U' o 'D'

### 💻 Solución en Java

```java
import java.util.Scanner;

public class CountingValleys {
    public static int countingValleys(int n, String s) {
        int level = 0;
        int valleys = 0;
        boolean belowSea = false;

        for (char c : s.toCharArray()) {
            if (c == 'U') {
                level++;
            } else {
                level--;
            }

            if (level < 0 && !belowSea) {
                belowSea = true;
            }

            if (level == 0 && belowSea) {
                valleys++;
                belowSea = false;
            }
        }

        return valleys;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        System.out.println(countingValleys(n, s));
        scanner.close();
    }
}
```

---

## 10. Jumping on the Clouds

### 🇺🇸 English Statement

Emma is playing a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2. She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting position to the last cloud. It is always possible to win the game.

For each game, Emma will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided. For example, c = [0, 1, 0, 0, 0, 1, 0] indexed from 0...6. The number on each cloud is its index in the list so she must avoid the clouds at indexes 1 and 5. She could follow the following two paths: 0 -> 2 -> 4 -> 6 or 0 -> 2 -> 3 -> 4 -> 6. The first path takes 3 jumps while the second takes 4.

**Function Description:** Complete the jumpingOnClouds function. It should return the minimum number of jumps required, as an integer.

**Parameters:** int[] c - an array of binary integers

**Returns:** int - the minimum number of jumps required

**Constraints:** 2 <= n <= 100; c[i] is either 0 or 1; c[0] = c[n-1] = 0

### 🇪🇸 Traducción al Español

Emma está jugando un nuevo juego móvil que comienza con nubes numeradas consecutivamente. Algunas de las nubes son cabezas de tormenta y otras son cúmulos. Puede saltar a cualquier nube cúmulo que tenga un número igual al número de la nube actual más 1 o 2. Debe evitar las cabezas de tormenta. Determina el número mínimo de saltos que le tomará a Emma saltar desde su posición inicial hasta la última nube. Siempre es posible ganar el juego.

Para cada juego, Emma obtendrá un arreglo de nubes numeradas 0 si son seguras o 1 si deben evitarse. Por ejemplo, c = [0, 1, 0, 0, 0, 1, 0] indexado de 0...6. El número en cada nube es su índice en la lista, por lo que debe evitar las nubes en los índices 1 y 5. Podría seguir los siguientes dos caminos: 0 -> 2 -> 4 -> 6 o 0 -> 2 -> 3 -> 4 -> 6. El primer camino toma 3 saltos mientras que el segundo toma 4.

**Descripción de la Función:** Completa la función jumpingOnClouds. Debe devolver el número mínimo de saltos requeridos, como un entero.

**Parámetros:** int[] c - un arreglo de enteros binarios

**Retorna:** int - el número mínimo de saltos requeridos

**Restricciones:** 2 <= n <= 100; c[i] es ya sea 0 o 1; c[0] = c[n-1] = 0

### 💻 Solución en Java

```java
import java.util.Scanner;

public class JumpingOnClouds {
    public static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int i = 0;

        while (i < c.length - 1) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i += 2;
            } else {
                i += 1;
            }
            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        System.out.println(jumpingOnClouds(c));
        scanner.close();
    }
}
```

---

## 11. Arrays: Left Rotation (Alternative Implementation)

### 🇺🇸 English Statement

A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left. Given an integer, d, rotate the array that many steps left and return the result.

**Example:**
```
d = 2
arr = [1, 2, 3, 4, 5]
After 2 rotations: [3, 4, 5, 1, 2]
```

**Function Description:** Complete the rotLeft function.

**Parameters:** int[] a - the array to rotate; int d - the number of rotations

**Returns:** int[] - the rotated array

**Constraints:** 1 <= n <= 10^5; 1 <= d <= n

### 🇪🇸 Traducción al Español

Una operación de rotación izquierda en un arreglo de tamaño n desplaza cada uno de los elementos del arreglo 1 unidad hacia la izquierda. Dado un entero d, rota el arreglo esa cantidad de pasos a la izquierda y devuelve el resultado.

**Ejemplo:**
```
d = 2
arr = [1, 2, 3, 4, 5]
Después de 2 rotaciones: [3, 4, 5, 1, 2]
```

**Descripción de la Función:** Completa la función rotLeft.

**Parámetros:** int[] a - el arreglo a rotar; int d - el número de rotaciones

**Retorna:** int[] - el arreglo rotado

**Restricciones:** 1 <= n <= 10^5; 1 <= d <= n

### 💻 Solución en Java (Alternative - In-Place)

```java
import java.util.Scanner;

public class LeftRotationInPlace {
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int[] rotLeft(int[] a, int d) {
        int n = a.length;
        d = d % n;

        reverse(a, 0, d - 1);
        reverse(a, d, n - 1);
        reverse(a, 0, n - 1);

        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        rotLeft(a, d);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + (i < n - 1 ? " " : ""));
        }
        scanner.close();
    }
}
```

---

## 12. Ransom Note

### 🇺🇸 English Statement

Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use only whole words available in the magazine. He cannot use substrings or concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print "Yes" if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print "No".

For example, the note is "Attack at dawn". The magazine contains only "attack at dawn". The magazine has all the right words, but there's a case mismatch. The answer is "No".

**Function Description:** Complete the checkMagazine function. It must print "Yes" if the note can be formed using the magazine, or "No".

**Parameters:** String[] magazine - the words in the magazine; String[] note - the words in the ransom note

**Returns:** void - prints "Yes" or "No"

**Constraints:** 1 <= m, n <= 30000; 1 <= length of any word <= 5

### 🇪🇸 Traducción al Español

Harold es un secuestrador que escribió una nota de rescate, pero ahora le preocupa que pueda ser rastreado a través de su letra. Encontró una revista y quiere saber si puede recortar palabras completas de ella y usarlas para crear una réplica indetectable de su nota de rescate. Las palabras en su nota distinguen entre mayúsculas y minúsculas y debe usar solo palabras completas disponibles en la revista. No puede usar subcadenas o concatenación para crear las palabras que necesita.

Dadas las palabras en la revista y las palabras en la nota de rescate, imprime "Yes" si puede replicar su nota de rescate exactamente usando palabras completas de la revista; de lo contrario, imprime "No".

Por ejemplo, la nota es "Attack at dawn". La revista contiene solo "attack at dawn". La revista tiene todas las palabras correctas, pero hay una discrepancia de mayúsculas/minúsculas. La respuesta es "No".

**Descripción de la Función:** Completa la función checkMagazine. Debe imprimir "Yes" si la nota puede formarse usando la revista, o "No".

**Parámetros:** String[] magazine - las palabras en la revista; String[] note - las palabras en la nota de rescate

**Retorna:** void - imprime "Yes" o "No"

**Restricciones:** 1 <= m, n <= 30000; 1 <= longitud de cualquier palabra <= 5

### 💻 Solución en Java

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {
    public static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : magazine) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (String word : note) {
            if (!wordCount.containsKey(word) || wordCount.get(word) == 0) {
                System.out.println("No");
                return;
            }
            wordCount.put(word, wordCount.get(word) - 1);
        }

        System.out.println("Yes");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] magazine = scanner.nextLine().split(" ");
        String[] note = scanner.nextLine().split(" ");

        checkMagazine(magazine, note);
        scanner.close();
    }
}
```

---

## 13. Balanced Brackets

### 🇺🇸 English Statement

A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is balanced if the following conditions are met:
- It contains no unmatched brackets.
- The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.

Given n strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return "YES". Otherwise, return "NO".

**Function Description:** Complete the isBalanced function. It must return a string: "YES" if the sequence is balanced or "NO" if it is not.

**Parameters:** String s - a string of brackets

**Returns:** String - "YES" or "NO"

**Constraints:** 1 <= n <= 10^3; 1 <= |s| <= 10^3

### 🇪🇸 Traducción al Español

Un corchete se considera cualquiera de los siguientes caracteres: (, ), {, }, [, o ].

Dos corchetes se consideran un par coincidente si el corchete de apertura (es decir, (, [, o {) ocurre a la izquierda de un corchete de cierre (es decir, ), ], o }) del mismo tipo exacto. Hay tres tipos de pares coincidentes de corchetes: [], {}, y ().

Un par coincidente de corchetes no está balanceado si el conjunto de corchetes que encierra no está emparejado. Por ejemplo, {[(])} no está balanceado porque el contenido entre { y } no está balanceado. El par de corchetes cuadrados encierra un solo corchete de apertura no balanceado, (, y el par de paréntesis encierra un solo corchete de cierre cuadrado no balanceado, ].

Por esta lógica, decimos que una secuencia de corchetes está balanceada si se cumplen las siguientes condiciones:
- No contiene corchetes sin emparejar.
- El subconjunto de corchetes encerrados dentro de los límites de un par coincidente de corchetes también es un par coincidente de corchetes.

Dadas n cadenas de corchetes, determina si cada secuencia de corchetes está balanceada. Si una cadena está balanceada, devuelve "YES". De lo contrario, devuelve "NO".

**Descripción de la Función:** Completa la función isBalanced. Debe devolver una cadena: "YES" si la secuencia está balanceada o "NO" si no lo está.

**Parámetros:** String s - una cadena de corchetes

**Retorna:** String - "YES" o "NO"

**Restricciones:** 1 <= n <= 10^3; 1 <= |s| <= 10^3

### 💻 Solución en Java

```java
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return "NO";
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            System.out.println(isBalanced(s));
        }
        scanner.close();
    }
}
```

---

## 14. Maximum Element

### 🇺🇸 English Statement

You have an empty sequence, and you will be given N queries. Each query is one of these three types:

1. Push the element x into the stack.
2. Delete the element present at the top of the stack.
3. Print the maximum element in the stack.

**Input Format:** The first line of input contains an integer, N. The next N lines each contain a query.

**Constraints:** 1 <= N <= 10^5; 1 <= x <= 10^9

**Output Format:** For each type 3 query, print the maximum element in the stack on a new line.

### 🇪🇸 Traducción al Español

Tienes una secuencia vacía y se te darán N consultas. Cada consulta es uno de estos tres tipos:

1. Empuja el elemento x a la pila.
2. Elimina el elemento presente en la parte superior de la pila.
3. Imprime el elemento máximo en la pila.

**Formato de Entrada:** La primera línea de entrada contiene un entero, N. Las siguientes N líneas contienen cada una una consulta.

**Restricciones:** 1 <= N <= 10^5; 1 <= x <= 10^9

**Formato de Salida:** Para cada consulta de tipo 3, imprime el elemento máximo en la pila en una nueva línea.

### 💻 Solución en Java

```java
import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();

            if (type == 1) {
                int x = scanner.nextInt();
                stack.push(x);
                if (maxStack.isEmpty() || x >= maxStack.peek()) {
                    maxStack.push(x);
                }
            } else if (type == 2) {
                int removed = stack.pop();
                if (removed == maxStack.peek()) {
                    maxStack.pop();
                }
            } else if (type == 3) {
                System.out.println(maxStack.peek());
            }
        }
        scanner.close();
    }
}
```

---

## 15. Equal Stacks

### 🇺🇸 English Statement

You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they are all the same height, then return the height.

**Function Description:** Complete the equalStacks function. It must return an integer representing the maximum possible height of equal stacks.

**Parameters:** int[] h1 - the heights of cylinders in stack 1; int[] h2 - the heights of cylinders in stack 2; int[] h3 - the heights of cylinders in stack 3

**Returns:** int - the height of the stacks when they are equalized

**Constraints:** 0 <= n1, n2, n3 <= 10^5; 0 <= height of any cylinder <= 100

### 🇪🇸 Traducción al Español

Tienes tres pilas de cilindros donde cada cilindro tiene el mismo diámetro, pero pueden variar en altura. Puedes cambiar la altura de una pila eliminando y descartando su cilindro superior cualquier número de veces.

Encuentra la altura máxima posible de las pilas de tal manera que todas las pilas tengan exactamente la misma altura. Esto significa que debes eliminar cero o más cilindros de la parte superior de cero o más de las tres pilas hasta que todas tengan la misma altura, luego devuelve la altura.

**Descripción de la Función:** Completa la función equalStacks. Debe devolver un entero que represente la altura máxima posible de pilas iguales.

**Parámetros:** int[] h1 - las alturas de los cilindros en la pila 1; int[] h2 - las alturas de los cilindros en la pila 2; int[] h3 - las alturas de los cilindros en la pila 3

**Retorna:** int - la altura de las pilas cuando están igualadas

**Restricciones:** 0 <= n1, n2, n3 <= 10^5; 0 <= altura de cualquier cilindro <= 100

### 💻 Solución en Java

```java
import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {
    public static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i = h1.length - 1; i >= 0; i--) {
            sum1 += h1[i];
            s1.push(sum1);
        }
        for (int i = h2.length - 1; i >= 0; i--) {
            sum2 += h2[i];
            s2.push(sum2);
        }
        for (int i = h3.length - 1; i >= 0; i--) {
            sum3 += h3[i];
            s3.push(sum3);
        }

        while (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
            int top1 = s1.peek();
            int top2 = s2.peek();
            int top3 = s3.peek();

            if (top1 == top2 && top2 == top3) {
                return top1;
            }

            if (top1 >= top2 && top1 >= top3) {
                s1.pop();
            } else if (top2 >= top1 && top2 >= top3) {
                s2.pop();
            } else {
                s3.pop();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        for (int i = 0; i < n1; i++) h1[i] = scanner.nextInt();
        for (int i = 0; i < n2; i++) h2[i] = scanner.nextInt();
        for (int i = 0; i < n3; i++) h3[i] = scanner.nextInt();

        System.out.println(equalStacks(h1, h2, h3));
        scanner.close();
    }
}
```

---

> **Nota:** Estas preguntas fueron recopiladas de las secciones más populares de HackerRank, incluyendo el Interview Preparation Kit, Warm-up Challenges, y los tracks de Arrays, Strings, Stacks & Queues, y más. Las soluciones están optimizadas para complejidad temporal y espacial.

> **Fuente de referencia:** HackerRank Interview Preparation Kit y Practice Tracks (2026)
