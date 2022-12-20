/**
 * Nos mudamos
 * Tiempo máximo: 2,000 s Memoria máxima: 4096 KiB
 * Escuela
 * <p>
 * Desde hace unos años, el número de alumnos en mi colegio ha ido creciendo sin parar.
 * Primero se aumentó el número de alumnos por aula, pero luego hizo falta reconvertir
 * algunos espacios para que algunos grupos dieran clase ahí, como las gradas del gimnasio
 * o, este último curso, hasta el cuarto de las escobas.
 * <p>
 * El curso pasado las autoridades académicas consiguieron el presupuesto para construir
 * un nuevo edificio y comenzaron las obras. Por fin han concluido y el nuevo edificio
 * puede ya utilizarse, por lo que podemos mudarnos (el antiguo edificio va a rehabilitarse
 * y se utilizará para otra función), pero nos ha pillado a mitad de curso. El director
 * quiere saber si va a ser posible la mudanza sin que se dividan o junten grupos, o que
 * algunos alumnos tengan que cambiar de grupo.
 * Entrada
 * <p>
 * La entrada está formada por una serie de casos de prueba. Cada caso consta de tres
 * líneas. La primera contiene dos números: el número N de grupos actuales y el número M de
 * aulas en el nuevo edificio (ambos entre 1 y 100.000). La segunda línea contiene N números
 * que representan el tamaño de los grupos actuales, y la tercera contiene M números con los
 * tamaños de las nuevas aulas.
 * <p>
 * 3 líneas
 * - 1º cantGrupos cantAulas (ambas 1-100.000)
 * - lista tamaño grupos (grupos).
 * - lista tamaño aulas (aulas)
 * Salida
 * <p>
 * Para cada caso de prueba se escribirá una línea que contendrá "SI" si es posible asignar un
 * aula diferente, con capacidad suficiente, a cada uno de los grupos actuales, o NO en caso
 * contrario.
 * <p>
 * Entrada de ejemplo
 * <p>
 * 3 3          3 grupos    3 aulas nuevas
 * 10 20 30     1ºgrupo: 10 alumnos; 2º grupo: 20; 3º grupo 30
 * 31 12 20     1º tamaño aula: 31; 2º aula: 12; 3º aula: 20
 * 3 2
 * 10 20 30
 * 100 200
 * 3 4
 * 20 10 30
 * 20 20 50 40
 *
 * <p>
 * <p>
 * Salida de ejemplo
 * <p>
 * SI
 * NO
 * SI
 * <p>
 * <p>
 * Ejemplo real
 * * 3 3          3 grupos    3 aulas nuevas
 * * 10 20 30     1ºgrupo: 10 alumnos; 2º grupo: 20; 3º grupo 30
 * * 31 12 20     1º tamaño aula: 31; 2º aula: 12; 3º aula: 20
 * <p>
 * Según esto:
 * Hay aulas suficientes para todos grupos (sin ver tamaño)
 * grupo de 10 entra en aula de 12
 * grupo de 20 entra en aula de 20
 * grupo de 30 entra en aula de 31
 */

import java.util.Scanner;

public class Reto489 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // input 1º linea (Comprobamos salida)
            String input = sc.nextLine();
            if (input.isEmpty()  || input.startsWith("0") ) {
                break;
            }
            String[] cant = input.split(" ");
            int cantGrupos = Integer.parseInt(cant[0]);
            int cantAulas = Integer.parseInt(cant[1]);

            // input 2º linea lista alumnos/grupo
            String[] list = sc.nextLine().split(" ");
            int[] grupos = new int[cantGrupos];
            for (int i = 0; i < cantGrupos; i++) {
                grupos[i] = Integer.parseInt(list[i]);
            }
            // input 3º linea espacios/aula
            list = sc.nextLine().split(" ");
            int[] aulas = new int[cantAulas];
            for (int i = 0; i < cantAulas; i++) {
                aulas[i] = Integer.parseInt(list[i]);
            }
            // Analizar
            // comprobar que hay aulas suficientes para los grupos
            if (cantGrupos > cantAulas) {
                System.out.println("NO");

            } else { // Comprobar que las aulas tienen espacio para grupos
                // Recorremos grupos
                for (int g = 0; g < cantGrupos; g++) {
                    // System.out.println("grupo " + g + "(" + grupos[g] + "): ");

                    // Recorremos aulas
                    int elegido = -1;
                    for (int a = 0; a < cantAulas; a++) {
                        // System.out.println("\taula " + a + " (" + aulas[a] + "): ");

                        // Comprobamos que aula valga para grupo
                        if (grupos[g] <= aulas[a]) {
                            // System.out.println("\t\t- " + aulas[a] + " es válida");
                            // cogemos la primera que valga para grupo
                            if (elegido < 0) {
                                // System.out.println("\t\t- 1º eleccion " + aulas[a] + " es seleccionada");
                                elegido = a;
                            } else {
                                // cogemos la que sea más pequeña
                                if (aulas[elegido] >= aulas[a]) {
                                    // System.out.println("\t\t- otra eleccion " + aulas[a] + " es seleccionada");
                                    elegido = a;
                                } else {
                                    // System.out.println("\t\t- es mayor");
                                }
                            }

                        }

                    }
                    if (elegido >= 0) {
                        // System.out.println("\tAnulamos la opción elegida");
                        aulas[elegido] = 0;
                    }
                }
                boolean result = true;
                for (int i = 0; i < cantAulas; i++) {
                    if (aulas[i] != 0)
                        result = false;
                    break;
                }
                System.out.println((result ? "SI" : "NO"));
            }


        }
    }
}
