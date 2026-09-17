package com.example.demo.usecase;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class CreateGreetingUseCaseTest {

    private final CreateGreetingUseCase useCase = new CreateGreetingUseCase();

    @Test
    void shouldCreateGreetingForRecipient() {
        // Given
        var recipient = "  Andrea  ";

        // When
        var greeting = useCase.create(recipient);

        // Then
        assertThat(greeting.recipient()).isEqualTo("Andrea");
        assertThat(greeting.message()).isEqualTo("Hola, Andrea!");
    }

    @Test
    void segundoMayor(){

        int[] number = {10, 5, 8, 10, 3, 7};
        Integer max = null;
        Integer maxTwo = null;
       for(int num : number ) {  // for (int num : numeros) {
           if (max == null || num > max){
               maxTwo = max;
               max= num;
           } else if (num < max && (maxTwo == null || num > maxTwo)){
               maxTwo = num;
           }
       }
        System.out.println("El segundo número más grande es: " + maxTwo);
    }
/*
    @Test
    void segundoNumeroMayor(){

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] number = new int[n];

        for (int i = 0; i < n; i++) {
            number[i] = scanner.nextInt();
        }

        Integer max = null;
        Integer secondMax = null;

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            if (max == null || num > max) {
                secondMax = max;
                max = num;
            } else if (num < max && (secondMax == null || num > secondMax)) {
                secondMax = num;
            }
        }
    }*/


    ////////////////

    @Test
    void primerCharactersQueNoSeRepite() {

        String  word = "lolaste";
        int index = -1;

        if (word == null || word.isEmpty()) {
            System.out.println(-1);
        }

        int[] frecuencias = new int[26];

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            frecuencias[c - 'a']++;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (frecuencias[c - 'a'] == 1) {

               // return i; // <--- Detenemos y devolvemos el índice

                index = i;
                break;
            }
        }

        // Si todos se repiten o no hay ninguno único
        System.out.println("------" + index);

        //return -1; // No hay ningún carácter único

    }

    public class Solution {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt();

            int[] number = new int[n];

            for (int i = 0; i < n; i++) {
                number[i] = scanner.nextInt();
            }


            //int[] number = {10, 5, 8, 10, 3, 7};
            Integer max = null;
            Integer maxTwo = null;
            for(int num : number ) {  // for (int num : numeros) {
                if (max == null || num > max){
                    maxTwo = max;
                    max= num;
                } else if (num < max && (maxTwo == null || num > maxTwo)){
                    maxTwo = num;
                }
            }
            System.out.println("El segundo número más grande es: " + maxTwo);
        }
    }


        public static int primerCaracterNoRepetido(String s) {
            if (s == null || s.isEmpty()) {
                return -1;
            }

            // 1. Contar frecuencias en tiempo O(n)
            Map<Character, Integer> conteo = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                conteo.put(c, conteo.getOrDefault(c, 0) + 1);
            }

            // 2. Buscar el primer carácter con frecuencia 1 en tiempo O(n)
            for (int i = 0; i < s.length(); i++) {
                if (conteo.get(s.charAt(i)) == 1) {
                    return i;
                }
            }

            return -1;
        }


    @Test
    void name() {
       boolean isAnagram = asAnagram("llols", "lollp");

       if (isAnagram){
           System.out.println("is anagrama");
       }else {
           System.out.println("no es nagrama");
       }
    }

    private boolean asAnagram (String s1 , String s2){
        if (s1 == null || s2 == null || s1.length() != s2.length() || s1.isEmpty() ) {

            return  false;
        }

        // Ignoramos mayúsculas/minúsculas
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();


        // Arreglo fijo para las 26 letras del abecedario (Espacio O(1))
        int[] frecuencias = new int[26];

        // Recorremos ambas cadenas a la vez (O(n))
        for (int i = 0; i < s1.length(); i++) {
            // Sumamos para s1, restamos para s2
            frecuencias[s1.charAt(i) - 'a']++;
            frecuencias[s2.charAt(i) - 'a']--;
        }

        // Si todas las posiciones quedan en 0, tienen las mismas frecuencias
        for (int count : frecuencias) {
            if (count != 0) {
                return false;
            }
        }
        return true;

    }


    @Test
    void longitudSubcadenaMasLargaSinRepetidosTest() {
        int stringMax = longitudSubcadenaMasLargaSinRepetidos("abcabcbb");getClass();
        int stringMaxTwo = longitudSubcadenaMasLargaSinRepetidosDos("abcabcbb");getClass();

        System.out.println("Cadena mas larga " + stringMax );
        System.out.println("Cadena mas larga " + stringMaxTwo );

    }


    public int  longitudSubcadenaMasLargaSinRepetidos (String s){

            if (s == null || s.isEmpty()) {
                return 0;
            }

        Map<Character, Integer> ultimoIndice = new HashMap<>();
        int izquierda = 0;
        int maxLongitud = 0;

        for (int derecha = 0; derecha < s.length(); derecha++) {
            char c = s.charAt(derecha);
            if (ultimoIndice.containsKey(c)) {
                izquierda = Math.max(izquierda, ultimoIndice.get(c) + 1);
            }
            ultimoIndice.put(c, derecha);
            maxLongitud = Math.max(maxLongitud, derecha - izquierda + 1);
        }
        return maxLongitud;
    }



        public static int longitudSubcadenaMasLargaSinRepetidosDos(String s) {
            if (s == null || s.isEmpty()) return 0;
            Set<Character> caracteres = new HashSet<>();
            int maxLongitud = 0;
            int inicio = 0;

            for (int fin = 0; fin < s.length(); fin++) {
                while (caracteres.contains(s.charAt(fin))) {
                    caracteres.remove(s.charAt(inicio));
                    inicio++;
                }
                caracteres.add(s.charAt(fin));
                maxLongitud = Math.max(maxLongitud, fin - inicio + 1);
            }
            return maxLongitud;
        }


}

