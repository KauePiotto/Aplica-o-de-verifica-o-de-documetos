package ado04;

import javax.swing.JOptionPane;

public class Utilitario {

	// Validação CNPJ
	public static boolean validarCNPJ(String cnpj) {

		boolean valida = true;
		String cnpjLimpo = limparCNPJ(cnpj);
		String cnpjSemDigitos = cnpjLimpo.substring(0, 12);
		String digito1 = "", digito2 = "";
		int soma = 0, mult1 = 5, mult2 = 6, resto;

		// Calcular primeiro digito do CNPJ
		for (int i = 0; i < cnpjSemDigitos.length(); i++) {
			if (i < 4) {
				soma += mult1 * Integer.parseInt(cnpjSemDigitos.charAt(i) + "");
				mult1--;
				continue;
			} else if (i == 4) {
				mult1 = 9;
				soma += mult1 * Integer.parseInt(cnpjSemDigitos.charAt(i) + "");
				mult1--;
				continue;
			} else {
				soma += mult1 * Integer.parseInt(cnpjSemDigitos.charAt(i) + "");
				mult1--;
				continue;
			}
		}

		resto = soma % 11;

		if (resto < 2) {
			digito1 = "" + 0;
		} else {
			digito1 = "" + (11 - resto);
		}

		cnpjSemDigitos += digito1;

		soma = 0;

		// Calcula o segundo digito do CNPJ
		for (int i = 0; i < cnpjSemDigitos.length(); i++) {
			if (i < 5) {
				soma += mult2 * Integer.parseInt(cnpjSemDigitos.charAt(i) + "");
				mult2--;
			} else if (i == 5) {
				mult2 = 9;
				soma += mult2 * Integer.parseInt(cnpjSemDigitos.charAt(i) + "");
				mult2--;
			} else {
				soma += mult2 * Integer.parseInt(cnpjSemDigitos.charAt(i) + "");
				mult2--;
			}
		}

		resto = soma % 11;
		if (resto < 2) {
			digito2 = "" + 0;
		} else {
			digito2 = "" + (11 - resto);
		}

		// Verifica se os digitos calculados sao iguais aos digitos do CNPJ Fornecido
		String cnpjCalculado = cnpjSemDigitos + digito2;
		if (!cnpjLimpo.equals(cnpjCalculado)) {
			valida = false;
		}
		return valida;
	}

	// Metodo para limpar o CNPJ antes de calcular os digitos
	private static String limparCNPJ(String cnpj) {
		String cnpjLimpo = "";

		for (int i = 0; i < cnpj.length(); i++) {
			if (cnpj.charAt(i) == '.' || cnpj.charAt(i) == '/' || cnpj.charAt(i) == '-') {
				continue;
			} else {
				cnpjLimpo += cnpj.charAt(i);
			}
		}
		return cnpjLimpo;
	}

	// Validação CPF
	public static boolean ValidarCPF(String CPF) {

		boolean valida = false;
		String CPFlimpo = LimparCPF(CPF);
		String CPFsemDigitos = CPFlimpo.substring(0, 11);
		String digito1 = "", digito2 = "";
		String cpfCalculado;
		int soma = 0, mult1 = 9, mult2 = 10, resto;

		// Calcula o primeiro digito do CPF
		for (int i = 0; i < CPFsemDigitos.length(); i++) {
			if (i < 2) {
				soma += mult1 * Integer.parseInt(CPFsemDigitos.charAt(i) + "");
				mult1--;
				continue;
			} else if (i == 2) {
				mult1 = 6;
				soma += mult1 * Integer.parseInt(CPFsemDigitos.charAt(i) + "");
				mult1--;
				continue;
			} else {
				soma += mult1 * Integer.parseInt(CPFsemDigitos.charAt(i) + "");
				mult1--;
				continue;
			}
		}

		resto = soma % 11;
		if (resto < 2) {
			digito1 = "" + 0;
		} else {
			digito1 = "" + (11 - resto);
		}

		CPFsemDigitos += digito1;

		soma = 0;
				
		// Calcula o segundo digito do CPF
		for (int i = 0; i < CPFsemDigitos.length(); i++) {
			if (i < 10) {
				soma += mult2 * Integer.parseInt(CPFsemDigitos.charAt(i) + "");
				mult2--;
				continue;
			} else if (i == 10) {
				mult2 = 7;
				soma += mult2 * Integer.parseInt(CPFsemDigitos.charAt(i) + "");
				mult1--;
				continue;
			} else {
				soma += mult2 * Integer.parseInt(CPFsemDigitos.charAt(i) + "");
				mult2--;
				continue;
			}
		}

		resto = soma % 11;
		if (resto < 2) {
			digito2 = "" + 0;
		} else {
			digito2 = "" + (11 - resto);
		}

		// Verifica se os digitos calculados sao iguais aos digitos do CPF Fornecido
		cpfCalculado = CPFsemDigitos + digito2;

		if (!CPFlimpo.equals(cpfCalculado)) {
			valida = false;
		}
		return valida;
	}

	// Metodo para limpar o CPF antes de calcular os digitos
	private static String LimparCPF(String CPF) {
		String CPFlimpo = "";

		for (int i = 0; i < CPF.length(); i++) {
			if (CPF.charAt(i) == '.' || CPF.charAt(i) == '.' || CPF.charAt(i) == '-')
				continue;

			CPFlimpo += CPF.charAt(i);
		}
		return CPFlimpo;
	}

	// Validação RG

	// Validação IE

	public static void main(String[] args) {
		int opcao;

		opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
				"1 - Validação CNPJ\n 2 - Validação CPF\n 3 - Validação RG\n 4 - Validação IE"));

		switch (opcao) {
		case 1:// CNPJ
			String cnpj = JOptionPane.showInputDialog("Digite o CNPJ", "11.222.333/0001-81");

			if (Utilitario.validarCNPJ(cnpj))
				JOptionPane.showMessageDialog(null, "cnpj: " + cnpj + " válido!");
			else
				JOptionPane.showMessageDialog(null, "cnpj: " + cnpj + " Inválido!");
			break;
		case 2:// CPF
			String CPF = JOptionPane.showInputDialog("Digite o CPF", "532.407.820-49");

			if (Utilitario.ValidarCPF(CPF))
				JOptionPane.showMessageDialog(null, "CPF: " + CPF + " válido!");
			else
				JOptionPane.showMessageDialog(null, "CPF: " + CPF + " Inválido!");
			break;
		case 3:// RG

			break;
		case 4:// IE
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida, escolha das Opção acima");
			break;
		}

	}
}