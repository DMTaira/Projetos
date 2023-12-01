

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import static java.lang.Math.*;

public class BaseNumericaCase2 {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        double numero = 0, conversor = 0, resto = 0;
        int binario = 2, octal = 8, hexa = 16, quinario = 5, duodecimal = 12, vigesimal = 20, sexagesimal = 60;
        String[] stringArrayBinario = new String[16], stringArrayOctal = new String[8], stringArrayHexadecimal = new String[4];
        String stringConversao = new String(), reversedStr = new String();

        String stringBinario = new String(), stringOctal = new String(), stringHexadecimal = new String();
        String stringQuinario = new String(), stringDuodecimal = new String(), stringSexagesimal = new String(), stringVigesimal = new String();
        int operacaoDesejada;

        System.out.println("*************  Conversor de Numeros em bases Numéricas   *********");
        System.out.println("Entre com a operação desejada: ");

        System.out.println("1 - Quinária -> Duodecimal + Vigesimal + Sexagesimal");
        System.out.println("2 - Duodecimal -> Quinária + Vigesimal + Sexagesimal");
        System.out.println("3 - Vigesimal -> Quinária + Duodecimal + Sexagesimal");
        System.out.println("4 - Sexagesimal -> Quinária + Duodecimal + Vigesimal");
        operacaoDesejada = reader.nextInt();

