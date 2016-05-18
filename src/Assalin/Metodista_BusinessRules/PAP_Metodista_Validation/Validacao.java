package Metodista_BusinessRules.PAP_Metodista_Validation;

public abstract class Validacao {

    public static boolean validarCampoNulo(String campo) {
        if (!campo.equals("")) {
            return true;
        }

        return false;
    }

    public static boolean validarCPF(String cpf) {
        if (validarCampoNulo(cpf)) { //Se não for vazio...
            if (cpf.matches("\\s")) { //Se cpf possuir espaço...
                return false;
            }
        }

        return false;
    }

    public static boolean validarCNPJ(String cnpj) {
        if (validarCampoNulo(cnpj)) { //Se não for vazio...
            final String formatoCNPJ = "";

            if (!cnpj.matches(formatoCNPJ)) {
                return false;
            } else {
            }
        }

        return false;
    }

    public static boolean validarCEP(String cep) {
        if (validarCampoNulo(cep)) { //Se não for vazio...
            final String formatoCEP = "\\d{5}-\\d{3}"; //5 digitos + - + 3 digitos...

            if (!cep.matches(formatoCEP)) { //Se CEP for diferente do formato acima...
                return false;
            } else {
            }
        }

        return false;
    }

    public static boolean validarTelefone(String telefone) {
        if (validarCampoNulo(telefone)) { //Se não for vazio...
            final String formatoTelefone1 = "(\\d{2})\\d{4}-\\d{4}"; //(2 digitos)4 digitos + - + 4 digitos...

            if (!telefone.matches(formatoTelefone1)) {
                return false;
            } else {
            }
        }

        return false;
    }

    public static boolean validarCelular(String celular) {
        if (validarCampoNulo(celular)) { //Se não for vazio...
            final String formatoCelular1 = "(\\d{2})\\d{4}-\\d{4}"; //(2 digitos)4 digitos + - + 4 digitos...
            final String formatoCelular2 = "(\\d{2})\\d{5}-\\d{4}"; //(2 digitos)5 digitos + - + 4 digitos...

            if (!celular.matches(formatoCelular1) || !celular.matches(formatoCelular2)) {
                return false;
            } else {
            }
        }

        return false;
    }

    public static boolean validarEmail(String email) {
        if (validarCampoNulo(email)) { //Se não for vazio...
            final String formatoEmail1 = "\\w+@\\w+\\.\\w{2,3}\\.\\w{2,3}"; //Qualquer coisa + @ + qualquer coisa + . + qualquer coisa com 2 ou 3 caracteres + . + qualquer coisa com 2 ou 3 caracteres...
            final String formatoEmail2 = "\\w+@\\w+\\.\\w{2,3}"; //Qualquer coisa + @ + qualquer coisa + . + qualquer coisa com 2 ou 3 caracteres...

            if (!email.matches(formatoEmail1) || !email.matches(formatoEmail2)) {
                return false;
            } else {
            }
        }

        return false;
    }

}
