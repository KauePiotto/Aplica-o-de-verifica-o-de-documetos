//Kaue Piotto De Lima Freire
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
		String CPFsemDigitos = CPFlimpo.substring(0, 9);
		String digito1 = "", digito2 = "";
		String cpfCalculado;
		int soma = 0, mult1 = 10, mult2 = 11, resto;

		// Calcula o primeiro digito do CPF
		for (int i = 0; i < CPFsemDigitos.length(); i++) {
			soma += mult1 * Integer.parseInt(CPFsemDigitos.charAt(i) + "");
			mult1--;
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
			soma += mult2 * Integer.parseInt(CPFsemDigitos.charAt(i) + "");
			mult2--;
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
			valida = true;
		}
		return valida;
	}

	// Metodo para limpar o CPF antes de calcular os digitos
	private static String LimparCPF(String CPF) {
		String CPFlimpo = "";

		for (int i = 0; i < CPF.length(); i++) {
			if (CPF.charAt(i) == '.' || CPF.charAt(i) == '-')
				continue;

			CPFlimpo += CPF.charAt(i);
		}
		return CPFlimpo;
	}

	// Validação RG
	public static boolean ValidarRG(String RG) {
		boolean valida = false;
		String RgLimpo = LimparRG(RG);
		String RgSemDigitos = RgLimpo.substring(0, 8);
		String digito1 = "";
		String RgCalculado;
		int soma = 0, mult1 = 9, resto;

		// Calcula o digito do RG
		for (int i = 0; i < RgSemDigitos.length(); i++) {
			if (i < 8) {
				soma += mult1 * Integer.parseInt(RgSemDigitos.charAt(i) + "");
				mult1--;
			} else if (i == 8) {
				mult1 = 7;
				soma += mult1 * Integer.parseInt(RgSemDigitos.charAt(i) + "");
				mult1--;
			} else {
				soma += mult1 * Integer.parseInt(RgSemDigitos.charAt(i) + "");
				mult1--;
			}
		}

		resto = soma % 11;
		if (resto < 2) {
			digito1 = "" + 0;
		} else {
			digito1 = "" + (11 - resto);
		}

		// Verifica se os digitos calculados sao iguais aos digitos do RG Fornecido
		RgCalculado = RgSemDigitos + digito1;

		if (RgLimpo.equals(RgCalculado)) {
			valida = true;
		}
		return valida;
	}

	private static String LimparRG(String RG) {
		String RgLimpo = "";

		for (int i = 0; i < RG.length(); i++) {
			if (RG.charAt(i) == '.' || RG.charAt(i) == '-')
				continue;

			RgLimpo += RG.charAt(i);
		}
		return RgLimpo;
	}

	// Validação IE
	public static boolean ValidarIe(String IE) {
		boolean valida = false;
		String IeLimpo = LimparIe(IE);
		if (IeLimpo.length() != 12) {
			return false;
		}
		String IeSemDigitos = IeLimpo.substring(0, 8);
		String digito1 = "";
		String digito2 = "";
		int soma = 0, mult1 = 1, mult2 = 3, resto;

		// Cálculo do primeiro dígito verificador
		for (int i = 0; i < 8; i++) {
			soma += Character.getNumericValue(IeSemDigitos.charAt(i)) * mult1;
			mult1++;
			if (mult1 == 2) {
				mult1 = 3;
			} else if (mult1 == 9) {
				mult1 = 10;
			}
		}
		resto = soma % 11;
		digito1 = (resto == 10) ? "0" : String.valueOf(resto);

		// Cálculo do segundo dígito verificador
		soma = 0;
		for (int i = 0; i < 11; i++) {
			soma += Character.getNumericValue(IeLimpo.charAt(i)) * mult2;
			mult2--;
			if (mult2 == 1) {
				mult2 = 10;
			}
		}
		resto = soma % 11;
		digito2 = (resto == 10) ? "0" : String.valueOf(resto);

		// Verificação dos dígitos calculados com os dígitos fornecidos
		valida = digito1.equals(String.valueOf(IeLimpo.charAt(8)))
				&& digito2.equals(String.valueOf(IeLimpo.charAt(11)));

		return valida;
	}

	private static String LimparIe(String IE) {
		String IeLimpo = "";

		for (int i = 0; i < IE.length(); i++) {
			if (IE.charAt(i) == '.')
				continue;

			IeLimpo += IE.charAt(i);
		}
		return IeLimpo;
	}

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
			String RG = JOptionPane.showInputDialog("Digite o RG", "26.804.910-5");

			if (Utilitario.ValidarRG(RG))
				JOptionPane.showMessageDialog(null, "RG: " + RG + " válido!");
			else
				JOptionPane.showMessageDialog(null, "RG: " + RG + " Inválido!");
			break;
		case 4:// IE
			String IE = JOptionPane.showInputDialog("Digite a Inscrição Estadual", "667.172.314.769");

			if (Utilitario.ValidarRG(IE))
				JOptionPane.showMessageDialog(null, "Inscrição Estadual: " + IE + " válido!");
			else
				JOptionPane.showMessageDialog(null, "Inscrição Estadual: " + IE + " Inválido!");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida, escolha das Opção acima");
			break;
		}

	}
}