        switch (operacaoDesejada) {
            case 1:

                System.out.println("Entre com o numero Quinário: ");
                stringQuinario = reader.next();
                stringConversao = "";
                numero = conversorParaDecimal (stringQuinario,quinario);
                System.out.printf("\nRepresentação Decimal do Quinário %21s =  %13.0f",stringQuinario, numero);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, duodecimal);
                System.out.printf("\nRepresentação Duodecimal do Quinário %18s = %14s", stringQuinario, stringConversao);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, vigesimal);
                System.out.printf("\nRepresentação Vigesimal do Quinário %19s = %14s", stringQuinario, stringConversao);

                stringConversao = "";
                double [] hhmmss = conversaoSexagesimal(numero, sexagesimal);
                NumberFormat nf = new DecimalFormat("00");

                System.out.printf("\nRepresentação Sexagesimal do Quinário %17s =       ", stringQuinario);
                System.out.println(nf.format(hhmmss[0]) + ":" + nf.format(hhmmss[1])+ ":" + nf.format(hhmmss[2]));

                break;
            case 2:
                System.out.println("Entre com o número Duodecimal: ");
                stringDuodecimal = reader.next().toUpperCase();
                stringConversao = "";
                numero = conversorParaDecimal (stringDuodecimal,duodecimal);
                System.out.printf("\nRepresentação Decimal do Duodecimal   %17s =       %8.0f",stringDuodecimal, numero);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, quinario);
                System.out.printf("\nRepresentação Quinária do Duodecimal  %17s = %14s", stringDuodecimal, stringConversao);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, vigesimal);
                System.out.printf("\nRepresentação Vigesimal do Duodecimal %17s = %14s", stringDuodecimal, stringConversao);

                hhmmss = conversaoSexagesimal(numero, sexagesimal);
                nf = new DecimalFormat("00");
                System.out.printf("\nRepresentação Sexagesimal do Duodecimal %17s =       ", stringDuodecimal);
                System.out.println(nf.format(hhmmss[0]) + ":" + nf.format(hhmmss[1])+ ":" + nf.format(hhmmss[2]));

                break;
            case 3:
                System.out.println("Entre com o numero Vigesimal: ");
                stringVigesimal = reader.next().toUpperCase();

                stringConversao = "";
                numero = conversorParaDecimal (stringVigesimal,vigesimal);
                System.out.printf("\nRepresentação Decimal do Vigesimal     %17s =       %9.0f",stringVigesimal, numero);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, quinario);
                System.out.printf("\nRepresentação Quinária do Vigesimal    %17s =  %14s", stringVigesimal, stringConversao);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, duodecimal);
                System.out.printf("\nRepresentação Duodecimal do Vigesimal  %17s =  %14s", stringVigesimal, stringConversao);

                hhmmss = conversaoSexagesimal(numero, sexagesimal);
                nf = new DecimalFormat("00");
                System.out.printf("\nRepresentação Sexagesimal do Vigesimal %17s =        ", stringVigesimal);
                System.out.println(nf.format(hhmmss[0]) + ":" + nf.format(hhmmss[1])+ ":" + nf.format(hhmmss[2]));


                break;
            case 4:
                System.out.println("Entre com o número Sexagesimal (formato xxx:xx:xx) : ");
                stringSexagesimal = reader.next().toUpperCase();

                stringConversao = "";
                numero = conversorParaDecimal (stringSexagesimal,sexagesimal);
                System.out.printf("\nRepresentação Decimal do Sexagesimal     %17s =         %9.0f",stringSexagesimal, numero);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, quinario);
                System.out.printf("\nRepresentação Quinária do Sexagesimal    %17s = %17s", stringSexagesimal, stringConversao);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, duodecimal);
                System.out.printf("\nRepresentação Duodecimal do Sexagesimal  %17s = %17s", stringSexagesimal, stringConversao);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, vigesimal);
                System.out.printf("\nRepresentação Sexagesimal do Vigesimal   %17s = %17s", stringSexagesimal, stringConversao);

                break;

        }

    }

    public static String conversaoDecimal(double numero, int tipoConversao) {
        double conversor = numero;
        int resto = 0;
        String[] stringArray = new String[17];
        String[] digitosBaseBinaHex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F","G","H","I","J"};
        String stringConversao = "", reversedStr = "" ;
        int i = 0;
        boolean end = false, chave = true;
        int index = 0;
        while (!end) {
            //resto = conversor % tipoConversao;
            stringArray[index] = digitosBaseBinaHex[(int) conversor % tipoConversao];
            index++;
            conversor = floor(conversor / tipoConversao);

            if (conversor == 0) {
                stringArray[index] = digitosBaseBinaHex[(int) conversor % tipoConversao];

                for (i = 0; i < stringArray.length; i++) {
                    if (stringArray[i] != null) {
                        stringConversao = stringConversao + stringArray[i];
                    }
                }
                end = true;
            }
            for (i = 0; i < stringConversao.length(); i++) {
                reversedStr = stringConversao.charAt(i) + reversedStr;

            }

        }
        return (reversedStr);
    }

    public static double[] conversaoSexagesimal(double numero, int tipoConversao) {
        double horas;
        double minutos;
        double segundos = 0;
        double [] hhmmss = new double [3];

        horas = Math.floor (numero / 3600);
        hhmmss [0] =  horas;
        minutos = Math.floor((numero - horas * 3600) / 60);
        hhmmss [1] = minutos;
        segundos = numero - (horas * 3600 + minutos * 60);
        hhmmss [2] = segundos;

        return (hhmmss);
    }


    public static double conversorParaDecimal (String stringEntrada,int tipoConversao) {

        double [] arrayNumEntrada = new double[17];
        int[] arrayIntHhMmSs = new int[3];
        String [] arrayStringHhMmSs = new String[3];
        double numero= 0;
        String reversedStr = new String();

        if (tipoConversao < 60) {

            for (int i = 0; i < stringEntrada.length(); i++) {
                reversedStr = stringEntrada.charAt(i) + reversedStr;
            }

            char[] arrayStringEntrada = reversedStr.toCharArray();

            for (int i = 0; i < stringEntrada.length(); i++) {

                if (arrayStringEntrada[i] == 'A') {
                    arrayNumEntrada[i] = 10;
                } else if (arrayStringEntrada[i] == 'B') {
                    arrayNumEntrada[i] = 11;
                } else if (arrayStringEntrada[i] == 'C') {
                    arrayNumEntrada[i] = 12;
                } else if (arrayStringEntrada[i] == 'D') {
                    arrayNumEntrada[i] = 13;
                } else if (arrayStringEntrada[i] == 'E') {
                    arrayNumEntrada[i] = 14;
                } else if (arrayStringEntrada[i] == 'F') {
                    arrayNumEntrada[i] = 15;
                } else if (arrayStringEntrada[i] == 'G') {
                    arrayNumEntrada[i] = 16;
                } else if (arrayStringEntrada[i] == 'H') {
                    arrayNumEntrada[i] = 17;
                } else if (arrayStringEntrada[i] == 'I') {
                    arrayNumEntrada[i] = 18;
                } else if (arrayStringEntrada[i] == 'J') {
                    arrayNumEntrada[i] = 19;
                } else {
                    arrayNumEntrada[i] = Integer.parseInt(String.valueOf(arrayStringEntrada[i]));
                }
                numero = numero + (arrayNumEntrada[i] * pow(tipoConversao, i));
            }
        } else {
            arrayStringHhMmSs = stringEntrada.split(":");
            for (int i = 0; i < arrayIntHhMmSs.length; i++) {
                arrayIntHhMmSs[i] = Integer.parseInt(String.valueOf(arrayStringHhMmSs[i]));
                numero = numero + arrayIntHhMmSs[i] * Math.pow(tipoConversao,arrayIntHhMmSs.length-i-1);
            }
        }
        return (numero);
    }
}

