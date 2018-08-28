public static void Exercicio2 main(String[] args){
	System.out.print ("Digite um número de 1 a 7: ");
	//Entrada de Dados
	switch (args[0]){
		case (args[0] == 1){
			System.out.print ("Domingo");
			break;
		}
		case (args[0] == 2){
			System.out.print ("Segunda-Feria");
			break;
		}
		case (args[0] == 3){
			System.out.print ("Terça-Feira");
			break;
		}
		case (args[0] == 4){
			System.out.print ("Quarta-Feira");
			break;
		}
		case (args[0] == 5){
			System.out.print ("Quinta-Feira");
			break;
		}
		case (args[0] == 6){
			System.out.print ("Sexta-Feira");
			break;
		}
		case (args[0] == 7){
			System.out.print ("Sábado");
			break;
		}
	}
	return 0;
}