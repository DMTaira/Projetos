import java.util.Scanner;

import static java.lang.Math.floor;
import static java.lang.Math.pow;

public class BaseNumericaCase1 {

        public static void main(String[] args) {

            Scanner reader = new Scanner(System.in);
            double numero = 0, conversor = 0, resto = 0;
            int binario = 2, octal = 8, hexa = 16;
            String[] stringArrayBinario = new String[16], stringArrayOctal = new String[8], stringArrayHexadecimal = new String[4];
            String stringConversao = new String(), reversedStr = new String();
            String stringBinario = new String(), stringOctal = new String(), stringHexadecimal = new String();
            int operacaoDesejada;

            System.out.println("*************  Conversor de Numeros em bases Numéricas   *********");
            System.out.println("Entre com a operação desejada: ");
            System.out.println("1 - Decimal -> Binário + Octal + Hexadecimal");
            System.out.println("2 - Binário -> Decimal + Octal + Hexadecimal");
            System.out.println("3 - Octal -> Decimal + Binário + Hexadecimal");
            System.out.println("4 - Hexadecimal -> Decimal + Binário + Octal");

            operacaoDesejada = reader.nextInt();

            switch (operacaoDesejada) {
                case 1:
                    System.out.println("Entre com o numero Decimal (de 2 a 65535): ");
                    numero = reader.nextDouble();
                    break;
                case 2:
                    System.out.println("Entre com o número Binário: ");
                    stringBinario = reader.next();
                    break;
                case 3:
                    System.out.println("Entre com o numero Octal: ");
                    stringOctal = reader.next();
                    break;
                case 4:
                    System.out.println("Entre com o número Hexadecimal: ");
                    stringHexadecimal = reader.next().toUpperCase();
                    break;

            }
            if (operacaoDesejada == 1) {

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, binario);
                System.out.printf("\nRepresentação binária do decimal\t\t %5.0f = %17s", numero, stringConversao);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, octal);
                System.out.printf("\nRepresentação Octal do decimal\t\t\t %5.0f = %17s", numero, stringConversao);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, hexa);
                System.out.printf("\nRepresentação Hexadecimal do decimal\t %5.0f = %17s", numero, stringConversao);


            } else if (operacaoDesejada == 2) {
                stringConversao = "";
                numero = conversorParaDecimal (stringBinario,binario);
                System.out.printf("\nRepresentação Decimal do Binário\t %17s = \t\t\t %5.0f",stringBinario, numero);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, octal);
                System.out.printf("\nRepresentação Octal do Binário\t\t %17s = %17s", stringBinario, stringConversao);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, hexa);
                System.out.printf("\nRepresentação Hexadecimal do Binário %17s = %17s", stringBinario, stringConversao);

            } else if (operacaoDesejada == 3) {
                stringConversao = "";
                numero = conversorParaDecimal (stringOctal,octal);
                System.out.printf("\nRepresentação Decimal do Octal\t\t %17s = \t\t\t %5.0f",stringOctal, numero);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, binario);
                System.out.printf("\nRepresentação Binária do Octal\t\t %17s = %17s", stringOctal, stringConversao);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, hexa);
                System.out.printf("\nRepresentação Hexadecimal do Octal\t %17s = %17s", stringOctal, stringConversao);


            } else if (operacaoDesejada == 4) {
                stringConversao = "";
                numero = conversorParaDecimal (stringHexadecimal,hexa);
                System.out.printf("\nRepresentação Decimal do Hexadecimal\t %17s = \t\t\t %5.0f",stringHexadecimal, numero);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, binario);
                System.out.printf("\nRepresentação Binária do Hexadecimal\t %17s = %17s", stringHexadecimal, stringConversao);

                stringConversao = "";
                stringConversao = conversaoDecimal(numero, octal);
                System.out.printf("\nRepresentação Octal do Hexadecimal\t\t %17s = %17s", stringHexadecimal, stringConversao);

            }


        }

        public static String conversaoDecimal(double numero, int tipoConversao) {
            double conversor = numero;
            int resto = 0;
            String[] stringArray = new String[17];
            String[] digitosBaseBinaHex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
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

        public static double conversorParaDecimal (String stringEntrada,int tipoConversao) {

            double [] arrayNumEntrada = new double[17];
            double numero= 0;
            String reversedStr = new String();


            for (int i = 0; i < stringEntrada.length(); i++) {
                reversedStr = stringEntrada.charAt(i) + reversedStr;
            }

            char [] arrayStringEntrada= reversedStr.toCharArray();

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
                } else {
                    arrayNumEntrada[i] = Integer.parseInt(String.valueOf(arrayStringEntrada[i]));
                }
                numero = numero + (arrayNumEntrada[i] * pow(tipoConversao, i));
            }
            return (numero);
        }
}


